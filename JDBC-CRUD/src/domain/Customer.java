package domain;

import java.util.ArrayList;

public class Customer {
	public static ArrayList<String> customerHeaders = null; 
	public static ArrayList<String>  customerDatatype= null;
	private String ssn;
	private String cname;
	private String gender;
	private String age;
	private String profession;
	
	
	public static ArrayList<String> getCustomerHeaders() {
		return customerHeaders;
	}
	public static void setCustomerHeaders(ArrayList<String> customerHeaders) {
		Customer.customerHeaders = customerHeaders;
	}
	public static ArrayList<String> getCustomerDatatype() {
		return customerDatatype;
	}
	public static void setCustomerDatatype(ArrayList<String> customerDatatype) {
		Customer.customerDatatype = customerDatatype;
	}
	
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	
	
}
