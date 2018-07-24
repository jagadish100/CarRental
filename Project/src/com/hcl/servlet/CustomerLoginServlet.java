package com.hcl.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hcl.bean.CustomerBean;
import com.hcl.dao.CustomerLoginDao;

/**
 * Servlet implementation class CustomerLoginServlet
 */
public class CustomerLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		
		String user=req.getParameter("username");
		String pass=req.getParameter("userpass");
		
		CustomerBean bean=new CustomerBean();
		bean.setUsername(user);
		bean.setUserpass(pass);
		
		CustomerLoginDao dao=new CustomerLoginDao();
		boolean flag=dao.validate(bean);
		
		if(flag==true)
		{
			out.println("<h1>Login Success<h1>");
		}
		else
		{
			out.println("<h1>Login Failed<h1>");
		}
	}

}
