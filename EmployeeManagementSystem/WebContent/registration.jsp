<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Management System</title>
<style type="text/css">
body {
	font-family: Arial, Helvetica, sans-serif;
}

* {
	box-sizing: border-box;
}

.main {
	position: absolute;
	top: 20%;
	left: 35%;
}

.float {
	float: left;
}

table {
	background-color: #00e6e6;
	font-family: calibri;
}
</style>
</head>
<body>
	<%@include file="header.jsp"%>
	<div class="main">
		<form action="UserRegistrationServlet" method="post">
			<h2>
				<p style="text-align: center;">Registration</p>
			</h2>
			<table>
				<tr>
					<td>
						<div class="float">
							<input type="text" name="firstname" placeholder="First Name*"
								required="required">
						</div>
					</td>
					<td>
						<div>
							<input type="text" name="lastname" placeholder="Last Name*"
								required="required">
						</div>
					</td>
				</tr>
				<tr>
					<td>
						<div class="float">
							<input type="text" name="number" placeholder="Phone Number*" required="required">
						</div>
					</td>
					<td>
						<div>
							<input type="email" name="email" placeholder="Your Email*"
								required="required">
						</div>
					</td>
				</tr>
				<tr>
					<td>
						<div class="float">
							<input type="password" name="password" placeholder="Password*"
								required="required">
						</div>
					</td>
					<td>
						<div>
							<input type="password" name="password"
								placeholder="Confirm Password*" required="required">
						</div>
					</td>
				</tr>
				<tr>
					<td>
						<div class="float">
							<select name="question" required="required" >
								<option>Please Select Your Security Question*</option>
								<option value="What is your Nickname?">What is your
									Nickname?</option>
								<option value="what is your pet name?">what is your pet
									name?</option>
							</select>
						</div>
					</td>
					<td>

						<div class="float">
							<input type="text" name="answer" placeholder="Enter Your Answer*"
								required="required">
						</div>
					</td>
				</tr>
				<tr>
					<td>
						<div>
							<input type="submit" Value="Register">
						</div>
					</td>
				</tr>
			</table>

		</form>
	</div>
	<%@include file="footer.jsp"%>
</body>
</html>