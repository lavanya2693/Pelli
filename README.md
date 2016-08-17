import java.sql.*;
public class Matrimomy {
    //Connection conn;
    public static Connection ConnectDB(){

    	String url = "jdbc:mysql://localhost:3306/test?useSSL=false";
        String username = "root";
        String password = "root";

        System.out.println("Connecting database...");

        try {
            Connection connection = DriverManager.getConnection(url,username,password);
            return connection;
      //connection.close();
        } catch (SQLException e) {
           // JOptionPane.showMessageDialog(null, e);
        	System.out.println(e.getMessage());
            return null;
        }        
    }
    public static void insert(String s, int t, String u){
        String name;
        int age;
        String caste;
        name=s;
        age=t;
        caste=u;
          Connection conn=ConnectDB();
        try{
            String sql = "insert into Test Values( \""+name+"\", \""+age+"\", \""+caste+"\")";
            System.out.println("Query String " + sql);

      // create the mysql insert preparedstatement
      PreparedStatement preparedStmt = conn.prepareStatement(sql);


      // execute the preparedstatement
      preparedStmt.execute();
     // JOptionPane.showMessageDialog(null, "Data added");

        }catch(SQLException e){
            //JOptionPane.showMessageDialog(null, e);
        	System.out.println(e.getMessage());
        }
    }
     public static void main(String args[]) {
        //ConnectDB();
         insert("Rashi234",22,"vokkaliga");
    }
}


