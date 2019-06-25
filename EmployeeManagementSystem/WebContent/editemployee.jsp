<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Management System</title>
<style type="text/css">
.table{
position: absolute;
top: 15%;
left:40%;
}
table{
background-color:#00e6e6;
font-family: calibri;
}
</style>
</head>
<body>
<%@include file="header.jsp"%>
	<%@include file="dropdown.html"%>

	<div class="table">
	<form action="#" method="post">
	<h3><p style=" text-align:center;"> Edit Employee</p></h3>
	<table align="center" cellpadding="15">
	<tr>
	<td><label>Name</label> </td>
	<td><input type="text" placeholder="Name*" name="name" requried="requried"></td>
	</tr>
	<tr>
	<td><label>Mobile</label></td>
	<td><input type="text" placeholder="Mobile*" name="mobile" requried="requried"></td>
	</tr>
	<tr>
	<td><label>Department</label></td>
	<td><input type="text" placeholder="Department*" name="department" requried="requried"></td>
	</tr>
	<tr>
	<td><label>Status</label></td>
	<td><input type="text" placeholder="Status*" name="status" requried="requried"></td>
	</tr>
	<tr>
	<td><label>Email</label></td>
	<td><input type="email" placeholder="Email*" name="email" requried="requried"></td>
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