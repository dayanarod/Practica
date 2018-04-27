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
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<div class="main">

		<h1>Festival Registration System</h1>
		<div id="nav">
			<a href="logoutController.do">Log Out</a> <a href="#">About</a> <a
				href="#">Event Catalogue</a>
		</div>
		<h2>Festival Portal Page: Welcome <span id="user"></span>to your portal page:</h2>

		<div id="personal_information">
			<p>
				Your personal information is below. To change your information
				<a href="displayView.do?redir=updateVisitorInformation.jsp">Update Visitor</a>
				<a href="displayView.do?redir=updateVisitorPassword.jsp">Update password</a>
			</p>
			<p>
				UserName: <span id="username">${sessionScope.login.userName}</span>
			</p>
			<p>
				Visitor ID: <span id="visitorid">${sessionScope.login.visitorId}</span>
			</p>
			<p>
				Email: <span id="email">${sessionScope.login.email}</span>
			</p>
			<p>
				Phone Number: <span id="phonenumber">${sessionScope.login.phoneNumber }</span>
			</p>
			<p>
				Address: <span id="address">${sessionScope.login.address}</span>
			</p>
			<p>
				Pass: <span id="password">${sessionScope.login.password}</span>
			</p>
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
					<c:forEach var="visitorEvent" items="${sessionScope.login.registeredEvents}">
						<tr>
							<td>${visitorEvent.eventId}</td>
							<td>${visitorEvent.name}</td>
							<td>${visitorEvent.description}</td>
							<td>${visitorEvent.place}</td>
							<td>${visitorEvent.duration}</td>
							<td>${visitorEvent.eventType}</td>
							<td>${visitorEvent.seatsAvailable}</td>
							<td><a href="eventUnreg.do?eventId=${visitorEvents.visitorId}">Unregister
									Here</a></td>
						</tr>
					</c:forEach>
				</table>
			</form>
		</div>
		<hr></hr>
		<div class="release">
			To get a ticket for an up-coming attraction, please find the
			attraction below, and click the Register link.
			<form method="post">
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
					<c:forEach var="event" items="${applicationScope.eventList}">
						<tr>
							<td>${event.eventId}</td>
							<td>${event.name}</td>
							<td>${event.description}</td>
							<td>${event.place}</td>
							<td>${event.duration}</td>
							<td>${event.eventType}</td>
							<td>${event.seatsAvailable}</td>
							<td><a href="eventReg.do?eventId=${event.eventId}">Register
									Here</a></td>
						</tr>
					</c:forEach>
				</table>
			</form>
		</div>
	</div>
</body>
</html>