package domain;

import java.util.ArrayList;

public class Download {
	public static ArrayList<String> downloadHeader;
	public static ArrayList<String> downloadDatatype;
	
	public static ArrayList<String> getDownloadHeader() {
		return downloadHeader;
	}
	public static void setDownloadHeader(ArrayList<String> downloadHeader) {
		Download.downloadHeader = downloadHeader;
	}
	public static ArrayList<String> getDownloadDatatype() {
		return downloadDatatype;
	}
	public static void setDownloadDatatype(ArrayList<String> downloadDatatype) {
		Download.downloadDatatype = downloadDatatype;
	}
	private String ssn;
	private String sid;
	private String time;
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	
}
