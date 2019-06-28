package com.srs.servlets;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.srs.bean.UserBean;
import com.srs.conn.ConnectionUtils;
import com.srs.dao.UserDao;

public class UserRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserRegistrationServlet() {
		super();

	}

	/**
	 * SignUp opertaion::This method will read data from user registration page and
	 * store the data in database and redirect the page to loginform
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String number = request.getParameter("number");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String secqQuestion = request.getParameter("question");
		String secqAnswer = request.getParameter("answer");
		System.out.println(firstname);
		String errorString = null;
		try {
			Connection conn = ConnectionUtils.getMySQLConnection();
			System.out.println("Connection done");
			UserBean user = UserDao.registerEmployee(conn, firstname, lastname, number, email, password, secqQuestion,
					secqAnswer);
			if (user == null) {
				errorString = "Oops Something went Wrong!! Registration failed.";

				request.setAttribute("errorString", errorString);
				RequestDispatcher dispatcher = request.getRequestDispatcher("registration.jsp");
				dispatcher.forward(request, response);
			} else {
				errorString = "Registration Done Succefully! Please Login.";
				request.setAttribute("errorString", errorString);

				RequestDispatcher dispatcher = request.getRequestDispatcher("loginform.jsp");
				dispatcher.forward(request, response);
			}

		} catch (Exception e) {
			System.out.println("Exeption in registration servlet");
			e.printStackTrace();

		}

	}

}
