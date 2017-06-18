package it.uniroma3.validator;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import it.uniroma3.model.Autore;

public class AutoreValidator {

	public AutoreValidator() {
		// TODO Auto-generated constructor stub
	}

	public boolean validate(HttpServletRequest request) {

		boolean tuttoOk = true;
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String nazionalità = request.getParameter("nazionalità");
		String dataNascita = request.getParameter("dataNascita");
		String dataMorte = request.getParameter("dataMorte");
		Autore autore = (Autore) request.getAttribute("autore");

		if(nome == null || nome.equals("")) {
			request.setAttribute("errNome", "Campo obbligatorio");
			tuttoOk = false;
		}
		else 
			autore.setNome(nome);

		if(cognome == null || cognome.equals("")) {
			request.setAttribute("errCognome", "Campo obbligatorio");
			tuttoOk = false;
		}
		else
			autore.setCognome(cognome);

		if(nazionalità == null || nazionalità.equals("")) {
			request.setAttribute("errNazionalità", "Campo obbligatorio");
			tuttoOk = false;
		}
		else {
			autore.setNazionalità(nazionalità);
		}

		if(dataNascita == null || dataNascita.equals("")) {
			request.setAttribute("errDataNascita", "Campo obbligatorio");
			tuttoOk = false;
		}
		else {
			try {
				DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
				autore.setDataNascita(df.parse(dataNascita));
				if(df.parse(dataNascita).compareTo(new Date()) > 0) {
					request.setAttribute("errDataNascita", "Deve essere precedente alla data di oggi!");
					tuttoOk = false;
				}
			} catch (ParseException e) {
				request.setAttribute("errDataNascita", "Deve essere una data valida!");
				tuttoOk = false;
			}
		}	

		if(dataMorte == null || dataMorte.equals("")) {
			request.setAttribute("errDataMorte", "Campo obbligatorio");
			tuttoOk = false;
		}
		else {
			try {
				DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
				autore.setDataMorte(df.parse(dataMorte));
				if(df.parse(dataMorte).compareTo(new Date()) > 0) {
					request.setAttribute("errDataMorte", "Deve essere precedente alla data di oggi!");
					tuttoOk = false;
				}
			} catch (ParseException e) { //la data di morte deve essere successiva alla data di nascita. Come fare?
				request.setAttribute("errDataMorte", "Deve essere una data valida!");
				tuttoOk = false;
			}
		}	
		return tuttoOk;
	}
}