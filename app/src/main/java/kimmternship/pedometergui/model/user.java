package kimmternship.pedometergui.model;


public class user {

        public static final String TABLE = "User";

        //Table Columns names
        public static final String KEY_ID = "userid";
        public static final String KEY_name = "username";
        public static final String KEY_password = "password";


        private static int userid;
        private  String username;
        private  String password;

    public user(String uname,String pass){} //Default constructor
    public static int getId(){return userid;}

    public void setId(int id){
        userid = id;
    }

    public  String getName(){return username;}

    public void setName(String incname){
        username = incname;
    }

    public  String getPassword(){
        return password;
    }

    public void setPassword(String incpassword){password = incpassword;
    }
}
