package com.accenture.fers.web.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 
 * @author Diana Rodera Rojas
 * @version 02/05/2018
 *
 *Controlador que gestiona a que pagina de WEB-INF redireciona
 */
public class DisplayViewController implements IController{

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) {
		// Obtenemos el atributo
		String url = request.getParameter("redir");
		return "WEB-INF/"+url;
	}

}
