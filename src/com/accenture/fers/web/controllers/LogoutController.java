package com.accenture.fers.web.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 
 * @author Diana Rodera Rojas
 * @version 02/05/2018
 * 
 * Controlador que gestiona el logout
 *
 */

public class LogoutController implements IController{
	/**
	 * Manda a index.jsp y borra la sesión
	 * @param request Petición
	 * @param response Respuesta
	 * @return url vista a mostrar
	 */
	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) {
		String url = "index.jsp";
		
		//Destruimos la sesión
		HttpSession sesion = request.getSession();
		sesion.invalidate();
		//Volvemos a la página de inicio
		return url;
	}

}
