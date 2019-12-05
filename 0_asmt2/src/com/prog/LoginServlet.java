package com.prog;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
          	//collect input from index.jsp
            String uid = request.getParameter("uid_");
            String pass = request.getParameter("pass_");
            
            RequestDispatcher rd = null;
            //create an object to store data from table for user validation
            RegistrationDAO dao = null;
           
            //bring the matching data from table  //executeSelectUserInfo on video
            //forward the data from index.jsp
            try {
            dao = new RegistrationDAO();
            RegistrationUserBean bean = dao.selectUser(uid, pass);
            
            //Succeed on login (if user is found on table)
            if (bean != null) {
 
            	if(uid.equals("999")){
            	  
            	  rd = request.getRequestDispatcher("UserListServlet");
               }
              else{//forward to purchase page with username
                rd = request.getRequestDispatcher("ItemListServlet");
              }
            //user not found on table
            } else {
            	//back to login page
                rd = request.getRequestDispatcher("LoginFail.jsp");
            }
            
            rd.forward(request, response);
    		} catch (SQLException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}finally {dao.close();}


	}

}
