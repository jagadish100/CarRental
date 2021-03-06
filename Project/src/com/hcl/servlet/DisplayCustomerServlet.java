package com.hcl.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hcl.bean.CarBean;
import com.hcl.bean.CustomerBean;
import com.hcl.dao.CarDao;
import com.hcl.dao.CustomerDao;

/**
 * Servlet implementation class DisplayCustomerServlet
 */
public class DisplayCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayCustomerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		
		CustomerDao dao=new CustomerDao();
		List<CustomerBean> list=dao.listAllCustomers();
		req.setAttribute("customerlist", list);
		RequestDispatcher rd=req.getRequestDispatcher("customerlist.jsp");
		rd.forward(req, res);
	}

}
