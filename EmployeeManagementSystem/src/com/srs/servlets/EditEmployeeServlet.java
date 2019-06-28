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

	// Get the emp_id from dashboard to get the employee details from table to send
	// to front end to edit the data

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String emp_id = request.getParameter("emp_id");

		EmployeeBean employee = null;

		try {
			Connection conn = ConnectionUtils.getMySQLConnection();
			employee = EmployeeDao.findEmployee(conn, emp_id);
			request.setAttribute("employee", employee);
			System.out.println("Employee object added in attribute");

			RequestDispatcher dispatcher = request.getRequestDispatcher("editemployee.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			System.out.println("Edit employee get block");
			e.printStackTrace();
		}
	}

	// Read the data from editemployee.jsp page and update the changes in database.

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String emp_id = request.getParameter("emp_id");
		String name = request.getParameter("name");
		String department = request.getParameter("department");
		String mobile = request.getParameter("mobile");
		String status = request.getParameter("status");
		String email = request.getParameter("email");

		EmployeeBean employee = new EmployeeBean(emp_id, name, mobile, department, status, email);
		System.out.println("===" + employee);
		try {
			Connection conn = ConnectionUtils.getMySQLConnection();

			EmployeeDao.updateEmployee(conn, employee);

			response.sendRedirect("LoginServlet");

		} catch (Exception e) {
			System.out.println("update employee post method exception");
			e.printStackTrace();
		}

	}

}
