package it.uniroma3.validator;


import javax.servlet.http.HttpServletRequest;

import it.uniroma3.model.Autore;
import it.uniroma3.model.Quadro;

public class QuadroValidator {

	public boolean validate(HttpServletRequest request) {

		boolean tuttoOk = true;
		String titolo = request.getParameter("titolo");
		String tecnica = request.getParameter("tecnica");
		String dimensioni = request.getParameter("dimensioni");
		String anno = request.getParameter("anno");
		Autore autore = (Autore)request.getAttribute("autore");		
		Quadro quadro = (Quadro) request.getAttribute("quadro");

		if(titolo == null || titolo.equals("")) {
			request.setAttribute("errTitolo", "Campo obbligatorio");
			tuttoOk = false;
		}
		else 
			quadro.setTitolo(titolo);

		if(tecnica == null || tecnica.equals("")) {
			request.setAttribute("errTecnica", "Campo obbligatorio");
			tuttoOk = false;
		}
		else
			quadro.setTecnica(tecnica);

		if(dimensioni == null || dimensioni.equals("")) {
			request.setAttribute("errDimensioni", "Campo obbligatorio");
			tuttoOk = false;
		}
		else {
			quadro.setDimensioni(dimensioni);
		}

		if(anno == null || anno.equals("")) {
			request.setAttribute("errAnno", "Campo obbligatorio");
			tuttoOk = false;
		}
		else {			
			quadro.setAnno(Integer.parseInt(anno));
		}	

		if(autore==null || autore.equals("")) {
			request.setAttribute("errAutore", "Specifica un autore");
			tuttoOk=false;
		} else {
			quadro.setAutore(autore);
		}
		return tuttoOk;
	}

}