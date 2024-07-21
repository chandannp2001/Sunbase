<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="com.customer.DAOImpl.CustomerDAOImpl,com.customer.Model.Customer, java.util.List"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Customer Details</title>
<link rel="stylesheet" href="Customerdetails.css">
</head>
<body>



	<header>
		<h1>Customer Details</h1>
		<a href="logout"><button style="margin-left: 1300px; background-color: red">Logout</button></a>
	</header>
	<%
	int currentPage = (request.getParameter("pageNumber") != null) ? Integer.parseInt(request.getParameter("pageNumber"))
			: 1;
	String message = (String) request.getAttribute("message");
	if (message != null) {
	%>

	<h3 style="color: blue; align-content: center;" align="center">${message}</h3>
	<%
	request.setAttribute(message, null);
	}
	%>

	<div class="container">
		<a href="newCustomer.jsp"><button class="addcustomer">
				<h2>Add Customer</h2>
			</button></a> <a href="CustomerDetails?action=viewall"><button class="viewall">
				<h3>View All</h3>
			</button></a> <a href="CustomerDetails?action=Sync"><button class="Sync">
				<h3>Sync</h3>
			</button></a>



		<div class="searching">
			<form action="CustomerDetails" method="get">
				<label for="searchBy">Search By:</label> <select id="searchBy"
					name="SearchBy">
					<option value="firstname">First Name</option>
					<option value="city">City</option>
					<option value="email">Email</option>
					<option value="phone">Phone</option>
				</select> <input type="text" id="searchInput" name="searchInput"
					placeholder="Enter search term" required="required"> <input
					type="submit" name="action" value="search">
			</form>
		</div>
		<table>
			<thead>
				<tr>
					<th>ID</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Street</th>
					<th>Address</th>
					<th>City</th>
					<th>State</th>
					<th>Email</th>
					<th>Phone</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<!-- Sample data, replace with dynamic data from your application -->
				<%
				int numberofDetails = 8;//number of customer details to be display per page.
				
				List<Customer> getAllCustomer = (List<Customer>) session.getAttribute("AllCustomers");
				
				if (getAllCustomer != null) {
					
					int i = 0;
					int startIndex = currentPage == 1 ? 0 : (currentPage - 1) * numberofDetails;
					int endIndex = currentPage * numberofDetails;

					for (Customer c : getAllCustomer) {
						i++;
						if (i > startIndex && i <= endIndex) {
				%>
				<tr>
					<td><%=c.getUserid()%></td>
					<td><%=c.getFirst_name()%></td>
					<td><%=c.getLast_name()%></td>
					<td><%=c.getStreet()%></td>
					<td><%=c.getAddress()%></td>
					<td><%=c.getCity()%></td>
					<td><%=c.getState()%></td>
					<td><%=c.getEmail()%></td>
					<td><%=c.getPhone_number()%></td>
					<td class="action-buttons"><a
						href="CustomerDetails?action=edit&cid=<%=c.getUserid()%>">
							<button class="edit">Edit</button> <br>
					</a> <a href="CustomerDetails?action=delete&cid=<%=c.getUserid()%>">
							<button class="delete">Delete</button>
					</a></td>
				</tr>
				<%
				}
				}
				}
				%>
			</tbody>
		</table>
		<%
		String Error = (String) request.getAttribute("Error");
		if (Error != null) {
		%>

		<h3 style="color: red; align-content: center;" align="center">${Error}</h3>
		<%
		request.setAttribute(Error, null);
		}
		%>

		<div class="pagination">
			<%
			//int pageSize = 5;
			
			int totalCustomers = getAllCustomer==null?0:getAllCustomer.size();
			int totalPages = (int) Math.ceil((double) totalCustomers /numberofDetails );
			if (totalPages > 1) {
			%>
			<span>Page: </span>
			<%
			if (currentPage != 1) {
			%>
			<span ><a class="nextpreivous"
				href="CustomerDetails?action=Pageing&pageNumber=<%=currentPage - 1%>">
					Previous</a></span>
			<%
			}
			for (int i = 1; i <= totalPages; i++) {
			if (i == currentPage) {
			%>

			<span class="current-page"><%=i%> </span>


			<%
			} else {
			%>
			<a class="Remaining-page"
				href="CustomerDetails?action=Pageing&pageNumber=<%=i%>"><%=i%></a>
			<%
			}
			}
			if (currentPage != totalPages) {
			%>

			<span ><a class="nextpreivous"
				href="CustomerDetails?action=Pageing&pageNumber=<%=currentPage + 1%>">
					Next</a></span>
			<%
			}
			}
			%>
		</div>
	</div>

</body>
</html>
