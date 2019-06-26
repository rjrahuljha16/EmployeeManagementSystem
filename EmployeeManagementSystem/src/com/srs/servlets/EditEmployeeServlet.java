package com.srs.servlets;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.srs.bean.EmployeeBean;
import com.srs.conn.ConnectionUtils;
import com.srs.dao.EmployeeDao;

@WebServlet("/EditEmployeeServlet")
public class EditEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EditEmployeeServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String emp_id=request.getParameter("emp_id");
		
		EmployeeBean employee =null;
		
		try {
			Connection conn=ConnectionUtils.getMySQLConnection();
			employee=EmployeeDao.findEmployee(conn, emp_id);
			request.setAttribute("employee", employee);
			System.out.println("Employee object added in attribute");

			RequestDispatcher dispatcher = request.getRequestDispatcher("editemployee.jsp");
			dispatcher.forward(request, response);
		}
		catch(Exception e) {
			System.out.println("Edit employee get block");
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String emp_id=request.getParameter("emp_id");
		String name=request.getParameter("name");
		String department=request.getParameter("mobile");
		String mobile=request.getParameter("department");
		String status =request.getParameter("status");
		String email=request.getParameter("email");
		
		EmployeeBean employee= new EmployeeBean(emp_id, name, department, mobile, status, email);
		System.out.println("==="+employee);
		try {
			Connection conn=ConnectionUtils.getMySQLConnection();
			
			EmployeeDao.updateEmployee(conn, employee);
			
			response.sendRedirect("LoginServlet");
			
			
			
		}catch(Exception e) {
			System.out.println("update employee post method exception");
			e.printStackTrace();
		}
	
	}

}
