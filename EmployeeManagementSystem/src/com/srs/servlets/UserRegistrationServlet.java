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

@WebServlet("/UserRegistrationServlet")
public class UserRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserRegistrationServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

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
			if(user==null)
			{
				errorString="Registration failed";
				
				request.setAttribute("errorString", errorString);
				RequestDispatcher dispatcher = request.getRequestDispatcher("registration.jsp");
				dispatcher.forward(request, response);
			}
			else {
				response.sendRedirect("loginform.jsp");
			}

		} catch (Exception e) {
			System.out.println("Exeption in registration servlet");
			e.printStackTrace();

		}

	}

}
