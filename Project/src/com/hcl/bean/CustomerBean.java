package com.hcl.bean;

/**
 * @author user19
 *
 */
public class CustomerBean {

	private int customer_id;
	private String name;
	private String username;
	private String userpass;
	private String gender;
	private String address;
	private double contactno;
	private String emailid;
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserpass() {
		return userpass;
	}
	public void setUserpass(String userpass) {
		this.userpass = userpass;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public double getContactno() {
		return contactno;
	}
	public void setContactno(double contactno) {
		this.contactno = contactno;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	@Override
	public String toString() {
		return "CustomerBean [customer_id=" + customer_id + ", name=" + name + ", username=" + username + ", userpass="
				+ userpass + ", gender=" + gender + ", address=" + address + ", contactno=" + contactno + ", emailid="
				+ emailid + "]";
	}
	
	
	
}
