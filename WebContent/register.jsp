<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to Festival Event Registration System</title>
<link rel="stylesheet" href="css\register.css"></link>
</head>
<body>
	<div class="main">

		<h1>Festival Registration System</h1>
		<div id="nav">
			<a href="index.jsp">Log In</a>
		</div>
		<h2>Portal Login Page</h2>
		<div id="titulo">
			<p>Fields marked(*) are mandatory</p>
		</div>
		<form id="formulario" method="post" action="NewVisitorController.java">
			<table>
				<tr>
					<td><label>*First Name: </label></td>
					<td><input type="text" name="firstName" id="firstName" required="required"/></td>
				</tr>
				<tr>
					<td><label>*Last Name: </label></td>
					<td><input type="text" name="lastName" id="lastName" required/></td>
				</tr>
				<tr>
					<td><label>*User Name: </label></td>
					<td><input type="text" name="userName" id="userName" required/></td>
				</tr>
				<tr>
					<td><label>*Password: </label></td>
					<td><input type="password" name="password" id="password" required/></td>
				</tr>
				<tr>
					<td><label>*Confirm Password: </label></td>
					<td><input type="password" name="c_password" id="c_password" required/></td>
				</tr>
				<tr>
					<td><label>*Email: </label></td>
					<td><input type="text" name="email" id="email" required/></td>
				</tr>
				<tr>
					<td><label>*DNI ()XX.XXX.XXX-L): </label></td>
					<td><input type="text" name="dni" id="dni" required/></td>
				</tr>
				<tr>
					<td><label>*Phone number: </label></td>
					<td><input type="text" name="phone" id="phone" required/></td>
				</tr>
				<tr>
					<td><label>Address: </label></td>
					<td><input type ="text" name="address" id="address"/></td>
				</tr>
				<tr>
				<td></td>
				<td><input type="submit" value="Register" id="submit_register"/></td>
				</tr>
			</table>

		</form>
	</div>
</body>
</html>
<!--<script type="text/javascript"> -->
<!--  $(document).ready(function() { -->
<!--      $("#formID").validate({ -->
<!--          rules : { -->
<!--              login : { -->
<!--                  required : true -->
<!--              } -->
<!--          }, -->
<!--      }); -->
<!--  }); -->
<!--</script> -->