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
          int op=0;
          try{  
         System.out.println("// Enter your pin to start ATM \n// Enter '2' to change your pin\n// Enter '1' to close ");
           op=ace.nextInt();
            bank.AcDetails(op);
          }
          catch(InputMismatchException E){
            System.out.println("Don't enter characters");
            ace.nextLine();
          }catch(SQLException AE){
              System.out.println("");
          }

          if(pins.contains(op)) {
                while (true) {
                        String choice="";
                        System.out.println("-------------------------------------");
                        System.out.println("press '1' for CHECK BALANCE");
                        System.out.println("press '2' for WITHDRAW");
                        System.out.println("press '3' for DEPOSIT");
                        System.out.println("press '4' for EXIT");
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
                    
                          System.out.println("TRY AGAIN");
                        }
                        catch(InputMismatchException ie){
                               System.out.println("DON'T ENTER CHARECTERS");
                               ace.nextLine();
                            }
                            break;
                        case "3":
                        try {
                          System.out.print("ENTER YOUR DEPOSIT AMOUNT: ");
                          double depositAmount = ace.nextDouble();
                          bank.deposit(depositAmount);
                        } catch (SQLException e) {
                          
                          System.out.println("TRY AGAIN");
                        }
                        catch (InputMismatchException ie) {
                          System.out.println("DON'T ENTER CHARECTERS");
                          ace.nextLine();
                        }
                            break;
                        case "4":
                            System.out.println("Exiting...");
                            System.exit(0);
                            break;
                            default:
                            System.out.println("You enterd wrong Operation");
                      }

                    }                  
                  } 
                  else if(op==2){
            ATMFunctions bank1=new ATMFunctions();
            String query1 = "select id from holders";
            Connection con1 = DBconnection.Getconnection();
            Statement st=con1.createStatement();
            ResultSet rs1=st.executeQuery(query1);
            
            ArrayList<Integer> AccNO = new ArrayList<Integer>();
            while (rs1.next()) {
                int CC = rs1.getInt(1);
                AccNO.add(CC);
            }
            try{
               System.out.println("---------------------------------");
               System.out.println("           CHANGE PIN      ");
               System.out.println("---------------------------------");
               System.out.println(" ");
               
                       System.out.println("Enter your account number");
                        int acc=ace.nextInt();
                      if(AccNO.contains(acc)){
                        System.out.println("Create new pin");
                        int pin=ace.nextInt();
                        bank1.pinChange(acc, pin);
                      }
                      else{
                        System.out.println("you enter wrong Account number");
                      }
                    }
                    catch(InputMismatchException ime){
                      System.out.println("Don't enter characters");
                       ace.next();
                    }
                    catch(SQLException se){
                      System.out.println("you enter wrong Account number");
                     
                    }
                  }
                  else if(op==1){
                      System.out.println("Closing......... ");
                      System.exit(0);
                     break;
                  }
                  else if(!pins.contains(op)){
                    System.out.println("You entered wrong PIN Number.......");
                  }
            }
          }
        }