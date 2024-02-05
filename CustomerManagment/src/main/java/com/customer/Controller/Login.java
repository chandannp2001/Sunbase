package com.customer.Controller;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.customer.Utility.Authentication;

@WebServlet("/Login")
public class Login extends HttpServlet{
	
	@Override
	public void init() throws ServletException {
		
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		//Authentication using username,password
		String token = Authentication.GetToken(username, password);//"test@sunbasedata.com", "Test@123"
		
			if(token!=null) {
				HttpSession session = req.getSession();
				//Storing  token in session
				session.setAttribute("Token", token);
				session.setAttribute("AllCustomers", null);
				req.getRequestDispatcher("/CustomerDetails").forward(req, resp);
				
			}
		
		
		req.setAttribute("errorMessage", "Entered Credential are Invalid");

		RequestDispatcher rd2 = req.getRequestDispatcher("LogIn.jsp");
		rd2.include(req, resp);
		
	}
	
	
}
