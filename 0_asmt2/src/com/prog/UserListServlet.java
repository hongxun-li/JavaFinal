package com.prog;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.prog.User;

/**
 * Servlet implementation class UserListServlet
 */
@WebServlet("/UserListServlet")
public class UserListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String DriverName = "com.mysql.jdbc.Driver";
		String JDBCurl ="jdbc:mysql://localhost:3306/asmt2?autoReconnect=true&useSSL=false";
		String userID = "root";
		String userPASS="1234";

		Connection con_ = null;
	    ResultSet rs_ = null;
	    PreparedStatement ps_ = null;
	    RequestDispatcher rd;


	    List<User> list = new ArrayList<User>();
	
	    try {
            Class.forName(DriverName);
            con_ = DriverManager.getConnection(JDBCurl, userID, userPASS);
            
        }catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
        }catch(SQLException se) {se.printStackTrace();}
	    
	    //collect userlist from table
	    try 
	    {
	    	ps_=con_.prepareStatement("SELECT * FROM userlist");  
	    	 
	    	 rs_ = ps_.executeQuery();
	    	 while(rs_.next()) 
	    	 {
	    		 String uid = rs_.getString("uid");
	    		 String fname = rs_.getString("first_name");
	    		 String lname = rs_.getString("last_name");
	    		 String pass = rs_.getString("pass");
	    		 list.add(new User(uid, fname, lname, pass));
	    		 
	    	 }
	    	request.setAttribute("users", list);
	        rd = request.getRequestDispatcher("/WEB-INF/jsp/display_userlist.jsp");
	        rd.forward(request, response);
	        
	    }
	    catch(SQLException se) {se.printStackTrace();}
	    finally 
	    {
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
