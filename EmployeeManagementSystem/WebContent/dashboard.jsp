<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Management System</title>
<style type="text/css">
.tabledata{
position:absolute;
left:25%;
top:15%;
width:650px;
height:435px;
display:block;
overflow:auto;
}



.menulink {
	position: absolute;
	top: 20%;
}

.menulink a:link, a:visited {
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

.menulink a:hover, a:active {
	background-color: lightblue;
	color: white;
}

</style>
</head>
<body>
	<%@include file="header.jsp"%>
	<%@include file="dropdown.html"%>

	<div class="menulink">

		<a href="AddEmployee">Register New Employee</a>
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
					<th>Mobile</th>
					<th>Department</th>
					<th>Staus</th>
					<th>Email</th>
					<th>Action</th>
				</tr>
			</thead>
			<c:forEach var="row" items="${empList}">
				<tbody>
					<tr>
						<td><c:out value="${row.emp_id}" /></td>
						<td><c:out value="${row.name}" /></td>
						<td><c:out value="${row.mobile}" /></td>
						<td><c:out value="${row.department}" /></td>
						<td><c:out value="${row.status}" /></td>
						<td><c:out value="${row.email}" /></td>
						<td><select onChange="window.location.href=this.value">
								<option>Select Action</option>
								<option value="EditEmployeeServlet?emp_id=${row.emp_id}">Edit</option>
								<option value="DeleteEmployeeServlet?emp_id=${row.emp_id}">Delete</option>
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