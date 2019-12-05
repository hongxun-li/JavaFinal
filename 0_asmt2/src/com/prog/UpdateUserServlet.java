package com.prog;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateUserServlet
 */
@WebServlet("/UpdateUserServlet")
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUserServlet() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	     RequestDispatcher rd =null;

			
	   String fname = request.getParameter("fname_");
      String lname = request.getParameter("lname_");
      String pass = request.getParameter("pass_");
  	   String uid = request.getParameter("uid_");
          
    
      //create an object for matching validation
      RegistrationDAO dao = null;
		try {
				dao = new RegistrationDAO();
			RegistrationUserBean bean = dao.updateUser(uid, fname, lname, pass);
       
        
			//Succeed on registration (if data recorded to table)
			if (bean != null) {rd = request.getRequestDispatcher("/WEB-INF/jsp/display_userlist.jsp");}
        
			else {rd = request.getRequestDispatcher("LoginFail.jsp");}
        
			rd.forward(request, response);
		} 
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally 
		{ dao.close();}
		
      

        
	}

}
