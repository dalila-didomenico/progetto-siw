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

import it.uniroma3.model.Autore;
import it.uniroma3.model.Quadro;
import it.uniroma3.service.AutoreService;
import it.uniroma3.service.QuadroService;
import it.uniroma3.validator.QuadroValidator;

@WebServlet("/quadro")
public class QuadroController extends HttpServlet {

	public QuadroController() {
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String nextPage;
		AutoreService as = new AutoreService();
		List<Autore> autori = as.getAutori();
		request.setAttribute("autori", autori);
		
		if(request.getParameter("commandC")!=null){
			long id= Long.parseLong(request.getParameter("id"));
			QuadroService pv = new QuadroService();
			Quadro q = pv.getOne(id);//NO
			pv.delete(q);						   // param id
			request.setAttribute("quadri",pv.getQuadri());
			nextPage="/quadri.jsp";
		}
		else{
			
			Quadro quadro = new Quadro();
			request.setAttribute("quadro", quadro);
			String autore = request.getParameter("autore");
			request.setAttribute("autore", autore );
			
			QuadroValidator validator = new QuadroValidator();

			if(validator.validate(request)) {
				nextPage = "/quadro.jsp";
			}
			else
				nextPage = "/index.jsp";

		}
		ServletContext application  = getServletContext();
		RequestDispatcher rd = application.getRequestDispatcher(nextPage);
		rd.forward(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String nextPage = "/quadri.jsp";

		QuadroService service = new QuadroService();
		if(request.getParameter("id") != null) {
			Long id = Long.parseLong(request.getParameter("id"));
			Quadro quadro = service.getOne(id);
			request.setAttribute("quadro", quadro);
			nextPage = "/quadro.jsp";
		}
		else {
			List<Quadro> quadri = service.getQuadri();
			request.setAttribute("quadri", quadri);
		}

		ServletContext application = getServletContext();
		RequestDispatcher rd = application.getRequestDispatcher(nextPage);
		rd.forward(request, response);	
	}
}