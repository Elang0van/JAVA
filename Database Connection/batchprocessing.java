
import java.sql.*;
public class batchprocessing {
        public static void main(String[] args) throws Exception {
    String url="jdbc:mysql://localhost:3306/ace1";
    String username="root";
    String pass="ace01"; 

    String query1="update emp set salary=30000 where id=3";
    String query2="update emp set salary=30000 where id=2";
    String query3="update emp set salary=30000 where id=5";
    String query4="update emp set salary=30000 where id=1";
    String query5="updat emp set salary=30000 where id=6";
  
    Connection con= DriverManager.getConnection(url,username,pass); //connection interface and Drivermanagement class
    con.setAutoCommit(false);  
    Statement st=con.createStatement();
      st.addBatch(query1);
      st.addBatch(query2);
      st.addBatch(query3);
      st.addBatch(query4);
      st.addBatch(query5);

     int[] res= st.executeBatch();
     
     for(int i: res){
      if(i>0)
      continue;
      else
      con.rollback();
     }
     con.commit();
    }
}