import java.util.Scanner;

class signup{
    public static String name;
    public static String pass;

    static void sig(){
     Scanner ace1=new Scanner(System.in);
     System.out.println("----------------------------");
     System.out.println("CREATE NEW ACCOUNT");
     System.out.println("----------------------------");
     System.out.println(" ");
     System.out.println("ENTER YOUR NAME");
     name=ace1.nextLine();
     System.out.println(" ");
     System.out.println("ENTER YOUR PASSWORD");
     pass=ace1.nextLine();
     System.out.println(" ");
     System.out.println("------------------------------");
     System.out.println("ACCOUNT CREATED SUCCESS FULLY");
     System.out.println("------------------------------");
    }
}

 class login{
    
  public static String logname;
  public static String logpass;
  public static void log(){
     Scanner ace2=new Scanner(System.in);
     /*System.out.println("------------------------------");
     System.out.println("LOGIN PAGE");
     System.out.println("------------------------------");
     System.out.println(" ");
     System.out.println("ENTER USER NAME");
     logname=ace2.nextLine();
     System.out.println(" ");
     System.out.println("ENTER PASSWORD");
     logpass=ace2.nextLine();
     System.out.println(" ");*/
     logname="";
     logpass="";
     while(!signup.name.equals(logname) && !signup.pass.equals(logpass))
     {
     System.out.println("------------------------------");
     System.out.println("LOGIN PAGE");
     System.out.println("------------------------------");
     System.out.println(" ");
     System.out.println("ENTER USER NAME");
     logname=ace2.nextLine();
     System.out.println(" ");
     System.out.println("ENTER PASSWORD");
     logpass=ace2.nextLine();
     System.out.println(" ");
     System.out.println("------------------------------");
           if(signup.name.equals(logname) && signup.pass.equals(logpass)){
            System.out.println("WELCOME SIR "+signup.name);
           }
           else if(!signup.name.equals(logname) && signup.pass.equals(logpass)){
            System.out.println("YOU ENTERED WRONG USER NAME");
           }
           else if(signup.name.equals(logname) && !signup.pass.equals(signup.pass)){
            System.out.println("YOU ENTERED WRONG PASSWORD");
           }
           else if(!signup.name.equals(logname) && !signup.pass.equals(logpass)){
            System.out.println("YOU ENTERED WRONG INFO");
           }
     System.out.println("------------------------------");
      
    }
  }
}
    
    class usernameChange{
      public static String oldname;
      public static String newname;
      
         public static void namechange(){
     System.out.println("------------------------------");
     System.out.println("CHANGE NEW USERNAME");
     System.out.println("------------------------------");
     System.out.println(" ");
     Scanner ace3=new Scanner(System.in);
     System.out.println("ENTER OLD USERNAME");
     oldname=ace3.nextLine();
     System.out.println(" ");
     System.out.println("ENTER CREATE NEW NAME");
     newname=ace3.nextLine();
     System.out.println(" ");
      System.out.println("------------------------------");
     if(oldname.equals(signup.name)){
      signup.name=newname;
      System.out.println("NEW USERNAME SAVED :-"+newname );
     }
     else{
      System.out.println("YOU ENTERED WRONG OLD USERNAME");
     }
     System.out.println("------------------------------");
    }
  }

  class passwordchange{
    public static String oldpass;
    public static String newpass;
      public static void passchange(){

    Scanner ace4=new Scanner(System.in);
    System.out.println("------------------------------");
    System.out.println("CHANGE NEW PASSWORD");
    System.out.println("------------------------------");
    System.out.println(" ");
    System.out.println("ENTER OLD PASSWORD");
    oldpass=ace4.nextLine();
    System.out.println(" ");
    System.out.println("ENTER CREATE NEW PASSWORD");
    newpass=ace4.nextLine();
    System.out.println(" ");
    System.out.println("------------------------------");
    if(oldpass.equals(signup.pass)){
    signup.pass=newpass;
    System.out.println("NEW PASSWORD SAVED :-" +newpass);
     }
     else{
      System.out.println("YOU ENTERED WRONG OLD PASSWORD");
     }
     System.out.println("------------------------------");
    }
  }

class static03{
    public static void main(String argg[]){
      Scanner ace5=new Scanner(System.in); 
      System.out.println("-----------------------------------------------------------------------------");
      System.out.println("CHOOSE THE PAGE IN GIVEN BELOW OR (QUITE PRESS OK) ");
      System.out.println("------------------------------");
      System.out.println("SIGNUP PAGE");
      System.out.println("------------------------------");
      System.out.println("LOGIN PAGE");
      System.out.println("------------------------------");
      System.out.println("CHANGE USERNAME PAGE");
      System.out.println("------------------------------");
      System.out.println("CHANGE PASSWORD PAGE");
      System.out.println("-----------------------------");
      String page =ace5.nextLine();
     while(!page.equals("ok")){
      switch(page){
        case "signup":
        signup.sig();
        System.out.println(" ");
        break;
        case "login":
        login.log();
        System.out.println(" ");
        break;
        case "change username":
        usernameChange.namechange();
        System.out.println(" ");
        break;
        case "change password":
        passwordchange.passchange();
        System.out.println(" ");
        break;
        default:
        System.out.println("YOUR ENTERED WRONG OPERATION");
         
      }
      System.out.println("------------------------------------------------------------------------------");
      System.out.println("CHOOSE THE PAGE IN GIVEN BELOW OR (QUITE PRESS OK) ");
      System.out.println("------------------------------");
      System.out.println("SIGNUP PAGE");
      System.out.println("------------------------------");
      System.out.println("LOGIN PAGE");
      System.out.println("------------------------------");
      System.out.println("CHANGE USERNAME PAGE");
      System.out.println("------------------------------");
      System.out.println("CHANGE PASSWORD PAGE");
      System.out.println("-----------------------------");
      page=ace5.nextLine();
    }
    System.out.println("THANK YOU");
    }
}

