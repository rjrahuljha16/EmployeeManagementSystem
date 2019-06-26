package com.srs.servlets;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.srs.conn.ConnectionUtils;
import com.srs.dao.EmployeeDao;

@WebServlet("/DeleteEmployeeServlet")
public class DeleteEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public DeleteEmployeeServlet() {
        super();
   
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String emp_id=request.getParameter("emp_id");
		try {
			Connection conn=ConnectionUtils.getMySQLConnection();
			EmployeeDao.deleteEmployee(conn, emp_id);
			
			response.sendRedirect("LoginServlet");

			
		}catch(Exception e) {
			System.out.println("Delete servlet exception");
			e.printStackTrace();
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
