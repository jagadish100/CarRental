package com.hcl.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hcl.dao.CarDao;

/**
 * Servlet implementation class CarUpdateServlet
 */
public class CarUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CarUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String carid=request.getParameter("carid");
		int n=Integer.parseInt(carid);
		String carname=request.getParameter("carname");
		String carnumber=request.getParameter("carnumber");
		String carseater=request.getParameter("carseater");
		int m=Integer.parseInt(carseater);
		String cartype=request.getParameter("cartype");
		
		CarDao  dao=new CarDao();
		boolean flag=dao.updateCar(carname,carnumber,m,cartype,n);
		RequestDispatcher  rd=request.getRequestDispatcher("DisplayCarServlet");
		rd.forward(request, response);
		
		
	}

}
