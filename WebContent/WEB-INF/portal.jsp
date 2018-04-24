<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="/css\portal.css"></link>
</head>
<body>
<div class="main">

		<h1>Festival Registration System</h1>
		<div id="nav">
			<a href="/index.jsp">Log Out</a>
			<a href="#">About</a>
			<a href="#">Event Catalogue</a>
		</div>
		<h2>Festival Portal Page: Welcome to your portal page: </h2>

		<div id="personal_information">
		<p>Your personal information is below. To change your information <a href="#">click here</a></p>
		<p>UserName: <span id="username"></span></p>
		<p>Visitor ID: <span id="visitorid"></span></p>
		<p>Email: <span id="email"></span></p>
		<p>Phone Number: <span id="phonenumber"></span></p>
		<p>Address: <span id="address"></span></p>
		</div>
<hr></hr>
<div class="release">
			To release a ticket you have for an upcoming attraction, please find
			the attraction below, and click the release link.
			<form method="post">
				<table>
					<tr>
						<th>Event id</th>
						<th>Event name</th>
						<th>Description</th>
						<th>Places</th>
						<th>Duration</th>
						<th>Event type</th>
						<th>Action</th>
					</tr>

				</table>
			</form>
		</div>
		<hr></hr>
		<div class="release">
			To get a ticket for an up-coming attraction, please find the
			attraction below, and click the Register link.
			<form method="post" >
				<table>
					<tr>
						<th>Event id</th>
						<th>Event name</th>
						<th>Description</th>
						<th>Places</th>
						<th>Duration</th>
						<th>Event type</th>
						<th>Available Tickets</th>
						<th>Action</th>
					</tr>

				</table>
			</form>
		</div>

</body>
</html>