package com.accenture.fers.web.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
An  interface for defining the request process method needed for Controllers:
@param request
@param response
@return the name of the view (html/jsp) that has to generate the response
*/

public interface IController {

	public String process (HttpServletRequest request, HttpServletResponse response);

}

