package com.srs.bean;

public class UserBean {
	private String firstName;
	private String lastName;
	private String number;
	private String email;
	private String password;
	private String secqQuestion;
	private String secqAnswer;

	public UserBean() {

	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSecqQuestion() {
		return secqQuestion;
	}

	public void setSecqQuestion(String secqQuestion) {
		this.secqQuestion = secqQuestion;
	}

	public String getSecqAnswer() {
		return secqAnswer;
	}

	public void setSecqAnswer(String secqAnswer) {
		this.secqAnswer = secqAnswer;
	}

	@Override
	public String toString() {
		return "UserBean [firstName=" + firstName + ", lastName=" + lastName + ", number=" + number + ", email=" + email
				+ ", password=" + password + ", secqQuestion=" + secqQuestion + ", secqAnswer=" + secqAnswer + "]";
	}

	
	
}
