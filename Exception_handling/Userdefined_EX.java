package JAVA.Exception_handling;

public class Userdefined_EX extends Exception{
    public Userdefined_EX(String msg){
         super(msg);
    }
}

class check{
    public static void checkValue(int val) throws Userdefined_EX{
       if(val<0){
         throw new Userdefined_EX("value cannot be negativ Exception");
       }
    }
}
