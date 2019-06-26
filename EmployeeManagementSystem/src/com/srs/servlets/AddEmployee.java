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

@WebServlet("/AddEmployee")
public class AddEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddEmployee() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String mobile = request.getParameter("mobile");
		String department = request.getParameter("department");
		String status = request.getParameter("status");
		String email = request.getParameter("email");
		String errorString = null;
		try {
			Connection conn = ConnectionUtils.getMySQLConnection();

			EmployeeBean employee = EmployeeDao.addEmployee(conn, name, mobile, department, status, email);
			if (employee == null) {
				errorString = "Unable to Add Employee";

				request.setAttribute("errorString", errorString);
				RequestDispatcher dispatcher = request.getRequestDispatcher("addemployee.jsp");
				dispatcher.forward(request, response);
			}
			else {
				String successString="Employee Added Succesfully";
				
				request.setAttribute("errorString", successString);
				RequestDispatcher dispatcher = request.getRequestDispatcher("addemployee.jsp");
				dispatcher.forward(request, response);
				System.out.println("Employee Added");
			}

		} catch (Exception e) {
			System.out.println("Exception in Add employee Servlet");
			e.printStackTrace();

		}

	}

}
