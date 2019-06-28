package com.srs.bean;

public class DepartmentBean {
	private int id;
	private String department;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "DepartmentBean [id=" + id + ", department=" + department + "]";
	}
	

}
