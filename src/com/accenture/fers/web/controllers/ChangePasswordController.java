package com.accenture.fers.web.controllers;

import javax.servlet.http.*;
import com.accenture.fers.entity.*;
import com.accenture.fers.service.*;

public class ChangePasswordController implements IController{

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) {
		String url = "";

		String current_pass = request.getParameter("current_pass");
		String new_pass = request.getParameter("new_pass");
		String r_new_pass = request.getParameter("r_new_pass");
		HttpSession sesion = request.getSession();
		Visitor visitorUpdate = (Visitor) sesion.getAttribute("login");
		VisitorService vs = new VisitorService();

		try{
			if((new_pass.equals(r_new_pass)) && (!new_pass.equals(current_pass)) && (current_pass.equals(visitorUpdate.getPassword()))){
				visitorUpdate.setPassword(new_pass);
			}

			int update = vs.updateVisitorDetails(visitorUpdate);
			if(update == 1){
				sesion.setAttribute("login", visitorUpdate);
				url = "/WEB-INF/portal.jsp";
			} else {
				sesion.setAttribute("fail", "Icorrect Password");
				url = "/WEB-INF/updateVisitorPassword.jsp";
			}
		}catch(NullPointerException e) {
			request.setAttribute("fail", e.getMessage());
			url = "/WEB-INF/updateVisitorPassword.jsp";
		}
		return url;
	}
}
