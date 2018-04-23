<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="/css\updateVisitorPassword.css"></link>
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

		<form id="formulario">
			<table>
				<tr>
					<td><label>Current password: </label></td>
					<td><input type="text" name="current_pass" id="current_pass" required="required"/></td>
				</tr>
				<tr>
					<td><label>New password: </label></td>
					<td><input type="text" name="new_pass" id="new_pass" required/></td>
				</tr>
				<tr>
					<td><label>Repeat new password: </label></td>
					<td><input type="text" name="r_new_pass" id="r_new_pass" required/></td>
				</tr>
				<tr>
				<td></td>
				<td><input type="submit" value="Update" id="submit_update"/></td>
				</tr>
			</table>

		</form>
	</div>

</body>
</html>