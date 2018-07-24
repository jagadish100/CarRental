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
 * Servlet implementation class CustomerDeleteServlet
 */
public class CustomerDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String customerid=request.getParameter("CUSTOMER_ID");
		System.out.println(" cust = "+customerid);
		int n=Integer.parseInt(customerid);
		CustomerDao  dao=new CustomerDao();
		boolean flag=dao.deleteCustomer(customerid);
		RequestDispatcher  rd=request.getRequestDispatcher("DisplayCustomerServlet");
		rd.forward(request, response);
	}

}
