
import java.sql.*;
public class DBconnection {
    private static final String url="jdbc:mysql://localhost:3306/atm";
    private static final String username="root";
    private static final String psd="ace01";
    
    public static Connection Getconnection() throws SQLException{
        return DriverManager.getConnection(url, username, psd);
    }
}
