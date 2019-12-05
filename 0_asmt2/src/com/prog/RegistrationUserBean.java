package com.prog;
import java.io.Serializable;

public class RegistrationUserBean implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private String uid_;
    private String fname_;
    private String lname_;
    private String pass_;
    

    public RegistrationUserBean() {
        this.uid_ = "";
        this.fname_ = "";
        this.lname_="";
        this.pass_="";
    }
   
    public RegistrationUserBean(String uid, String first_name) {
        this.uid_ = uid;
    	this.fname_ = first_name;
    }
 
    
    public RegistrationUserBean(String uid, String first_name, String last_name, String pass) {
        this.uid_ = uid;
    	this.fname_ = first_name;
    	this.lname_ = last_name;
    	this.pass_ = pass;
    }
   


	public String getFname() {
		return fname_;
	}


	public void setFname(String fname_) {
		this.fname_ = fname_;
	}


	public String getLname() {
		return lname_;
	}


	public void setLname(String lname_) {
		this.lname_ = lname_;
	}


	public String getPass() {
		return pass_;
	}


	public void setPass(String pass_) {
		this.pass_ = pass_;
	}

	public String getUid_() {
		return uid_;
	}


	public void setUid(String uid) {
		this.uid_ = uid;
	}

    
   
}
