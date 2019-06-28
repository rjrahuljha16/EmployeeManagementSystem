package com.srs.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.srs.bean.EmployeeBean;
import com.srs.bean.UserBean;
import com.srs.conn.ConnectionUtils;
import com.srs.dao.EmployeeDao;
import com.srs.dao.UserDao;

//@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}

	// whenever a Get method request will come this part of code will run.

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Connection conn = ConnectionUtils.getMySQLConnection();

			List<EmployeeBean> empList = null;
			empList = EmployeeDao.showEmployee(conn);
			request.setAttribute("empList", empList);
			RequestDispatcher dispatcher = request.getRequestDispatcher("dashboard.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			System.out.println("login page get method");
			e.printStackTrace();
		}

	}

	// Read the data from loginform page and validate the user and if successful it
	// will send to dashboard and if not send back to same loginform page with
	// errorString

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println("email id" + email);
		System.out.println("password " + password);
		String errorString = null;
		try {
			Connection conn = ConnectionUtils.getMySQLConnection();
			System.out.println("Connection done");
			UserBean user = UserDao.userLogin(conn, email, password);
			if (user == null) {

				errorString = "Invalid user name or password";

				// Store information in request attribute before forward

				request.setAttribute("errorString", errorString);
				RequestDispatcher dispatcher = request.getRequestDispatcher("loginform.jsp");
				dispatcher.forward(request, response);

			} else {
				HttpSession session = request.getSession();
				session.setAttribute("name", user.getFirstName());
				List<EmployeeBean> empList = null;
				empList = EmployeeDao.showEmployee(conn);
				request.setAttribute("empList", empList);
				RequestDispatcher dispatcher = request.getRequestDispatcher("dashboard.jsp");
				dispatcher.forward(request, response);
			}
		} catch (Exception e) {
			System.out.println("Exception with login servlet");
			e.printStackTrace();
		}
	}

}
