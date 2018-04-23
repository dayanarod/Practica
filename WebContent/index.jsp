<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Index</title>
<link rel="stylesheet" href="css\index.css"></link>
</head>
<body>
	<div class="main">
		<h1>Festival Registration System</h1>
		<h2>Portal Login Page</h2>
		<form id="formulario">
			<table>
				<tr>
					<td><label>Visitor name: </label></td>
					<td><input type="text" name="visitor_name" id="visitor_name" /></td>
				</tr>
				<tr>
					<td><label>Password: </label></td>
					<td><input type="password" name="visitor_pass"
						id="visitor_pass" /></td>
				</tr>
				<tr><td></td>
				<td><input type="submit" value="login" id="submit_login"/></td>
				</tr>
				<tr>
				<td><label>New Visitor: </label></td>
				<td></td>
				</tr>
				<tr>
				<td><a href="register.jsp">register here</a></td>
				<td></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>