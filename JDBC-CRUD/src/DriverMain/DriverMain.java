package DriverMain;

import dao.CollectData;
import dao.DBOperations;

public class DriverMain {
	public static void main(String[] args) {
		String customerFile = "customer.txt";
		String songFile = "song.txt";
		String downloadFile = "download.txt";
		
		// Functions 1 and 2- Create tables and insert the data

		CollectData.insertData(customerFile, songFile, downloadFile);
		// Function 3- Select queries 
		DBOperations.selectQueries();
		// Function 4- Update database
		DBOperations.updateQueries();
		// Function 5- Print the contents of three tables
		DBOperations.show();
		// Function 6- Drop the tables
		DBOperations.dropTables();
	}
}
