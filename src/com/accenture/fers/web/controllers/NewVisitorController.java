package com.accenture.fers.web.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.accenture.fers.entity.*;
import com.accenture.fers.utils.*;
import com.accenture.fers.exceptions.FERSGenericException;
import com.accenture.fers.service.*;

public class NewVisitorController implements IController {
	private static final String CTE_ERM_025 = "Password diferentes o < 5";
	private static final String CTE_ERM_026 = "Fallo en algún campo";

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) {

		String url = "index.jsp";

		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastName");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String c_password = request.getParameter("c_password");
		String email = request.getParameter("email");
		String dni = request.getParameter("dni");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");

		if((password != c_password) || (password.length() < 5)) {
			throw new FERSGenericException(CTE_ERM_025);
		}
		try {
			Visitor visitor = new Visitor();
			visitor.setUserName(userName);
			visitor.setFirstName(firstName);
			visitor.setLastName(lastName);
			visitor.setPassword(password);
			visitor.setConfirmPassword(c_password);
			visitor.setEmail(email);
			visitor.setDni(dni);
			visitor.setPhoneNumber(phone);
			visitor.setAddress(address);

			VisitorService vs = new VisitorService();
			vs.createVisitor(visitor);
		} catch (NullPointerException e) {
			e.printStackTrace();
			url = "register.jsp";
		}
		return url;
	}
}
