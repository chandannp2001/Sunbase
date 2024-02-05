<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.customer.Model.Customer"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>New Customer</title>
<link rel="stylesheet" href="newCustomer.css">


</head>
<body>

	<header>
		<h1>Edit Customer</h1>
		<a href="Customerdetails.jsp">
			<button style="margin-left: 100px; margin-top: -20px">Home</button>
		</a>
	</header>

	<%
	Customer c = (Customer) request.getAttribute("EditCoustomer");
	%>

	<div class="container">
		<form action="CustomerDetails" method="get">

			<div class="personal-details">
				<h2>Personal Details</h2>
				<label for="firstname">First Name:</label> <input type="text"
					id="firstname" name="firstname" value="<%=c.getFirst_name()%>"
					required> <label for="lastname">Last Name:</label> <input
					type="text" id="lastname" name="lastname"
					value="<%=c.getLast_name()%>" required> <label for="email">Email:</label>
				<input type="email" id="email" name="email"
					value="<%=c.getEmail()%>" required> <label
					for="phonenumber">Phone Number:</label> <input type="tel"
					id="phonenumber" name="phonenumber"
					value="<%=c.getPhone_number()%>" required>
			</div>

			<div class="address">
				<h2>Address</h2>
				<label for="street">Street:</label> <input type="text" id="street"
					name="street" value="<%=c.getStreet()%>" required> <label
					for="Address">Address:</label> <input type="text" id="Address"
					name="Address" value="<%=c.getAddress()%>" required> <label
					for="city">City:</label> <input type="text" id="city" name="city"
					value="<%=c.getCity()%>" required> <label for="state">State:</label>
				<input type="text" id="state" name="state" value="<%=c.getState()%>"
					required> <input type="hidden" name="cid"
					value="<%=c.getUserid()%>">
			</div>

			<button type="submit" name="action" value="update">Update
				Customer</button>

		</form>
	</div>

</body>
</html>
