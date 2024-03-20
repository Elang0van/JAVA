
import java.sql.*;


class ATMFunctions{               
private static int acc;
private static String name;
private static double balance;
private static int pin;
public static void AcDetails(int pin) throws SQLException {

  String query="select * from holders where pin ="+pin;
  Connection con = DBconnection.Getconnection();
  Statement st=con.createStatement();
  ResultSet rs=st.executeQuery(query);
  ATMFunctions obj=new ATMFunctions();
    rs.next();
      obj.acc=rs.getInt(1);
      obj.name=rs.getString(2);
      obj.balance=rs.getDouble(3);
      obj.pin=rs.getInt(4);
  }
  public static double getBalance(){
    return balance;
  }
  public static String getName(){
    return name;
  }
  public static int getPin(){
    return pin;
  }
  public int getAcc(){
    return acc;
  }
public void deposit(double amount) throws SQLException {
        if (amount >= 100) {
            balance += amount;
            updateBalanceInDatabase();
            System.out.println("YOUR AMOUNT DEPOSITED: " + amount);
        } else {
            System.out.println("AMOUNT MUST BE >= 100");
        }
    }

    public void withdraw(double amount) throws SQLException {
        if (amount >= 100) {
            if (balance >= amount) {
                balance -= amount;
                updateBalanceInDatabase();
                System.out.println("YOUR AMOUNT WITHDRAWN: " + amount);
            } else {
                System.out.println("Insufficient Balance");
            }
        } else {
            System.out.println("AMOUNT MUST BE >= 100");
        }
    }

    private void updateBalanceInDatabase() throws SQLException {
        String query = "UPDATE holders SET balance = ? WHERE pin = ?";
        Connection con = DBconnection.Getconnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setDouble(1, balance);
            ps.setInt(2, pin);
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected <= 0) {
              System.out.println("not update");
                throw new SQLException("Failed to update balance");

            }
        }
}