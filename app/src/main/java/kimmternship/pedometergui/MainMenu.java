package kimmternship.pedometergui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainMenu extends Activity{
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainmenu);

        Button LoginBtn = (Button) findViewById(R.id.loginBtn);
        Button CreateBtn = (Button) findViewById(R.id.createBtn);

        LoginBtn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {
                Intent loginscreen = new Intent(getApplicationContext(), LoginPage.class);
                startActivity(loginscreen);
            }
        });
        CreateBtn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {
                Intent createscreen = new Intent(getApplicationContext(), CreatePage.class);
                startActivity(createscreen);
            }
        });
    }
}
