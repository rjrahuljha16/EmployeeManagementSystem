<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
</style>
</head>
<body>
	<%@include file="header.jsp"%>
	<%@include file="dropdown.html"%>

	<div class="table">
		<form action="EditEmployeeServlet" method="post">
			<h3>
				<p style="text-align: center;">Edit Employee</p>
			</h3>
			<table align="center" cellpadding="15">

				<tr>
					<th><label>Employee id</label></th>
					<td><input type="text" name="emp_id"
						value="${employee.emp_id}" readonly></td>
				</tr>

				<tr>
					<td><label>Name</label></td>
					<td><input type="text" value="${employee.name}" name="name"
						requried="requried"></td>
				</tr>
				<tr>
					<td><label>Department</label></td>
					<td><select name="department">
							
							<option value="1">Devlopment</option>
							<option value="2">Admin</option>
							<option value="3">Testing</option>


					</select></td>

				</tr>
				<tr>
					<td><label>Mobile</label></td>
					<td><input type="text" value="${employee.department}"
						name="mobile" requried="requried"></td>
				</tr>
				<tr>
					<td><label>Status</label></td>
					<td><input type="text" value="${employee.status}"
						name="status" requried="requried"></td>
				</tr>
				<tr>
					<td><label>Email</label></td>
					<td><input type="email" value="${employee.email}" name="email"
						requried="requried"></td>
				</tr>
				<tr>
					<td><input type="submit" value="Update Employee"></td>

				</tr>
			</table>
		</form>
	</div>

	<%@include file="footer.jsp"%>

</body>
</html>