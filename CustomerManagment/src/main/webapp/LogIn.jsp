<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link rel="stylesheet" href="LogIn.css">
<title>Login</title>
</head>
<body>
	<div class="login-container">
		<div class="signup-header">
			<h1>Admin Login</h1>
		</div>
		<form class="login-form" action="Login" method="get">
			<div class="form-group">
				<label for="username">Username</label> <input type="text"
					id="username" name="username" placeholder="Enter your username"
					required>
			</div>
			<div class="form-group">
				<label for="password">Password</label> <input type="password"
					id="password" name="password" placeholder="Enter your password"
					required>
			</div>
			<button type="submit" class="login-button">Login</button>

		</form>
		
		<%
		if (request.getAttribute("errorMessage") != null) {
		%>
		<h3 style="color: red;">${errorMessage}</h3>

		<%
		}
		%>



	</div>
</body>
</html>