package com.accenture.fers.web.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.accenture.fers.entity.Visitor;
import com.accenture.fers.exceptions.FERSGenericException;
import com.accenture.fers.service.EventFacade;
import com.accenture.fers.service.EventService;
import com.accenture.fers.service.VisitorFacade;
import com.accenture.fers.service.VisitorService;

/**
 * 
 * @author Diana Rodera Rojas
 * @version 02/05/2018
 * 
 *          Controlador para añadir eventos a un usuario
 *
 */
public class EventRegController implements IController {

	VisitorFacade visitorService = new VisitorService();
	EventFacade eventService = new EventService();

	/**
	 * @param request
	 *            Peticion
	 * @param response
	 *            Respuesta
	 * @return url Vista a la que volvemos
	 */
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// Vista a devolver
		String url = "./WEB-INF/portal.jsp";
		Visitor visitante;

		try {
			HttpSession sesion = request.getSession(true);
			//Cogemos el usuario
			visitante = (Visitor) sesion.getAttribute("login");
			
			//Añadimos el evento al visitor
			visitorService.registerVisitorToEvent(visitante, Integer.parseInt(request.getParameter("eventId")));
			visitante = visitorService.searchUser(visitante);
			
			//Usuario
			sesion.setAttribute("login", visitante);
			
			//Actualizamos los datos de la sesion
			request.getServletContext().setAttribute("eventList", eventService.getAllEvents());
		} catch (FERSGenericException e) {
			request.setAttribute("exception", e.getMessage());
		} catch (Exception e) {
			request.setAttribute("exception", e.getMessage());
		}
		return url;
	}
}
