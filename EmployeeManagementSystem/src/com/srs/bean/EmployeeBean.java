package com.srs.bean;

public class EmployeeBean {




	private String emp_id;
	public EmployeeBean() {
		super();
	}

	private String name;
	private String mobile;
	private String department;
	private String status;
	private String email;
	

	public String getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(String emp_id) {
		this.emp_id = emp_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public EmployeeBean(String emp_id, String name, String mobile, String department, String status, String email) {
		super();
		this.emp_id = emp_id;
		this.name = name;
		this.mobile = mobile;
		this.department = department;
		this.status = status;
		this.email = email;
	}

	@Override
	public String toString() {
		return "EmployeeBean [emp_id=" + emp_id + ", name=" + name + ", mobile=" + mobile + ", department=" + department
				+ ", status=" + status + ", email=" + email + "]";
	}

}
