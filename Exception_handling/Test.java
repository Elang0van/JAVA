package JAVA.Exception_handling;

import java.util.Scanner;

public class Test {
      public static void main(String[] args) {
        Scanner ace=new Scanner(System.in);
       // System.out.println("Enter the number");
        //int num=ace.nextInt();
        try{
             System.out.println("Enter the number");
             int num=ace.nextInt();
             check.checkValue(num); 
        }
        catch(Userdefined_EX e){
            System.out.println(e.getMessage());
        }
      }
}
