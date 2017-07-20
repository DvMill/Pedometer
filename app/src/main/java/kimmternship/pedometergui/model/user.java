package kimmternship.pedometergui.model;


import java.io.Serializable;

public class user implements Serializable {
        public static final String TABLE = "User";
        //Table Columns names
        public static String KEY_ID = "userid";
        public static String KEY_name = "username";
        public static String KEY_password = "password";

        private static  int userid;
        private  String username;
        private  String password;
        private  statistics Stats;


    public user(String uname,String pass){} //Default constructor
    public static  int getId(){return userid;}
    public static void setUserid(int incuserid) {userid = incuserid;}

    public  String getName(){return username;}
    public void setName(String incname){
        username = incname;
    }
    public  String getPassword(){
        return password;
    }
    public void setPassword(String incpassword){password = incpassword;}

    public statistics getStats() {return Stats; }
    public void setStats(statistics stats) {Stats = stats;}


}
