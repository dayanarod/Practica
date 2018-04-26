package com.accenture.fers.web.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DisplayViewController implements IController{

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) {

		String url = request.getParameter("redir");
		return url;
	}

}
