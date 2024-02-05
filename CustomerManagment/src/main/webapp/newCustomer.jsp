<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
        <h1>New Customer</h1>
        <a href="Customerdetails.jsp"><button  style=" margin-left: 100px; margin-top: -20px">Home</button></a>
    </header>

    <div class="container">
    	
        <form action="CustomerDetails" method="get">

            <div class="personal-details">
                <h2>Personal Details</h2>
                <label for="CustomerId">Customer Id:</label>
                <input type="text" id="CustomerId" name="CustomerId" placeholder="CustomerId" required>
                
                
                <label for="firstname">First Name:</label>
                <input type="text" id="firstname" name="firstname" placeholder="First Name" required>

                <label for="lastname">Last Name:</label>
                <input type="text" id="lastname" name="lastname" placeholder="Last Name" required>

                <label for="email">Email:</label>
                <input type="email" id="email" name="email" placeholder="Email" required>

                <label for="phonenumber">Phone Number:</label>
                <input type="tel" id="phonenumber" name="phonenumber" placeholder="Phone Number" required>
            </div>

            <div class="address">
                <h2>Address</h2>
                <label for="street">Street:</label>
                <input type="text" id="street" name="street" placeholder="Street" required>
                
                <label for="Address">Address:</label>
                <input type="text" id="Address" name="Address" placeholder="Address" required>

                <label for="city">City:</label>
                <input type="text" id="city" name="city" placeholder="City" required>

                <label for="state">State:</label>
                <input type="text" id="state" name="state" placeholder="State" required>
                
            </div>

            <button type="submit" name="action" value="Add" >Create Customer</button>

        </form>
    </div>

</body>
</html>
    