package dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.mysql.fabric.xmlrpc.base.Data;

import domain.Customer;
import domain.Download;
import domain.Song;

public class CollectData {
	public static void insertData(String customerFile, String songFile, String downloadFile) {
		List<Customer> customerList = new ArrayList<Customer>();
		customerList = collectUsers(customerFile);
		List<Song> songList = new ArrayList<Song>();
		songList = collectSongs(songFile);
		List<Download> downloadList = new ArrayList<Download>();
		downloadList = collectDownloads(downloadFile);
		DBOperations.insertDB(customerList, songList, downloadList);
		
	}
	public static List<Customer> collectUsers(String fileName){
		
		List<Customer> customerList = new ArrayList<Customer>();
		try {
			FileReader fileReader = new FileReader(fileName);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line = "null";
			String firstLine = bufferedReader.readLine();
			List<String> firstList = Arrays.asList(firstLine.split(","));
			ArrayList<String> headerList = new ArrayList<String>();
			ArrayList<String> dataTypeList = new ArrayList<String>();
			
			for(String item : firstList) {
				item = item.trim();
				String[] splited = item.split("\\s+");
				String s;
				headerList.add(splited[0]);
				// Checks for Number() and replaces it with Integer
				if(splited[1].toLowerCase().matches("number(.*)")) {
					s = "INTEGER";
					dataTypeList.add(s);
					continue;
				} 
				dataTypeList.add(splited[1]);
			}
			Customer.setCustomerHeaders(headerList);
			Customer.setCustomerDatatype(dataTypeList);
			
			while((line = bufferedReader.readLine()) != null) {
				List<String> tempList = Arrays.asList(line.split(","));
				Customer customer = new Customer();
				customer.setSsn(tempList.get(0));
				customer.setCname(tempList.get(1));
				customer.setGender(tempList.get(2));
				customer.setAge(tempList.get(3));
				customer.setProfession(tempList.get(4));
				customerList.add(customer);
            } 
			bufferedReader.close();
			
		} catch (FileNotFoundException e) {
			System.out.println(" Please ensure that the file name is customer.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return customerList;
	}
	public static List<Song> collectSongs(String fileName){
		List<Song> songList = new ArrayList<Song>();
		try {
			FileReader fileReader = new FileReader(fileName);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line = "null";
			String firstLine = bufferedReader.readLine();
			List<String> firstList = Arrays.asList(firstLine.split(","));
			ArrayList<String> headerList = new ArrayList<String>();
			ArrayList<String> dataTypeList = new ArrayList<String>();
			
			for(String item : firstList) {
				item = item.trim();
				String[] splited = item.split("\\s+");
				String s;
				headerList.add(splited[0]);
				if(splited[1].toLowerCase().matches("number(.*)")) {
					s = "INTEGER";
					dataTypeList.add(s);
					continue;
				} 
				dataTypeList.add(splited[1]);
			}
			Song.setSongHeaders(headerList);
			Song.setSongDatatype(dataTypeList);
			
			while((line = bufferedReader.readLine()) != null) {
				List<String> tempList = Arrays.asList(line.split(","));
				Song song = new Song();
				song.setSid(tempList.get(0));
				song.setSname(tempList.get(1));
				song.setSinger(tempList.get(2));
				song.setPrice(tempList.get(3));
				songList.add(song);
            } 
			bufferedReader.close();
			
		} catch (FileNotFoundException e) {
			System.out.println(" Please ensure that the file name is customer.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return songList;
	}
	public static List<Download> collectDownloads(String fileName){
		List<Download> downloadList = new ArrayList<Download>();
		try {
			FileReader fileReader = new FileReader(fileName);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line = "null";
			String firstLine = bufferedReader.readLine();
			List<String> firstList = Arrays.asList(firstLine.split(","));
			ArrayList<String> headerList = new ArrayList<String>();
			ArrayList<String> dataTypeList = new ArrayList<String>();
			
			for(String item : firstList) {
				item = item.trim();
				String[] splited = item.split("\\s+");
				String s;
				headerList.add(splited[0]);
				if(splited[1].toLowerCase().matches("number(.*)")) {
					s = "INTEGER";
					dataTypeList.add(s);
					continue;
				} 
				dataTypeList.add(splited[1]);
			}
			Download.setDownloadHeader(headerList);
			Download.setDownloadDatatype(dataTypeList);
			
			while((line = bufferedReader.readLine()) != null) {
				List<String> tempList = Arrays.asList(line.split(","));
				Download download = new Download();
				download.setSsn(tempList.get(0));
				download.setSid(tempList.get(1));
				download.setTime(tempList.get(2));
				downloadList.add(download);
            } 
			bufferedReader.close();
			
		} catch (FileNotFoundException e) {
			System.out.println(" Please ensure that the file name is customer.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return downloadList;
	}
}
