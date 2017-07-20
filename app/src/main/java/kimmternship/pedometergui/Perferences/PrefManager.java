package kimmternship.pedometergui.Perferences;
import android.content.Context;
import android.content.SharedPreferences;

import kimmternship.pedometergui.model.user;

public class PrefManager {
 user CurrentUser=new user("","");
    private Context context;

   public PrefManager(Context context) {this.context = context;}

    public void saveLoginDetails(user incUser) {
        CurrentUser=incUser;
        SharedPreferences sharedPreferences = context.getSharedPreferences("LoginDetails", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("UserID", CurrentUser.getId());
        editor.apply();
    }


    public user getUser() {return CurrentUser;}

    public void  blankusr() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("LoginDetails", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }

    public boolean isUserLoggedOut() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("LoginDetails", Context.MODE_PRIVATE);
        return sharedPreferences.getString("Username","").isEmpty();
    }
}