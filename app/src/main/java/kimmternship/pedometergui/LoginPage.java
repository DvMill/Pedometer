package kimmternship.pedometergui;
import android.content.Context;
import android.content.Intent;
import android.app.Activity;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;

import kimmternship.pedometergui.Perferences.PrefManager;
import kimmternship.pedometergui.Sql.DatabaseHelper;
import kimmternship.pedometergui.model.user;

public class LoginPage extends Activity {
    user User= new user("","");
    Button ConfirmLoginBtn;
    String checkUser,checkPassword;
    private DatabaseHelper dbHelper;
    private PrefManager prefManager= new PrefManager(this);
    private final Activity activity = LoginPage.this;
    TextView incuserTextfield,incpasswordTextfield;
    Toast failure,badlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginpage);
        AlreadyLogggedIn();
        init();
        buttonactions();
        maketoasts();
    }
    public  void  AlreadyLogggedIn(){ // Checks if the user is already logged in to keep session alive.
        if(!prefManager.isUserLoggedOut()) { //calls the Prefmanager in order to check if a user had logged out or not
        Intent intent = new Intent(getApplicationContext(),MainApp.class);
        intent.putExtra("userid", User.getId());
            startActivity(intent);// goes to MainApp if the user is not logged out
            finish();
    }}

    public void init(){ ConfirmLoginBtn= (Button) findViewById(R.id.confirmLogin);
        incuserTextfield= (TextView) findViewById(R.id.loginusernameField);
        incpasswordTextfield= (TextView) findViewById(R.id.loginpasswordField);
        dbHelper=new DatabaseHelper(activity);
        Button CreateBtn = (Button) findViewById(R.id.createBtn);
        CreateBtn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {
                Intent createscreen = new Intent(getApplicationContext(), CreatePage.class);
                startActivity(createscreen);
            }
        });
    }//sets all the  defined varaibles

    public void buttonactions() {

        ConfirmLoginBtn.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View arg0)
            {
                checkUser =incuserTextfield.getText().toString();
                checkPassword =incpasswordTextfield.getText().toString();
                User.setName(checkUser); User.setPassword(checkPassword);
                if(User.getName().isEmpty()||User.getPassword().isEmpty()) badlogin.show();
                else{
                if (dbHelper.checkifExists(checkUser,checkPassword))
                {
                    Intent intent = new Intent(getApplicationContext(),MainApp.class);
                    intent.putExtra("user", User.getId());
                    prefManager.saveLoginDetails(User);
                    startActivity(intent);
                    finish();
                }
                else failure.show();}
            }
        });
    }//check what happens when the login button is created. Checks the atabase if a user actually exists
    private void maketoasts() {
        failure = Toast.makeText(this, "User or Password does not match", Toast.LENGTH_SHORT);
        badlogin = Toast.makeText(this, "A required Field is empty", Toast.LENGTH_SHORT);

    } //makes Toasts to display messages
}
