package kimmternship.pedometergui;
import android.content.Context;
import android.content.Intent;
import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import kimmternship.pedometergui.Sql.DatabaseHelper;

public class LoginPage extends Activity {
    Button ConfirmLoginBtn;
    String checkUser,checkPassword;
    private DatabaseHelper dbHelper;
    private final Activity activity = LoginPage.this;
    TextView incuserTextfield,incpasswordTextfield;
    Context context;
    Toast failure,badlogin;
    final SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
    public static final String EXTRA_MESSAGE = "kimmternship.pedometergui.Username";
    Boolean Registered = sharedPref.getBoolean("Registered", false);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginpage);
        UserLoggedIn();
        init();
        buttonactions();
        maketoasts();
    }
    public void UserLoggedIn() {
        if (Registered) {
            Intent intent = new Intent(getApplicationContext(),MainApp.class);
            intent.putExtra(EXTRA_MESSAGE, checkUser);
            startActivity(intent);
            finish();
        }
    }
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
    }

    public void buttonactions() {

        ConfirmLoginBtn.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View arg0)
            {
                checkUser =incuserTextfield.getText().toString();
                checkPassword =incpasswordTextfield.getText().toString();
                if(checkUser.isEmpty()||checkPassword.isEmpty()) badlogin.show();
                else{
                if (dbHelper.checkifExists(checkUser,checkPassword))
                {
                    Intent intent = new Intent(getApplicationContext(),MainApp.class);
                    intent.putExtra(EXTRA_MESSAGE, checkUser);
                    startActivity(intent);
                    finish();
                }
                else failure.show();}
            }
        });
    }
    private void maketoasts() {
        failure = Toast.makeText(this, "User or Password does not match", Toast.LENGTH_SHORT);
        badlogin = Toast.makeText(this, "A required Field is empty", Toast.LENGTH_SHORT);
    }
}
