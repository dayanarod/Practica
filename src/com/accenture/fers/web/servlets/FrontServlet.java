package com.accenture.fers.web.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accenture.fers.web.controllers.IController;
import com.accenture.fers.web.controllers.NewVisitorController;


/**
 * Servlet implementation class FrontServlet
 */
@WebServlet("*.do")
public class FrontServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    Map<String,IController> controllers = new HashMap<>();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontServlet() {
        super();
        controllers.put("/register.do", new NewVisitorController());

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processServlet(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processServlet(request,response);

	}

	private void processServlet(HttpServletRequest request, HttpServletResponse response) {
		//1. Recuperamos la acción (url)
		String url = request.getServletPath();

		//2. Obtenemos el controlador correspondiente a la acción
		IController controller = controllers.get(url);

		//3. Obtenemos la vista
		String view = controller.process(request, response);

		//4. Creo el dispatcher con la vista obtenida
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);

		try{
			dispatcher.forward(request, response);
		}
		catch (Exception e){
			e.printStackTrace();
		}

	}

}