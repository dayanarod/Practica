package com.accenture.fers.web.controllers;

import javax.servlet.http.*;
import com.accenture.fers.entity.*;
import com.accenture.fers.exceptions.FERSGenericException;
import com.accenture.fers.service.*;
/**
 * 
 * @author Diana Rodera Rojas
 * @version 02/05/2018
 *
 */
public class SearchVisitorController implements IController {
	public static final String CTE_ERM_024 = "Invalid username/password";
	@Override
	/**
	 * Te mantiene en index.jsp si hay un error en el login
	 * Te manda a portal.jsp y crea una sesión si todo es correcto
	 * 
	 * @param request Petición
	 * @param response Respuesta
	 * @return url la vista a mostrar
	 */
	public String process(HttpServletRequest request,
			HttpServletResponse response) {

		String url = "WEB-INF/portal.jsp";
		//Obtenemos los datos
		String visitor_name = request.getParameter("visitor_name");
		String visitor_pass = request.getParameter("visitor_pass");
		
		//Creamos el visitor
		Visitor visitor = new Visitor();

		try {
			visitor.setUserName(visitor_name);
			visitor.setPassword(visitor_pass);
		} catch (NullPointerException e) {
			throw new FERSGenericException(CTE_ERM_024);
		}
		// Se crea el visitor correctamente
		// Buscamos visitor por nombre y pass
		VisitorService vs = new VisitorService();
		Visitor visitorFound = new Visitor();
		visitorFound = vs.searchUser(visitor);

		// Cambiamos página de respuesta
		if (visitorFound != null) {
			HttpSession sesion = request.getSession(true);
			sesion.setAttribute("login", visitorFound);
		} else {
			url = "index.jsp";
		}

		return url;
	}

}
