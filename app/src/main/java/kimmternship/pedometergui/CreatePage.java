package kimmternship.pedometergui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import kimmternship.pedometergui.model.user;
import kimmternship.pedometergui.Sql.DatabaseHelper;


public class CreatePage extends Activity
{
    String value1,value2,uservalue;
    Button confirmcreatetn;
    TextView password,confirmpassword,username,gender,Hfeet,Hinches,genderoutput;
    private user tempUser = new user("","");
    private DatabaseHelper databaseHelper;
    private final Activity activity = CreatePage.this;
    SeekBar seekBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.createpage);
        setViews();
        makebuttons();
        initObjects();
        SeekerbarInit();
    }
    private void setViews() {
        confirmcreatetn = (Button) findViewById(R.id.confirmCreateBtn);
        password = (TextView) findViewById(R.id.EnterPasswordTextfield);
        username = (TextView) findViewById(R.id.CreateUserTextfield);
        confirmpassword = (TextView) findViewById(R.id.ReEnterPasswordTextfield);
        gender = (TextView) findViewById(R.id.GenderSelectedTextField);
        Hfeet = (TextView) findViewById(R.id.HeightFTTextfield);
        Hinches = (TextView) findViewById(R.id.HeightInchTextField);
        seekBar = (SeekBar) findViewById(R.id.Genderseekbar);
        genderoutput= (TextView) findViewById(R.id.GenderSelectedTextField);

    }
    private void makebuttons() {
        confirmcreatetn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                if(username.getText() == null || password.getText() == null||Hfeet.getText()==null||Hinches.getText()==null) {
                    uservalue = username.getText().toString();
                    value1 = password.getText().toString();
                    value2 = confirmpassword.getText().toString();
                    pushtoDB();
                }
                else  Toast.makeText(getApplicationContext(), "Reuired Field not filled", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void initObjects() { databaseHelper = new DatabaseHelper(activity);
    }
    private void pushtoDB() {
      if(!databaseHelper.checkifUserExists(uservalue)) {//hecks is username exists already
          if(value1.length()>5) {//ensures password is more then 5 characters
              if (value1.equals(value2)) {//ensures that password and confirm password matches
                  tempUser.setName(uservalue);
                  tempUser.setPassword(value1);

                  databaseHelper.addUser(tempUser);//pushes a user to database
                  Toast.makeText(this, "User has been created", Toast.LENGTH_SHORT).show();
                  Intent loginscreen = new Intent(getApplication(), LoginPage.class);
                  startActivity(loginscreen);
                  finish();
              } else Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show();
          }else Toast.makeText(this, "Password must be more then 5 Characters", Toast.LENGTH_SHORT).show();
      } else Toast.makeText(this, "Username Exists", Toast.LENGTH_SHORT).show();
    }

    private void SeekerbarInit() {
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progress = 0;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progresValue, boolean fromUser) {
                progress = progresValue;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                genderoutput.setText("");
            }
        });
    }
  }