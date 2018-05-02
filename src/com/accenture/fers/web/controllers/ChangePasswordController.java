package com.accenture.fers.web.controllers;

import javax.servlet.http.*;
import com.accenture.fers.entity.*;
import com.accenture.fers.service.*;

/**
 * Controlador que gestiona la actualización de la contraseña de usuario
 * @author Diana Rodera Rojas
 * @version 02/05/2018
 *
 */
public class ChangePasswordController implements IController{

	/**
	 * Te mantiene en updateVisitorPassword.jsp si ocurre algún error
	 * al cambiar la password del usuario
	 * Si todo va bien te redirecciona a portal.jsp
	 * 
	 *  @param request Petición
	 *  @param pesponse Respuesta
	 *  @return url Vista que se muestra
	 */
	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) {
		String url = "";

		// Obtenemos los datos
		String current_pass = request.getParameter("current_pass");
		String new_pass = request.getParameter("new_pass");
		String r_new_pass = request.getParameter("r_new_pass");
		
		// Obtenemos la contraseña con la que se ha logeado el usuario
		HttpSession sesion = request.getSession();
		Visitor visitorUpdate = (Visitor) sesion.getAttribute("login");
		VisitorService vs = new VisitorService();

		try{
			// Comprobamos que la contraseña actual sea correcta, 
			// que las contraseñas coinciden
			// Y que la contraseña nueva es distinta a la actual
			if((new_pass.equals(r_new_pass)) && (!new_pass.equals(current_pass)) && (current_pass.equals(visitorUpdate.getPassword()))){
				visitorUpdate.setPassword(new_pass);
			}
			
			// Se crea el login correctamente
			// Modificamos la contaseña
			int update = vs.updateVisitorDetails(visitorUpdate);
			
			// Cambiamos la página de respuesta
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
