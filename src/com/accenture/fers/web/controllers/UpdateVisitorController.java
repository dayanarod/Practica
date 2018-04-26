package com.accenture.fers.web.controllers;

import javax.servlet.http.*;
import com.accenture.fers.entity.*;
import com.accenture.fers.exceptions.FERSGenericException;
import com.accenture.fers.service.*;

public class UpdateVisitorController implements IController {
	public static final String CTE_ERM_027 = "Error in update.. Please Check fields and retry";

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) {
		String url = "/WEB-INF/updateVisitorInfo.jsp";

		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String dni = request.getParameter("dni");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");

		HttpSession sesion = request.getSession();
//		Visitor visitorUpdate = new Visitor();
//		sesion.setAttribute("login", visitorUpdate);
		Visitor visitorUpdate = (Visitor)sesion.getAttribute("login");
		VisitorService vs = new VisitorService();

		try {
			visitorUpdate.setFirstName(firstName);
			visitorUpdate.setLastName(lastName);
			visitorUpdate.setEmail(email);
			visitorUpdate.setDni(dni);
			visitorUpdate.setPhoneNumber(phone);
			visitorUpdate.setAddress(address);

			int update = vs.updateVisitorDetails(visitorUpdate);
			if(update == 1){
				sesion.setAttribute("login", visitorUpdate);
				url = "/WEB-INF/portal.jsp";
			} else {
				url = "/WEB-INF/updateVisitorInformation.jsp";
			}

		} catch (NullPointerException e) {
			throw new FERSGenericException(CTE_ERM_027);
		}
		return url;
	}
}
