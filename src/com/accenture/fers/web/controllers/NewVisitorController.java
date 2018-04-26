package com.accenture.fers.web.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.accenture.fers.entity.*;
import com.accenture.fers.service.*;

public class NewVisitorController implements IController {
	private static final String CTE_ERM_025 = "Password diferentes o < 5";
	private static final String CTE_ERM_026 = "Fallo en algún campo";

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) {

		String url = "";

		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastName");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String c_password = request.getParameter("c_password");
		String email = request.getParameter("email");
		String dni = request.getParameter("dni");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		Visitor visitor = new Visitor();
		boolean vsOK = false;

		try {
			if ((password != c_password) || (password.length() < 5)) {
				request.setAttribute("fail", CTE_ERM_025);
				url = "/register.jsp";
			} else {
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
				vsOK = vs.createVisitor(visitor);
			}

			if (vsOK) {
				url = "/index.jsp";
			} else {
				url ="/register.jsp";
			}
		} catch (NullPointerException e) {
			request.setAttribute("fail", CTE_ERM_026);
			url = "/register.jsp";
		}
		return url;
	}
}
