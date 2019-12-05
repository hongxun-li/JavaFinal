package com.prog;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class RegistrationDAO {

	String DriverName = "com.mysql.jdbc.Driver";
	String JDBCurl ="jdbc:mysql://localhost:3306/asmt2?autoReconnect=true&useSSL=false";
	String userID = "root";
	String userPASS="1234";

	private Connection con_ = null;
	private ResultSet rs_ = null;
	private PreparedStatement ps_ = null;

	public RegistrationDAO() throws SQLException {
		try {
			Class.forName(DriverName);
			con_ = DriverManager.getConnection(JDBCurl, userID, userPASS);

		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
	}

    //search the matching data from table
    public RegistrationUserBean selectUser(String uid, String pass) 
    		throws SQLException {
		RegistrationUserBean newBean = null;

    	//create sql statement
        String sql = "Select * from userlist where uid = ? and pass=?";
    	ps_ = con_.prepareStatement(sql);
    	
        // set id and pass to sql statement
        ps_.setString(1, uid);
        ps_.setString(2, pass);

        //execute sql statement
        rs_ = ps_.executeQuery();
        
		if(rs_.last()) {
			newBean = new RegistrationUserBean(rs_.getString(1), rs_.getString(2), rs_.getString(3), rs_.getString(4));
		}
		return newBean;
    }

	
	//add user to table
	public RegistrationUserBean addUser(String uid, String fname, String lname, String pass) 
			throws SQLException {
		RegistrationUserBean newBean = null;


		String sql =
				( "INSERT INTO userlist "
						+ "(uid, first_name, last_name, pass)"
						+ "VALUES (?,?,?,?)"
						);

		ps_ = con_.prepareStatement(sql);

		ps_.setString(1, uid);
		ps_.setString(2, fname);
		ps_.setString(3, lname);
		ps_.setString(4, pass);

		ps_.executeUpdate();

		sql = "Select * from userlist where uid = ?";


		ps_ = con_.prepareStatement(sql);
		ps_.setString(1, uid);

		rs_ = ps_.executeQuery();
		if(rs_.last()) {
			newBean = new RegistrationUserBean(rs_.getString(1), rs_.getString(2), rs_.getString(3), rs_.getString(4));
		}

		return newBean;
	}

	  //delete user 
    public RegistrationUserBean deleteUser(String uid, String fname) 
    		throws SQLException {
    	RegistrationUserBean newBean = null;
    	
    	//delete
    	String sql = "DELETE FROM userlist WHERE uid = ? AND first_name=?";
    	ps_ = con_.prepareStatement(sql);
        ps_.setString(1, uid);
        ps_.setString(2, fname);
        ps_.executeUpdate();
  	    
        //validation
    	sql = "Select * from userlist where uid = ? AND first_name=?";
        ps_ = con_.prepareStatement(sql);
        ps_.setString(1, uid);
        ps_.setString(2, fname);              
        rs_ = ps_.executeQuery();
        
        if(rs_.last()) {
        	newBean = new RegistrationUserBean(rs_.getString(1), rs_.getString(2), rs_.getString(3), rs_.getString(4));
        }
        
        return newBean;
    }

	//update user on table
	public RegistrationUserBean updateUser(String uid, String fname, String lname, String pass) 
			throws SQLException {
		RegistrationUserBean newBean = null;

		//delete
		String sql = "UPDATE userlist SET first_name=?, last_name=?, pass=? WHERE uid=?";
		ps_ = con_.prepareStatement(sql);
		ps_.setString(1, fname);
		ps_.setString(2, lname);
		ps_.setString(3, pass);
		ps_.setString(4, uid);
		ps_.executeUpdate();

		//validation
		sql = "SELECT * FROM userlist WHERE uid = ? AND first_name=?";
		ps_ = con_.prepareStatement(sql);
		ps_.setString(1, uid);
		ps_.setString(2, fname);              
		rs_ = ps_.executeQuery();

		if(rs_.last()) {
			newBean = new RegistrationUserBean(rs_.getString(1), rs_.getString(2), rs_.getString(3), rs_.getString(4));
		}

		return newBean;
	}

    
    
    
	//close connection
	public void close() {
		try {
			if (con_ != null) {
				con_.close();
			}
			if (ps_ != null) {
				ps_.close();
			}
			if (rs_ != null) {
				rs_.close();
			}
		} catch (SQLException se) {
			// connection failure
			se.printStackTrace();
		}
	}
}

