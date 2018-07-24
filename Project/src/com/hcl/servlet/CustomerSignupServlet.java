package com.hcl.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hcl.bean.CustomerBean;
import com.hcl.dao.CustomerDao;

/**
 * Servlet implementation class CustomerSignupServlet
 */
public class CustomerSignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerSignupServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		
		
		String name=req.getParameter("name");
		String user=req.getParameter("username");
		String pass=req.getParameter("userpass");
		String gender=req.getParameter("gender");
		String address=req.getParameter("address");
		String contact=req.getParameter("contactno");
		double m=Double.parseDouble(contact);
		String email=req.getParameter("emailid");
		
		CustomerBean bean=new CustomerBean();
		
		bean.setName(name);
		bean.setUsername(user);
		bean.setUserpass(pass);
		bean.setGender(gender);
		bean.setAddress(address);
		bean.setContactno(m);
		bean.setEmailid(email);
		
		CustomerDao dao=new CustomerDao();
		boolean flag=dao.createLogin(bean);
		/*if(flag=true)
		{
			out.println("<h1>User added Successfully<h1>");
		}
		else
		{
			out.println("<h1>unsuccessfull</h1>");
		}*/
		RequestDispatcher rd=req.getRequestDispatcher("DisplayCustomerServlet");
		rd.forward(req, res);
	}

}
