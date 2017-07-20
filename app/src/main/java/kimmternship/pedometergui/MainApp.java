package kimmternship.pedometergui;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import kimmternship.pedometergui.Perferences.PrefManager;
import kimmternship.pedometergui.Sql.DatabaseHelper;
import kimmternship.pedometergui.model.user;

public class MainApp extends AppCompatActivity {
    user User = new user("", "");
    private DatabaseHelper dbHelper;
    private PrefManager prefManager = new PrefManager(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainapplayout);
        getusernamefromLogin();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void getusernamefromLogin() {
        SharedPreferences settings = getSharedPreferences("userid",0);
        int tempid = settings.getInt("userid",0);
        TextView textView = (TextView) findViewById(R.id.mainlayoutUsernameDisplay);
        textView.setText("Welcome "+tempid);
    }


    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.toolbar_logout:
                Intent loginscreen = new Intent(getApplication(), LoginPage.class);
                prefManager.blankusr();
                startActivity(loginscreen);
                finish();
                break;
            case R.id.toolbar_UserDetails:
                Intent userdetailscreen = new Intent(getApplication(), UserDetailsPage.class);
                startActivity(userdetailscreen);
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return super.onOptionsItemSelected(item);
    }
}

    // TODO: Check if a user has information stored on a seperate database. Connect the databases using a left join

    // TODO: Work on and design features for app  using the mainapplayout.xml


