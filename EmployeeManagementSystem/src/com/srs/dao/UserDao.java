package com.srs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.srs.bean.UserBean;

public class UserDao {

	// Query to get the user details from table for login validation

	public static UserBean userLogin(Connection conn, String email, String password) throws Exception {
		String sql = "select u.first_name,u.password from user u where u.email_id=? and u.password=?";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1, email);
		pst.setString(2, password);
		ResultSet resultset = pst.executeQuery();
		if (resultset.next()) {
			String name = resultset.getString("first_name");
			UserBean user = new UserBean();
			user.setEmail(email);
			user.setPassword(password);
			user.setFirstName(name);
			return user;
		}
		return null;
	}


	/**
	 * @param conn
	 * @param firstname
	 * @param lastname
	 * @param number
	 * @param email
	 * @param password
	 * @param secqQuestion
	 * @param secqAnswer
	 * @return
	 * @throws Exception
	 * To register new User
	 */
	public static UserBean registerEmployee(Connection conn, String firstname, String lastname, String number,
			String email, String password, String secqQuestion, String secqAnswer) throws Exception {
		String sql = "insert into user values(?,?,?,?,?,?,?)";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1, firstname);
		pst.setString(2, lastname);
		pst.setString(3, number);
		pst.setString(4, email);
		pst.setString(5, password);
		pst.setString(6, secqQuestion);
		pst.setString(7, secqAnswer);
		int result = pst.executeUpdate();
		if (result > 0) {
			UserBean user = new UserBean();
			user.setFirstName(firstname);
			user.setLastName(lastname);
			user.setNumber(number);
			user.setEmail(email);
			user.setPassword(password);
			user.setSecqQuestion(secqQuestion);
			user.setSecqAnswer(secqAnswer);
			return user;
		}
		return null;
	}

}
