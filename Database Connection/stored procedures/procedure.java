import java.sql.*;

public class procedure {
    public static void main(String[] args) throws Exception{
            String url="jdbc:mysql://localhost:3306/ace1";
    String username="root";
    String pass="ace01"; 

    String query="call getids(1201)";
  
    Connection con= DriverManager.getConnection(url,username,pass); //connection interface and Drivermanagement class
    CallableStatement cs = con.prepareCall(query);
    ResultSet rs = cs.executeQuery();
    
    while (rs.next()) {
    System.out.println( "order id " + rs.getInt(1));
    System.out.println("customer name   "+rs.getString(2));
    System.out.println("customer id " + rs.getString(3));
    }
    }
}
