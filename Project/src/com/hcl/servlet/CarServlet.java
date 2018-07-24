package com.hcl.servlet;

import java.io.IOException;
import java.io.PrintWriter;

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
 * Servlet implementation class CarServlet
 */
public class CarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		
		String id=req.getParameter("carid");
		int n=Integer.parseInt(id);
		String carname=req.getParameter("carname");
		String carnumber=req.getParameter("carnumber");
		String carseater=req.getParameter("carseater");
		int m=Integer.parseInt(carseater);
		String cartype=req.getParameter("cartype");
	
		CarBean bean=new CarBean();
		bean.setCarid(n);
		bean.setCarname(carname);
		bean.setCarnumber(carnumber);
		bean.setCarseater(m);
		bean.setCartype(cartype);
		
		CarDao dao=new CarDao();
		boolean flag=dao.addCar(bean);
		/*if(flag=true)
		{
			out.println("<h1>Car added Successfully<h1>");
		}
		else
		{
			out.println("<h1>unsuccessfull</h1>");
		}*/
		RequestDispatcher rd=req.getRequestDispatcher("DisplayCarServlet");
		rd.forward(req, res);
	}
	}
