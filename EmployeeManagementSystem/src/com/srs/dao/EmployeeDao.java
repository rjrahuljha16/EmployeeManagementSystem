package com.srs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.srs.bean.EmployeeBean;

public class EmployeeDao {

	public static EmployeeBean addEmployee(Connection conn, String name, String mobile, String department,
			String status, String email) throws SQLException {
		String sql = "insert into employee_table(name,mobile,dept,status,email) values(?,?,?,?,?)";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1, name);
		pst.setString(2, mobile);
		pst.setString(3, department);
		pst.setString(4, status);
		pst.setString(5, email);
		int result = pst.executeUpdate();
		if (result > 0) {
			EmployeeBean employee = new EmployeeBean();
			employee.setName(name);
			employee.setMobile(mobile);
			employee.setDepartment(department);
			employee.setStatus(status);
			employee.setEmail(email);
			return employee;
		}
		return null;
	}

	public static List<EmployeeBean> showEmployee(Connection conn) throws SQLException {

		String sql = "select e.emp_id, e.name, d.dept, e.mobile, e.status, e.email from employee_table e join department d where e.dept=d.id";
		PreparedStatement pst = conn.prepareStatement(sql);
		ResultSet resultset = pst.executeQuery();
		List<EmployeeBean> empList = new ArrayList();

		while (resultset.next()) {

			String emp_id = resultset.getString(1);
			String name = resultset.getString(2);
			String department = resultset.getString(3);
			String mobile = resultset.getString(4);
			String status = resultset.getString(5);
			String email = resultset.getString(6);

			EmployeeBean employee = new EmployeeBean();
			employee.setEmp_id(emp_id);
			employee.setName(name);
			employee.setMobile(mobile);
			employee.setDepartment(department);
			employee.setStatus(status);
			employee.setEmail(email);
			empList.add(employee);

		}
		return empList;
	}

	public static EmployeeBean findEmployee(Connection conn, String emp_id) throws SQLException {
		String sql = "select e.name, d.dept, e.mobile, e.status, e.email from employee_table e join department d where e.dept=d.id and e.emp_id=?";

		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1, emp_id);

		ResultSet resultset = pst.executeQuery();
		while (resultset.next()) {
			String name = resultset.getString("name");
			String department = resultset.getString("dept");
			String mobile = resultset.getString("mobile");
			String status = resultset.getString("status");
			String email = resultset.getString("email");

			EmployeeBean employee = new EmployeeBean(emp_id, name, department, mobile, status, email);
			return employee;
		}
		return null;

	}

	public static void updateEmployee(Connection conn, EmployeeBean employee) throws SQLException {
		String sql = "update employee_table set name=?,mobile=?,dept=?,status=?,email=? where emp_id=?";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1, employee.getName());
		pst.setString(2, employee.getMobile());
		pst.setString(3, employee.getDepartment());
		pst.setString(4, employee.getStatus());
		pst.setString(5, employee.getEmail());
		pst.setString(6, employee.getEmp_id());
		pst.executeUpdate();

	}
	
	public static void deleteEmployee(Connection conn, String emp_id) throws SQLException
	{
		String sql="delete from employee_table where emp_id=?";
		
		PreparedStatement pst=conn.prepareStatement(sql);
		
		pst.setString(1, emp_id);
		
		pst.executeUpdate();
	}
}
