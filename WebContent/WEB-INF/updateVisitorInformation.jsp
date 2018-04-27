<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="/css\updateVisitorInformation.css"></link>
</head>
<body>
<div class="main">

		<h1>Festival Registration System</h1>
		<div id="nav">
			<a href="/index.jsp">Log Out</a>
			<a href="#">About</a>
			<a href="#">My Portal</a>
		</div>
		<h2>Update your information</h2>
		<div id="titulo">
			<p>Fields marked(*) are mandatory</p>
		</div>
		<form method="post" action="updateVisitor.do" id="formulario">
			<table>
				<tr>
					<td><label>*First Name: </label></td>
					<td><input type="text" name="firstName" id="nombre" value="${sessionScope.login.firstName}"/></td>
				</tr>
				<tr>
					<td><label>*Last Name: </label></td>
					<td><input type="text" name="lastName" id="apellido" value = "${sessionScope.login.lastName}"/></td>
				</tr>
				<tr>
					<td><label>*User Name: </label></td>
					<td><input type="text" name="userName" id="user_name" disabled
					value ="${sessionScope.login.userName}"/></td>
				</tr>
				<tr>
					<td><label>*Email: </label></td>
					<td><input type="text" name="email" id="email" value="${sessionScope.login.email}"/></td>
				</tr>
				<tr>
					<td><label>*DNI ()XX.XXX.XXX-L): </label></td>
					<td><input type="text" name="dni" id="dni" value="${sessionScope.login.dni}"/></td>
				</tr>
				<tr>
					<td><label>*Phone number: </label></td>
					<td><input type="text" name="phoneNumber" id="phone" value="${sessionScope.login.phoneNumber}"/></td>
				</tr>
				<tr>
					<td><label>Address: </label></td>
					<td><input type ="text" name="address" id="address" value="${sessionScope.login.address}"/></td>
				</tr>
				<tr>
				<td></td>
				<td>
				<input type="submit" value="update" id="submit_update"/>
				<input type="submit" value="cancel" id="submit_cancel"/>
				</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>