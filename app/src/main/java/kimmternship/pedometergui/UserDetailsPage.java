package kimmternship.pedometergui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import kimmternship.pedometergui.model.user;

public class UserDetailsPage extends Activity {
    String GenderofUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.userdetailpage);
    }
    private void init()
    {

    }

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch(view.getId()) {
            case R.id.IsFemale:
                if (checked)
                    GenderofUser="Male";

                    break;
            case R.id.IsMale:
                if (checked)
                    GenderofUser="Female";
                    break;
        }
    }
}
