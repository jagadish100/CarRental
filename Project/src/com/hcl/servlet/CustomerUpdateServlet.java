package com.hcl.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hcl.dao.CarDao;
import com.hcl.dao.CustomerDao;

/**
 * Servlet implementation class CustomerUpdateServlet
 */
public class CustomerUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		
		String name=request.getParameter("name");
		String username=request.getParameter("username");
		String userpass=request.getParameter("userpass");
		String gender=request.getParameter("gender");
		String address=request.getParameter("address");
		double m=Double.parseDouble("contactno");
		String emailid=request.getParameter("emailid");
		
		CustomerDao  dao=new CustomerDao();
		boolean flag=dao.updateCustomerDetails(name,username,userpass,gender,address,m,emailid);
		RequestDispatcher  rd=request.getRequestDispatcher("DisplayCarServlet");
		rd.forward(request, response);
	}

}
