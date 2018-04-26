package com.accenture.fers.web.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.accenture.fers.service.EventFacade;
import com.accenture.fers.service.EventService;

/**
 * Application Lifecycle Listener implementation class EventListener
 *
 */
@WebListener
public class EventListener implements ServletContextListener {

    /**
     * Default constructor.
     */
    public EventListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  {
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0)  {
         EventFacade eventServices = new EventService();

         arg0.getServletContext().setAttribute("eventList", eventServices.getAllEvents());
    }

}
