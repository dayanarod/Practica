package com.accenture.fers.web.controllers;

import javax.servlet.http.*;
import com.accenture.fers.entity.*;
import com.accenture.fers.exceptions.FERSGenericException;
import com.accenture.fers.service.*;

/**
 * Controlador que gestiona la actualizacion de detalles de usuario
 * 
 * @author Diana Rodera Rojas
 * @version 02/05/2018
 *
 */
public class UpdateVisitorController implements IController {
	public static final String CTE_ERM_027 = "Error in update.. Please Check fields and retry";

	/**
	 * Mantiene en updateVisitorInformation.jsp si hay error Manda a portal.jsp y
	 * actualiza sesion si todo es correcto
	 *
	 * @param request
	 *            Peticion
	 * @param response
	 *            Respuesta
	 * @return url Vista a mostrar
	 *
	 */

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		String url = "/WEB-INF/updateVisitorInformation.jsp";
		System.out.println("entro en updateVisitor Information");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String dni = request.getParameter("dni");
		String phoneNumber = request.getParameter("phoneNumber");
		String address = request.getParameter("address");

		HttpSession sesion = request.getSession();
		// Visitor visitorUpdate = new Visitor();
		// sesion.setAttribute("login", visitorUpdate);
		Visitor visitorUpdate = (Visitor) sesion.getAttribute("login");
		VisitorService vs = new VisitorService();
		
		//Cogemos el visitor de la sesión
		try {
			visitorUpdate.setFirstName(firstName);
			visitorUpdate.setLastName(lastName);
			visitorUpdate.setEmail(email);
			visitorUpdate.setDni(dni);
			visitorUpdate.setPhoneNumber(phoneNumber);
			visitorUpdate.setAddress(address);
			
			// Usamos el servicio para persistir un visitor
			int update = vs.updateVisitorDetails(visitorUpdate);
			// Cambiamos la vista
			if (update == 1) {
				sesion.setAttribute("login", visitorUpdate);
				url = "/WEB-INF/portal.jsp";
			} else {
				// visitor no modificado
				url = "/WEB-INF/updateVisitorInformation.jsp";
			}

		} catch (NullPointerException e) {
			throw new FERSGenericException(CTE_ERM_027);
		}
		return url;
	}
}
