package kimmternship.pedometergui.Sql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import kimmternship.pedometergui.model.user;

public class DatabaseHelper  extends SQLiteOpenHelper{
    private static final String DATABASE_NAME = "PedometerUserManager.db"; //names the database
    private static final int DATABASE_VERSION = 1;
    public DatabaseHelper(Context context ){super(context, DATABASE_NAME, null, DATABASE_VERSION);}//helper to use database in other classes

    @Override
    public void onCreate(SQLiteDatabase db) { // grabs information from User in order to name table and colums

        String CREATE_TABLE_USERS = "CREATE TABLE " + user.TABLE  + "("
                + user.KEY_ID  + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
                + user.KEY_name + " TEXT, "
                + user.KEY_password + " TEXT )";
        db.execSQL(CREATE_TABLE_USERS);

        String CREATE_TABLE_USERSDETAILS = "CREATE TABLE " + user.TABLE  + "("
                + user.KEY_ID  + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
               // + user.statistics.KEY_USER_GENDER + " TEXT, "
                + user.KEY_password + " TEXT )";

       // db.execSQL(CREATE_TABLE_USERSDETAILS);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {//deletes old B if current one is upgraded
        db.execSQL("DROP TABLE IF EXISTS " + user.TABLE);
        onCreate(db);
    }
    public void addUser(user incUser)
    {
        SQLiteDatabase db = this.getWritableDatabase(); //creates a writable database
        ContentValues values = new ContentValues();
        values.put(user.KEY_name,incUser.getName());//puts the username into the databse
        values.put(user.KEY_password,incUser.getPassword());//puts password into the database
        long userid = db.insert(user.TABLE, null, values);//places them under a certain Userid
        db.close();
    }
    public boolean checkifExists(String incuserlogin, String incpasswordlogin){
        String[] columns = {user.KEY_ID};
        SQLiteDatabase db = this.getWritableDatabase();
        String selection = user.KEY_name + " = ?" + " AND " + user.KEY_password + " =?";//searcbes to see if the username and password exists and allows user to login if both match
        String[] selectionArgs = { incuserlogin, incpasswordlogin };
        Cursor cursor = db.query(user.TABLE,
                columns,
                selection,
                selectionArgs,
                null,
                null,
                null);
        int cursorCount = cursor.getCount();
        cursor.close();
        db.close();

        if (cursorCount > 0){ return true; }
        return false;
    }

    public boolean checkifUserExists(String incuser){ //checs to see if when trying to create a user if username already ex ists
        String[] columns = {user.KEY_ID};
        SQLiteDatabase db = this.getWritableDatabase();
        String selection = user.KEY_name + " = ?";
        String[] selectionArgs = { incuser };
        Cursor cursor = db.query(user.TABLE,
                columns,
                selection,
                selectionArgs,
                null,
                null,
                null);
        int cursorCount = cursor.getCount();
        cursor.close();
        db.close();
        if (cursorCount > 0){
            return true;
        }
        return false;
    }



// TODO: Left join to connect a table to user d to hold information on the user
}