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
 * Controlador para eliminar eventos a un usuario 
 */
public class EventUnregController implements IController{
	VisitorFacade visitorService = new VisitorService();
	EventFacade eventService = new EventService();
	
	/**
	 * Metodo principal que elimina el evento
	 * @param request Peticion
	 * @param response Respuesta
	 * @return url Vista a la que volvemos
	 */
	public String process(HttpServletRequest request,
			HttpServletResponse response) {

		String url = "./WEB-INF/portal.jsp";
		Visitor visitante;

		try{
			//Obtenemos al usuario
			HttpSession sesion = request.getSession(true);	
			visitante = (Visitor) sesion.getAttribute("login");

			//Obtenemos el id del evento y eliminamos el evento al usuario
			visitorService.unregisterVisitorToEvent(visitante, Integer.parseInt(request.getParameter("eventId")));
			visitante = visitorService.searchUser(visitante);
			
			//Actualizamos los datos de la sesion, primero el usuario y después los eventos.
			sesion.setAttribute("login", visitante);
			request.getServletContext().setAttribute("eventList", eventService.getAllEvents());
		} catch(FERSGenericException e){
			request.setAttribute("exception", e.getMessage());
		} catch(Exception e) {
			request.setAttribute("exception", e.getMessage());
		}
		return url;
	}
}
