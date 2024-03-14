import java.sql.*;

public class Update {
    public static void main(String[] args) throws Exception{
   String url="jdbc:mysql://localhost:3306/ace1";
    String username="root";
    String pass="ace01"; 
    int id=12005;
    String name="aceo";
    String orderid="1ci13";
    String query="insert into customers values(12003,'Sparros','1ci12')";
    String query1="insert into customers values("+id+",'"+name+"','"+orderid+"')";
    Connection con= DriverManager.getConnection(url,username,pass); //connection interface and Drivermanagement class
    Statement st=con.createStatement();
    int row = st.executeUpdate(query1);
    System.out.println("number of rows affected "+ row);
    }
}
