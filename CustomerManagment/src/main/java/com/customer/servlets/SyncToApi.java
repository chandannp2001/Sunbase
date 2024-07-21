package com.customer.servlets;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import com.customer.DAOImpl.CustomerDAOImpl;
import com.customer.Model.Customer;

@WebServlet("/addcustomer")
public class SyncToApi extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static CustomerDAOImpl cimpl ;
	@Override
	public void init() throws ServletException {
		 cimpl = new CustomerDAOImpl();
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String firstname = req.getParameter("firstname");
		String lastname = req.getParameter("lastname");
		String email = req.getParameter("email");
		String phonenumber = req.getParameter("phonenumber").trim();
		long longphone = Long.parseLong(phonenumber);
		String street = req.getParameter("street");
		String Address = req.getParameter("Address");
		String city = req.getParameter("city");
		String state = req.getParameter("state");
		
		HttpSession session = req.getSession();
		
		String sync = "https://qa.sunbasedata.com/sunbase/portal/api/assignment.jsp?cmd=create";
		
		URL url = new URL(sync);
		
		HttpURLConnection connection = (HttpURLConnection)url.openConnection();
		
		connection.setRequestMethod("POST");

		connection.setRequestProperty("Content-Type", "application/json");
		
		connection.setRequestProperty("Authorization", "Bearer " +(String)session.getAttribute("Token") );	
		
		connection.setDoOutput(true);
		
		JSONObject jsonobject = new JSONObject();
		jsonobject.put("first_name", firstname);
		jsonobject.put("last_name", lastname);
		jsonobject.put("street", street);
		jsonobject.put("address", Address);
		jsonobject.put("city", city);
		jsonobject.put("state", state);
		jsonobject.put("email", email);
		jsonobject.put("phone", phonenumber);
//		jsonobject.put("uuid", req.getParameter("cid"));
		
		OutputStream outputStream = connection.getOutputStream();
		outputStream.write(jsonobject.toString().getBytes());
		System.out.println(jsonobject);
		outputStream.flush();
		outputStream.close();
		
		int responseCode = connection.getResponseCode();
		System.out.println(responseCode);
		
		if(responseCode==HttpURLConnection.HTTP_CREATED) {
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			StringBuilder response  = new StringBuilder();
			String line;
			while((line=bufferedReader.readLine())!= null){
				response.append(line);
			}
			
			List<Customer> getAllCustomer = cimpl.getAllCustomer();
			session.setAttribute("AllCustomers", getAllCustomer);
			req.setAttribute("message", "Customer "+firstname+" "+lastname+" succesfully synced to API");
			System.out.println(response);
			req.getRequestDispatcher("Customerdetails.jsp").forward(req, resp);
			return;

		}else {
			System.out.println("else");
			req.setAttribute("message", "Customer "+firstname+" "+lastname+" not synced to API");
			req.getRequestDispatcher("Customerdetails.jsp").forward(req, resp);
			return;
		}
	}

}
