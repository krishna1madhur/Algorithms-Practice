package dao;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import domain.Customer;
import domain.Download;
import domain.Song;
 
public class DBOperations {
		// JDBC driver name and database URL
		static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
		static final String DB_URL = "jdbc:mysql://localhost:3354/hw4";

	    // Database credentials
		static final String USER = "root";
		static final String PASS = "myindiakrish7$";
		
	// Code for creating the three tables and inserting values in them.	
	public static void insertDB(List<Customer> customerList, List<Song> songList, List<Download> downloadList) {
		// JDBC driver name and database URL
		Connection conn = null;
		Statement stmt = null;
		try {
		// Register JDBC driver
			Class.forName(JDBC_DRIVER);
		// Open a connection
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
			System.out.println("1. Connection with database established successfully");
		// Execute a query
			stmt = conn.createStatement();
			// Creating Customer Table
			ArrayList<String> customerHeader = Customer.getCustomerHeaders();
			ArrayList<String> customerDataType = Customer.getCustomerDatatype();
			String createCustomer = "CREATE TABLE Customer " +
	                   "("+customerHeader.get(0)+" "+customerDataType.get(0) +"," +
	                   customerHeader.get(1)+" "+customerDataType.get(1)+"," + 
	                   customerHeader.get(2)+" "+customerDataType.get(2)+"," + 
	                   customerHeader.get(3)+" "+customerDataType.get(3)+"," +  
	                   customerHeader.get(4)+" "+customerDataType.get(4)+"," + 
	                   " PRIMARY KEY ("+ customerHeader.get(0)+ "))"; 
			// Creating Song table
			ArrayList<String> songHeader = Song.getSongHeaders();
			ArrayList<String> songDataType = Song.getSongDatatype();
			String createSong = "CREATE TABLE Song " +
	                   "("+songHeader.get(0)+" "+songDataType.get(0) +"," +
	                   songHeader.get(1)+" "+songDataType.get(1)+" unique NOT NULL ," + 
	                   songHeader.get(2)+" "+songDataType.get(2)+"," + 
	                   songHeader.get(3)+" "+songDataType.get(3)+"," +  
	                   " PRIMARY KEY ("+ songHeader.get(0)+ "))"; 
			// Creating Download table
						ArrayList<String> downloadHeader = Download.getDownloadHeader();
						ArrayList<String> downloadDataType = Download.getDownloadDatatype();
						String createDownload = "CREATE TABLE Download " +
				                   "("+downloadHeader.get(0)+" "+downloadDataType.get(0) +"," +
				                   downloadHeader.get(1)+" "+downloadDataType.get(1)+"," + 
				                   downloadHeader.get(2)+" "+downloadDataType.get(2)+"," + 
				                   " PRIMARY KEY ("+ downloadHeader.get(0)+"," +downloadHeader.get(1)+"), "+
				                   "Foreign Key ("+downloadHeader.get(0)+") references Customer(SSN) on delete cascade, "+
				                   "Foreign Key ("+downloadHeader.get(1)+") references Song(SID) on delete cascade)"; 
	      stmt.executeUpdate(createCustomer);
	      stmt.executeUpdate(createSong);
	      stmt.executeUpdate(createDownload);
	      
	     // Insert into Customer
	      for(Customer customer : customerList) {
	    	  String insertCustomer = "INSERT INTO Customer " + "VALUES ("+ customer.getSsn()+",'"+customer.getCname()+"', '"+
	      customer.getGender()+"',"+customer.getAge()+",'"+customer.getProfession()+"')";
	    	  stmt.executeUpdate(insertCustomer);
	      }
	    // Insert into Song
	      for(Song song : songList) {
	    	  String insertSong = "INSERT INTO Song " + "VALUES ("+ song.getSid()+",'"+song.getSname()+"', '"+
	      song.getSinger()+"',"+song.getPrice()+")";
	    	  stmt.executeUpdate(insertSong);
	      }
	    // Insert into Download  
	      for(Download download : downloadList) {
	    	  String insertDownload = "INSERT INTO Download " + "VALUES ("+ download.getSsn()+","+download.getSid()+","+
	      download.getTime()+")";
	    	  stmt.executeUpdate(insertDownload);
	      }
	      System.out.println("2. Three tables created and data is inserted successfully.");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	// Code to perform the necessary queries.
	public static void selectQueries() {
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
			stmt = conn.createStatement();
			
			String query1 = "select distinct ssn,cname from customer where ssn =any "
					+ "(select ssn from download where time > 8);";
			ResultSet rsQuery1 = stmt.executeQuery(query1);
			System.out.println("3. Select queries: ");
			System.out.println("Query 1");
			System.out.println("SSN , CNAME");
			while(rsQuery1.next()){
		         //Retrieve by column name
		         int ssn  = rsQuery1.getInt("ssn");
		         String cname = rsQuery1.getString("cname");
		         System.out.println(ssn +" , "+ cname);
			}
			
			String query2 = "select c.ssn, c.cname from customer as c  join download as d on c.ssn = d.ssn join song as s"
					+ " on s.sid = d.sid group by d.ssn having count(distinct s.price) = 1  order by c.cname";
			ResultSet rsQuery2 = stmt.executeQuery(query2);
			System.out.println("\nQuery 2");
			System.out.println("SSN , CName");
			while(rsQuery2.next()){
		         //Retrieve by column name
		         int ssn  = rsQuery2.getInt("c.ssn");
		         String cname = rsQuery2.getString("c.cname");
		         System.out.println(ssn +" , "+ cname);
			}
			
			String query3 = "select sname,count(distinct profession) from song as s left outer join download d "
					+ "on s.sid = d.sid left outer join customer c on c.ssn = d.ssn group by sname";
			ResultSet rsQuery3 = stmt.executeQuery(query3);
			System.out.println("\nQuery 3");
			System.out.println("SNAME , Count");
			while(rsQuery3.next()){
		         //Retrieve by column name
		         String sname  = rsQuery3.getString("sname");
		         int count = rsQuery3.getInt("count(distinct profession)");
		         System.out.println(sname +" , "+ count);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	// Code to perform necessary updates in the database
	public static void updateQueries() {
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
			stmt = conn.createStatement();
			
			// 1. Update your song table to delete all songs sung by him
			String update1 = "DELETE FROM song where singer = 'Diaz'";
			stmt.executeUpdate(update1);		
			
			// 2. 
			String update21 = "Insert into customer values (217550501,'Josephine','female',27, 'IT')";
			String update22 = "Insert into customer values (217550502,'Jack', 'male',45, 'Consulting')";
			stmt.executeUpdate(update21);
			stmt.executeUpdate(update22);
			
			// 3. Increase by $2 the price of each song whose current price is lower than 4. Update the song table. 
			String update3 = "Update Song SET price = price + 2 where price <4 ";
			stmt.executeUpdate(update3);
			
			// 4. Delete all the download information with download time less than 10. Delete corresponding information in the download table.
			String update4 = "DELETE FROM DOWNLOAD WHERE TIME<10";
			stmt.executeUpdate(update4);
			
			System.out.println("4. Update queries are executed successfully.");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	// Code to print the three tables in the database
	public static void show() {
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
			stmt = conn.createStatement();
			System.out.println("5. Contents of three queries after updating the database: ");
			String showCustomer = "select ssn,cname,gender,age,profession from customer";
			ResultSet rsCustomer = stmt.executeQuery(showCustomer);
			System.out.println("\nCustomer Table: ");
	        System.out.println("Ssn, Name, Gender, Age, Profession");
			while(rsCustomer.next()){
		         //Retrieve by column name
		         int ssn  = rsCustomer.getInt("ssn");
		         String cname = rsCustomer.getString("cname");
		         String gender = rsCustomer.getString("gender");
		         int age = rsCustomer.getInt("age");
		         String profession = rsCustomer.getString("profession"); 
		         //Display values
		         System.out.print(ssn);
		         System.out.print(", " + cname);
		         System.out.print(", " + gender);
		         System.out.print(", " + age);
		         System.out.println(", "+profession);
		      }
			
			String showSong = "select sid, sname, singer, price from song";
			ResultSet rsSong = stmt.executeQuery(showSong);
			System.out.println("\nSong Table: ");
			System.out.println("Sid, Song Name, Singer, Price");
			while(rsSong.next()){
		         //Retrieve by column name
		         int sid  = rsSong.getInt("sid");
		         String sname = rsSong.getString("sname");
		         String singer = rsSong.getString("singer");
		         int price = rsSong.getInt("price");
		         //Display values
		         System.out.print(sid);
		         System.out.print(", " + sname);
		         System.out.print(", " + singer);
		         System.out.println(", " + price);
		      }
			System.out.println("\nDownload Table");
			String showDownload = "select sid,ssn,time from download";
			ResultSet rsDownload = stmt.executeQuery(showDownload);
			System.out.println("Ssn, Ssn, Time");
			while(rsDownload.next()){
		         //Retrieve by column name
		         int ssn  = rsDownload.getInt("ssn");
		         int sid = rsDownload.getInt("sid");
		         int time = rsDownload.getInt("time");
		         //Display values
		         System.out.print(ssn);
		         System.out.print(", " + sid);
		         System.out.println(", " + time);
		      }
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	// Code to drop the three tables in the database
	public static void dropTables() {
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
			stmt = conn.createStatement();
			
			String dropDownload = "Drop table download";
			String dropCustomer = "Drop table customer";
			String dropSong = "Drop table song";
			stmt.executeUpdate(dropDownload);
			stmt.executeUpdate(dropCustomer);
			stmt.executeUpdate(dropSong);
			System.out.println("All the tables dropped successfully.");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
}
