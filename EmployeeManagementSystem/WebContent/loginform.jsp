<!DOCTYPE html>
<html>
<head>
	<title>Employee Management System</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Add icon library -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="css\loginpagecss.css">
</head>
<body>
<% %>
	<div class="main">

		<div>
		
		<div class="error">
		<p style="color:red;text-align:center;">${errorString}</p>
		</div>
		
		

			<form action="LoginServlet" method="post">
				<h2><p align="center">Sign In</p><h2>

				<div class="input-container">
    			<i class="fa fa-user icon"></i>
   				<input class="input-field" type="text" placeholder="Username" name="username" required="required">
 				</div>

 				<div class="input-container">
    			<i class="fa fa-key icon"></i>
   				<input class="input-field" type="password" placeholder="Password" name="password" required="required">
  				</div>

  				<button type="submit" class="btn">Sign In</button>

			</form>
		</div>
		<div class="modal-footer">Don't have an account? <a href="registration.jsp">Create one</a></div>
	</div>

</body>
</html>