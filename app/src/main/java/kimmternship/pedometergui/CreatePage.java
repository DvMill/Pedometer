package kimmternship.pedometergui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import kimmternship.pedometergui.model.user;
import kimmternship.pedometergui.Sql.DatabaseHelper;


public class CreatePage extends Activity
{
    String value1,value2,uservalue;
    Button confirmcreatetn;
    TextView password,confirmpassword,username;
    private user tempUser = new user("","");
    private DatabaseHelper databaseHelper;
    private final Activity activity = CreatePage.this;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.createpage);
        setViews();
        makebuttons();
        initObjects();
    }
    private void setViews() {
        confirmcreatetn = (Button) findViewById(R.id.confirmCreateBtn);
        password = (TextView) findViewById(R.id.EnterPasswordTextfield);
        username = (TextView) findViewById(R.id.CreateUserTextfield);
        confirmpassword = (TextView) findViewById(R.id.ReEnterPasswordTextfield);
    }
    private void makebuttons() {
        confirmcreatetn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {
                uservalue = username.getText().toString();
                value1 = password.getText().toString();
                value2 = confirmpassword.getText().toString();
               pushtoDB();
            }
        });
    }
    private void initObjects() { databaseHelper = new DatabaseHelper(activity);
    }
    private void pushtoDB() {
        // TODO: methods to check if the user already exists and to check if passwords meets a certain requirement
        if(value1.equals(value2))
        {
            tempUser.setName(uservalue);
            tempUser.setPassword(value1);
            databaseHelper.addUser(tempUser);
            Toast.makeText(this, "User has been created", Toast.LENGTH_SHORT).show();
            Intent loginscreen = new Intent(getApplication(), LoginPage.class);
            startActivity(loginscreen);
            finish();
        }
        else Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show();
    }

}