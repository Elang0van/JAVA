import java.sql.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
public class ATM {
    public static void main(String[] args) throws SQLException {
            Scanner ace = new Scanner(System.in);
            ATMFunctions bank=new ATMFunctions();
            String query = "select pin from holders";
            Connection con = DBconnection.Getconnection();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            ArrayList<Integer> pins = new ArrayList<Integer>();
            while (rs.next()) {
                int pin = rs.getInt(1);
                pins.add(pin);
            }
        while (true) {
          int op=0;;
          try{  
          System.out.println("Enter your pin to start / enter '1' to close");
            op=ace.nextInt();
            bank.AcDetails(op);
          }
          catch(InputMismatchException E){
            System.out.println("Don't enter characters");
          }catch(SQLException AE){
              System.out.println("You entered wrong pin");
          }
            if(pins.contains(op)) {
                while (true) {
                        String choice="";
                        System.out.println("-------------------------------------");
                        System.out.println("press '1' for CHECK BALANCE");
                        System.out.println("press '2' for WITHDRAW");
                        System.out.println("press '3' for DEPOSIT");
                        System.out.println("press '4' for CHANGE PIN");
                        System.out.println("press '5' for EXIT");
                        System.out.println("-------------------------------------");
                        try{
                        choice = ace.next();
                        }
                        catch(InputMismatchException e){
                         System.out.println("Please enter correct operation");
                        }
                    switch (choice) {
                        case "1":
                            System.out.println("YOUR BALANCE: " + bank.getBalance());
                            break;
                        case "2":
                        try {
                          System.out.print("ENTER YOUR WITHDRAW AMOUNT: ");
                          double withdrawAmount = ace.nextDouble();
                          bank.withdraw(withdrawAmount);
                        } catch (SQLException e) {
                    
                          System.out.println("DON'T ENTER CHARECTERS");
                        }
                        catch(InputMismatchException ie){
                               System.out.println("DON'T ENTER CHARECTERS");
                            }
                            break;
                        case "3":
                        try {
                          System.out.print("ENTER YOUR DEPOSIT AMOUNT: ");
                          double depositAmount = ace.nextDouble();
                          bank.deposit(depositAmount);
                        } catch (SQLException e) {
                          
                          System.out.println("DON'T ENTER CHARECTERS");
                        }
                        catch (InputMismatchException ie) {
                          System.out.println("DON'T ENTER CHARECTERS");
                        }
                            break;
                        case "4":
                            System.out.print("ENTER YOUR OLD PIN: ");
                            // You need to write code here to handle changing the PIN
                            break;
                        case "5":
                            System.out.println("Exiting...");
                            System.exit(0);
                            break;
                      }
                    }
                  }
             else if(op==1){
             System.out.println("closing......");
             break;
                }
              }
            }
          }