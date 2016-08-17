
import java.sql.*;
import java.util.Arrays;

//import Oracle.jdbc.driver.OracleDriver;


public class Pelli1 {
	
	
	// JDBC driver name and database URL
	   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost:3306/Test?useSSL=false";

	   //  Database credentials
	   static final String USER = "root";
	   static final String PASS = "root";
	   
	   public static void main(String[] args) {
	   Connection conn = null;
	   Statement stmt = null;
	   try{
	      //STEP 2: Register JDBC driver
	      Class.forName("com.mysql.jdbc.Driver");

	      //STEP 3: Open a connection
	      System.out.println("Connecting to a selected database...");
	      conn = DriverManager.getConnection(DB_URL, USER, PASS);
	      System.out.println("Connected database successfully...");
	      
	      //STEP 4: Execute a query
	      System.out.println("Inserting records into the table...");
	      stmt = conn.createStatement();
	      
	      String sql = "INSERT INTO Test " +
	                   "VALUES ('Zara',18,'Ali')";
	      stmt.executeUpdate(sql);
	      sql = "INSERT INTO Test " +
	                   "VALUES ('Mahnaz',25,'Fatma')";
	      stmt.executeUpdate(sql);
	      sql = "INSERT INTO Test " +
	                   "VALUES ('Zaid',30,'Khan')";
	      stmt.executeUpdate(sql);
	      sql = "INSERT INTO Test " +
	                   "VALUES('Sumit',28,'Mittal')";
	      stmt.executeUpdate(sql);
	      System.out.println("Inserted records into the table...");

	   }catch(SQLException se){
	      //Handle errors for JDBC
	      se.printStackTrace();
	   }catch(Exception e){
	      //Handle errors for Class.forName
	      e.printStackTrace();
	   }finally{
	      //finally block used to close resources
	      try{
	         if(stmt!=null)
	            conn.close();
	      }catch(SQLException se){
	      }// do nothing
	      try{
	         if(conn!=null)
	            conn.close();
	      }catch(SQLException se){
	         se.printStackTrace();
	      }//end finally try
	   }//end try
	   System.out.println("Goodbye!");
	}//end main
	}//end JDBCExample
}
	/*
	static final String  JDBC_DRIVER="com.mysql.jdbc.Driver";
	//static final String DATABASE_SCHEMA = "test";
	static final String DB_URL="jdbc:mysql://localhost:3306/Test?useSSL=false";
	
//  Database credentials
   static final String DATABASE_USER = "root";
   static final String DATABASE_PASS = "root";
   
   
   public static void main(String[] args) {
	   Connection conn = null;
	   Statement stmt = null;
	   try{
	      //STEP 2: Register JDBC driver
	      Class.forName("com.mysql.jdbc.Driver");

	      //STEP 3: Open a connection
	      System.out.println("Connecting to a selected database...");
	      conn = DriverManager.getConnection(DB_URL, DATABASE_USER, DATABASE_PASS);
	      System.out.println("Connected database successfully...");
	      
	      //STEP 4: Execute a query
	      System.out.println("Inserting records into the table...");
	      stmt = conn.createStatement();
	      
	      String sql = "INSERT INTO Test " +
	                   "VALUES ('Zara',18,'Ali')";
	      stmt.executeUpdate(sql);
	      sql = "INSERT INTO Test " +
	                   "VALUES ('Mahnaz', 25,'Fatma)";
	      stmt.executeUpdate(sql);
	      sql = "INSERT INTO Test " +
	                   "VALUES ('Zaid',30 'Khan')";
	      stmt.executeUpdate(sql);
	      sql = "INSERT INTO Test " +
	                   "VALUES('Sumit', 28,'Mittal')";
	      stmt.executeUpdate(sql);
	      System.out.println("Inserted records into the table...");

	   }catch(SQLException se){
	      //Handle errors for JDBC
	      se.printStackTrace();
	   }catch(Exception e){
	      //Handle errors for Class.forName
	      e.printStackTrace();
	   }finally{
	      //finally block used to close resources
	      try{
	         if(stmt!=null)
	            conn.close();
	      }catch(SQLException se){
	      }// do nothing
	      try{
	         if(conn!=null)
	            conn.close();
	      }catch(SQLException se){
	         se.printStackTrace();
	      }//end finally try
	   }//end try
	   System.out.println("Goodbye!");
     }//end main
	}//end JDBCExample
   /**
   public static void Pelli1(String[] args) {
	    int[] series = {4,2};
	    series = addElement(series, 3);
	    series = addElement(series, 1);
	}

	static int[] addElement(int[] a, int e) {
	    a  = Arrays.copyOf(a, a.length + 1);
	    a[a.length - 1] = e;
	    return a;
	}
	**/
   /**
   public static Connection connectToDatabase(String jdbcURLString, String user, String password)
   {
	  Connection conn = null;
	   
	   try{
		      //STEP 2: Register JDBC driver
		      Class.forName("com.mysql.jdbc.Driver");
		      //STEP 3: Open a connection
		      System.out.println("Connecting to a selected database...");
		      conn = DriverManager.getConnection(jdbcURLString, user, password);
		      System.out.println("Connected database successfully...");
		      
	   }catch(Exception se){
		      //Handle errors for JDBC
		   
		   System.out.println("Not able to connect database with " + jdbcURLString + " " + user + " " + password);
		   System.out.println(se.getMessage());
		   }
	   return conn;
   }
   
   public static boolean insertIntoTestTable(Connection dbcon, String name,String age,String caste)
   {
	   try{
	   Statement stmt = dbcon.createStatement();
		
	   String sqlQueryString = "INSERT INTO Test VALUES ('";
	   sqlQueryString = sqlQueryString + " '" + name +"', " + age + ",'" + caste + ",)";
	   final int batchSize = 1000;
	   int count = 0;
	   Object sqlQueryString2;
	for (String sqlQueryString1: sqlQueryString) {

		   stmt.setString(1, sqlQueryString1.getName());
		   stmt.setString(2, sqlQueryString1.getAge());
		   stmt.setString(3, sqlQueryString1.getCaste());
		   stmt.addBatch(sqlQueryString);
			
			if(++count % batchSize == 0) {
				stmt.executeBatch();
			}
		}
	   stmt.executeBatch();
	   {
	  
	   System.out.println(sqlQueryString);
	
		stmt.execute(sqlQueryString);
	   
	   }
	   }catch (SQLException e) 
	   {
		// TODO Auto-generated catch block
		e.printStackTrace();
	   }
	   return true;
	   
   }
   public static void main(String[] args) throws SQLException {
	  
   Connection dbconn = connectToDatabase(JDBC_DRIVER,DATABASE_USER,DATABASE_PASS);
   Statement stmt = dbconn.createStatement();
   try{
   insertIntoTestTable(dbconn, "ZARA","18","ALI");

 /**     
     // String sql = "INSERT INTO Test " +
               //    "VALUES ('Zara', 18,'Ali')";
     // stmt.executeUpdate(sql);
      //sql = "INSERT INTO Test " +
               //    "VALUES ('Mahnaz',25, 'Fatma')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO Test " +
                   "VALUES ('Zaid', 30,'Khan')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO Test " +
                   "VALUES('Sumit',28,'Mittal')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO Test " +
              "VALUES('Rakesh',28,'gowdas')";
 stmt.executeUpdate(sql);
 sql = "INSERT INTO Test " +
         "VALUES('Sowmya',25,'gowdas')";
stmt.executeUpdate(sql);
sql = "INSERT INTO Test " +
        "VALUES('Praveen',25,'Shetty')";
stmt.executeUpdate(sql);
sql = "INSERT INTO Test " +
        "VALUES('Pooja',24,'Shetty')";
stmt.executeUpdate(sql);
sql = "INSERT INTO Test " +
        "VALUES('Apoorva',23,'Lingayats')";
stmt.executeUpdate(sql);
sql = "INSERT INTO Test " +
        "VALUES('Sharath',32,'SC')";
stmt.executeUpdate(sql);
      System.out.println("Inserted records into the table...");
**/
 **/
 /**
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            dbconn.close();
      }catch(SQLException se){
      }// do nothing
      try{
         if(dbconn!=null)
            dbconn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try
   System.out.println("Goodbye!");
}//end main
}//end JDBCExample
**/