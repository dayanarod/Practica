package com.accenture.fers.web.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutController implements IController{

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) {
		String url = "index.jsp";
		HttpSession sesion = request.getSession();
		sesion.invalidate();

		return url;
	}

}
