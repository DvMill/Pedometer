package kimmternship.pedometergui.model;


public class user {
        public static final String TABLE = "User";
        //Table Columns names
        public static String KEY_ID = "userid";
        public static String KEY_name = "username";
        public static String KEY_password = "password";
        public static String KEY_gender = "gender";
        public static String KEY_feet = "feet";
        public static String KEY_inches = "password";



        private static int userid;
        private  String username;
        private  String password;
        private int feet;
        private int inches;
        private String gender;


    public user(String uname,String pass){} //Default constructor
    public static int getId(){return userid;}
    public static void setUserid(int userid) {user.userid = userid;}

    public  String getName(){return username;}
    public void setName(String incname){
        username = incname;
    }
    public  String getPassword(){
        return password;
    }
    public void setPassword(String incpassword){password = incpassword;}


    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getGender() {
        return gender;
    }

    public int getInches() {
        return inches;
    }
    public void setInches(int inches) {
        this.inches = inches;
    }

    public int getFeet() {
        return feet;
    }
    public void setFeet(int feet) {
        this.feet = feet;
    }
}
