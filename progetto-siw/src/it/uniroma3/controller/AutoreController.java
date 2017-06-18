package it.uniroma3.controller;


import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.uniroma3.model.*;
import it.uniroma3.service.AutoreService;
import it.uniroma3.validator.AutoreValidator;

@WebServlet("/autore")
public class AutoreController extends HttpServlet {

	public AutoreController() {
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String nextPage;
		if(request.getParameter("commandC")!=null){
		long id= Long.parseLong(request.getParameter("id"));
		AutoreService pv= new AutoreService();
		Autore a= pv.getOneAutore(id);//NO
		pv.delete(a);						   // param id
		request.setAttribute("autori",pv.getAutori());
		nextPage="/autori.jsp";
		}
		else{
		
		Autore autore = new Autore();
		request.setAttribute("autore", autore);
		
		AutoreValidator validator = new AutoreValidator();
		
		if(validator.validate(request)) {
			AutoreService service = new AutoreService();
			service.inserisciAutore(autore);
			nextPage = "/autore.jsp";
		}
		else
			nextPage = "/insAutore.jsp";

		}
		ServletContext application  = getServletContext();
		RequestDispatcher rd = application.getRequestDispatcher(nextPage);
		rd.forward(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nextPage = "/autori.jsp";
		
		AutoreService service = new AutoreService();
		
		if(request.getParameter("id") != null) {
			Long id = Long.parseLong(request.getParameter("id"));
			Autore autore = service.getOneAutore(id);
			request.setAttribute("autore", autore);
			List<Quadro> quadri = autore.getQuadri();
			request.setAttribute("quadri", quadri);
			nextPage = "/autore.jsp";
		}
		else {
			List<Autore> autori = service.getAutori();
			request.setAttribute("autori", autori);
		}
		
		ServletContext application = getServletContext();
		RequestDispatcher rd = application.getRequestDispatcher(nextPage);
		rd.forward(request, response);	
	}
}