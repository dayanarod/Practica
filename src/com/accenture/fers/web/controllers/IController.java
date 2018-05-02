package com.accenture.fers.web.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Diana Rodera Rojas
 * @version 02/05/2018
An  interface for defining the request process method needed for Controllers:
@param request
@param response
@return the name of the view (html/jsp) that has to generate the response
*/

public interface IController {
	/**
	 * Una interfaz para definir el proceso de petición necesaria por controlladores
	 * @param request Petición
	 * @param response Respuesta
	 * @return el nombre de la vista que se ha generado la respuesta
	 */

	public String process (HttpServletRequest request, HttpServletResponse response);

}

