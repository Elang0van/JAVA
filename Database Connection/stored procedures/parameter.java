import java.sql.*;

public class parameter {
    public static void main(String[] args) throws Exception {
    String url="jdbc:mysql://localhost:3306/ace1";
    String username="root";
    String pass="ace01"; 

    int id=1204;

    String query="call getids(1201)";
  
    Connection con= DriverManager.getConnection(url,username,pass); //connection interface and Drivermanagement class
    CallableStatement cs = con.prepareCall("{call GETNAME(?,?)}");
    cs.setInt(1, id);
    cs.registerOutParameter(2, Types.VARCHAR);
    cs.executeUpdate();
    System.out.println(cs.getString(2));
    ResultSet rs = cs.executeQuery();
    }
}
