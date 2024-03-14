
import java.sql.*;

public class JDBCpst {
 public static void main(String[] args) throws Exception {   // prepareStatement
    String url="jdbc:mysql://localhost:3306/ace1";
    String username="root";
    String pass="ace01"; 

    int id=12005;
    String name="aceoo";
    String orderid="aceo";
    String query = "update customers set customers_name=? where customers_name=?";
    Connection con= DriverManager.getConnection(url,username,pass); //connection interface and Drivermanagement class
    PreparedStatement pst= con.prepareStatement(query);
    //pst.setInt(1, id);
    pst.setString(1, name);
    pst.setString(2, orderid);
    int rows = pst.executeUpdate();
    System.out.println("no of rows affected "+ rows);
 }
    
}
