<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>

<head>

<meta charset="ISO-8859-1">
<title>Employee Management System</title>
<style type="text/css">
.table {
	position: absolute;
	top: 15%;
	left: 40%;
}

table {
	background-color: #00e6e6;
	font-family: calibri;
}

.home a:link, a:visited {
	background-color: white;
	color: black;
	border: 2px solid lightblue;
	padding: 10px 20px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	width: 30%;
	margin: 10px;
	margin-bottom: 0px;
}

.home a:hover, a:active {
	background-color: lightblue;
	color: white;
}

.home {
	position: absolute;
	top: 10%;
	left: 10%;
}
</style>
</head>
<body>
	<%@include file="header.jsp"%>
	<%@include file="dropdown.html"%>

	<div class="table">
		<div>
			<p>${errorString}</p>
		</div>
		<form action="addemployee" method="post">
			<h3>
				<p style="text-align: center;">Employee Registration</p>
			</h3>
			<table align="center" cellpadding="15">
				<tr>
					<td><label>Name</label></td>
					<td><input type="text" placeholder="Name*" name="name"
						required="required"></td>
				</tr>
				<tr>
					<td><label>Mobile</label></td>
					<td><input type="text" placeholder="Mobile*" name="mobile"
						required="required"></td>
				</tr>

				<tr>

					<td><label>Department</label></td>

					<td><select name="department">
							<c:forEach var="row" items="${deptList}">
								<option value="<c:out value="${row.id}" />">
									<c:out value="${row.department}"></c:out>
								</option>
							</c:forEach>
					</select></td>


				</tr>
				<tr>
					<td><label>Status</label></td>
					<td><input type="text" placeholder="Status*" name="status"
						required="required"></td>
				</tr>
				<tr>
					<td><label>Email</label></td>
					<td><input type="email" placeholder="Email*" name="email"
						required="required"></td>
				</tr>
				<tr>
					<td><input type="submit" value="Add Employee"></td>
					<td><input type="reset" value="Clear"></td>
				</tr>
			</table>
		</form>
	</div>
	<div class="home">
		<a href="home">Home</a>
	</div>

	<%@include file="footer.jsp"%>
</body>
</html>