package com.prog;

public class User {
	private String uid;
	private String fname;
	private String lname;
	private String pass;
	
	public User(String uid, String fname, String lname, String pass) 
	{
		this.uid = uid;
		this.fname = fname;
		this.lname = lname;
		this.pass = pass;
	}
	
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	
}
