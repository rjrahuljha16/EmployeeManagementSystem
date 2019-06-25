<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Management System</title>
<style type="text/css">
.tabledata {
	position: absolute;
	top: 10%;
	left: 28%;
}
.menulink{
position:absolute;
top:20%;
}
a:link, a:visited {
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

a:hover, a:active {
	background-color: lightblue;
	color: white;
}
</style>
</head>
<body>
	<%@include file="header.jsp"%>
	<%@include file="dropdown.html"%>

	<div class="menulink">
	
		<a href="addemployee.jsp">Register New Employee</a><br> 
		<a href="TableServlet">List of All Employees</a>
	</div>

	<div class="tabledata">
		<table border="1">

			<caption>
				<b>List of Employee</b>
			</caption>
			<thead>
				<tr>
					<th>Emp ID</th>
					<th>Name</th>
					<th>Date of joining</th>
					<th>Date of birth</th>
					<th>Department</th>
					<th>Designation</th>
					<th>Action</th>
				</tr>
			</thead>
			<c:forEach var="row" items="${empList}">
				<tbody>
					<tr>
						<td><c:out value="${row.emp_id}" /></td>
						<td><c:out value="${row.emp_name}" /></td>
						<td><c:out value="${row.doj}" /></td>
						<td><c:out value="${row.dob}" /></td>
						<td><c:out value="${row.emp_dept}" /></td>
						<td><c:out value="${row.emp_desg}" /></td>
						<td><select onChange="window.location.href=this.value">
								<option>Select Action</option>
								<option value="editemployee.jsp">Edit</option>
								<option value="deleteEmployee.jsp">Delete</option>
						</select>
					</tr>
				</tbody>
			</c:forEach>
		</table>
	</div>
	</div>
	<%@include file="footer.jsp"%>
</body>
</html>