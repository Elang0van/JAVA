package JAVA.Exception_handling;

import java.util.*;
import java.util.Scanner;

public class practical {
    public static void main(String[] args) {
        getDetails();
    }
    private static void getDetails(){
        Scanner ace=new Scanner(System.in);
        try{
        System.out.println("Enter your accNo");
        int accNo=ace.nextInt();
        System.out.println("Enter your PinNo");
        int pin=ace.nextInt();

        int[] empDetails = new int[5];
        
        for (int i=0;i<10;i++){
        empDetails [i]=2000;
        }
        }
        catch(ArrayIndexOutOfBoundsException e){
          System.out.println("check array length");
        }
        catch(Exception ime){
          System.out.println("check accno/pinNo");
        }
        finally{
            System.out.println("close your accout");
        }
    }
    }

