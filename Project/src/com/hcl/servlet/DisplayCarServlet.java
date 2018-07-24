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
import com.hcl.dao.CarDao;

/**
 * Servlet implementation class DisplayCarServlet
 */
public class DisplayCarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayCarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		
		CarDao dao=new CarDao();
		List<CarBean> list=dao.listAll();
		req.setAttribute("list", list);
		RequestDispatcher rd=req.getRequestDispatcher("view1.jsp");
		rd.forward(req, res);
	}

}
