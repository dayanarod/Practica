package com.accenture.fers.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class Filter
 */
@WebFilter("/Filter")
public class Filter implements javax.servlet.Filter {

    /**
     * Default constructor.
     */
    public Filter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//Recuperamos sesión
		HttpSession sesion = ((HttpServletRequest)request).getSession();

		//Conseguimos la url del servlet,es decir, la acción
		String url = ((HttpServletRequest)request).getServletPath();

		if((!url.equals("/login.do")) && (!url.equals("/register.do"))){
			if(sesion.getAttribute("usuarioSession") == null){
				//4. Despachamos la orden
				RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");

				try{
					dispatcher.forward(request, response);
				}catch (ServletException e) {
					e.printStackTrace();
				}catch (IOException e) {

				}
			} else {
				chain.doFilter(request, response);
			}
		} else {
		chain.doFilter(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
