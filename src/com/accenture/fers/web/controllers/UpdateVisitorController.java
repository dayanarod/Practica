package com.accenture.fers.web.controllers;

import javax.servlet.http.*;

import com.accenture.fers.entity.*;
import com.accenture.fers.utils.*;
import com.accenture.fers.exceptions.FERSGenericException;
import com.accenture.fers.service.*;

public class UpdateVisitorController implements IController{
	public static final String CTE_ERM_024 = "Invalid username/password";
	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) {
		String url = "updateVisitorInfo.jsp";

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


		try{
			visitor.setFirstName(firstName);
			visitor.setLastName(lastName);
			visitor.setUserName(userName);
			visitor.setPassword(password);
			visitor.setConfirmPassword(c_password);
			visitor.setEmail(email);
			visitor.setDni(dni);
			visitor.setPhoneNumber(phone);
			visitor.setAddress(address);
			VisitorService vs = new VisitorService();

		}catch(NullPointerException e){
			throw new FERSGenericException(CTE_ERM_024);
		}


		return url;
	}

}
