package kimmternship.pedometergui.model;


public class statistics {
        public static final String TABLE = "UserStatisics";
    //Table Columns names
        public static String KEY_ID = "userid";
        public static String KEY_USER_GENDER = "gender";
        public static String KEY_USER_HEIGHT_FT = "feet";
        public static String KEY_USER_HEIGHT_IN = "inches";

        private static int userid;
        private  String gender;
        private  int feet;
        private  int inch;

    public statistics(String gender,int ft,int in){} //Default constructor

    public static int getId(){return userid;}
    public  String getGender(){return gender;}
    public void setGender(String incgender){
        gender = incgender;
    }
    public  int getFeet(){return feet;}
    public void setFeet(int incft){feet = incft;}
    public  int getinch(){
        return inch;
    }
    public void setinch(int incinch){inch = incinch;}
}
