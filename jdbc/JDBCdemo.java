import java.sql.*;

public class JDBCdemo{

    public static void main(String[] args) throws SQLException {
    String url="jdbc:mysql://localhost:3306/ace1";
    String username="root";
    String pass="ace01"; 
    String query="select * from customers";
    Connection con= DriverManager.getConnection(url,username,pass); //connection interface and Drivermanagement class
    Statement st=con.createStatement();
    ResultSet rs = st.executeQuery(query);
    while(rs.next()){
    System.out.println( "order id " + rs.getInt(1));
    System.out.println("customer name   "+rs.getString(2));
    System.out.println("customer ir " + rs.getString(3));
    }
    con.close();
    }
}