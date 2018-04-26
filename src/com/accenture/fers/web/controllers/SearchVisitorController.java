package com.accenture.fers.web.controllers;

import javax.servlet.http.*;
import com.accenture.fers.entity.*;
import com.accenture.fers.exceptions.FERSGenericException;
import com.accenture.fers.service.*;

public class SearchVisitorController implements IController {
	public static final String CTE_ERM_024 = "Invalid username/password";
	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) {

		String url = "WEB-INF/portal.jsp";

		String visitor_name = request.getParameter("visitor_name");
		String visitor_pass = request.getParameter("visitor_pass");
		Visitor visitor = new Visitor();

		try {
			visitor.setUserName(visitor_name);
			visitor.setPassword(visitor_pass);
		} catch (NullPointerException e) {
			throw new FERSGenericException(CTE_ERM_024);
		}

		VisitorService vs = new VisitorService();
		Visitor visitorFound = new Visitor();
		visitorFound = vs.searchUser(visitor);

		if (visitorFound != null) {
			HttpSession sesion = request.getSession(true);
			sesion.setAttribute("login", visitorFound);
		} else {
			url = "index.jsp";
		}

		return url;
	}

}
