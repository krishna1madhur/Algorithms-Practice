package domain;

import java.util.ArrayList;

public class Song {
	public static ArrayList<String> songHeaders;
	public static ArrayList<String> songDatatype;
	
	public static ArrayList<String> getSongHeaders() {
		return songHeaders;
	}
	public static void setSongHeaders(ArrayList<String> songHeaders) {
		Song.songHeaders = songHeaders;
	}
	public static ArrayList<String> getSongDatatype() {
		return songDatatype;
	}
	public static void setSongDatatype(ArrayList<String> songDatatype) {
		Song.songDatatype = songDatatype;
	}
	
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSinger() {
		return singer;
	}
	public void setSinger(String singer) {
		this.singer = singer;
	}
	
	private String sid;
	private String sname;
	private String singer;
	private String price;
	
}
