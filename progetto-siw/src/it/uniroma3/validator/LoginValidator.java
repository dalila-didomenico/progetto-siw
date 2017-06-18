package it.uniroma3.validator;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import it.uniroma3.model.Amministratore;
import it.uniroma3.service.AmministratoreService;

public class LoginValidator {



	public LoginValidator() {

	}

	public boolean validate(HttpServletRequest request) {
		AmministratoreService as = new AmministratoreService();
		boolean tuttoOk = true;
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		Amministratore a = new Amministratore();
		a.setEmail(email);
		a.setPassword(password);

		if(email == null || email.equals("")) {
			request.setAttribute("errEmail", "Inserisci l'email");
			tuttoOk = false;
		} else if (password==null || password.equals("")) {
			request.setAttribute("errPassword", "Inserisci una password");
			tuttoOk = false;
		}
		else {
			List<Amministratore> amministratori = as.getAmministratori();
			for (Amministratore amm : amministratori) 
				tuttoOk = confronta(a, amm);
			if (tuttoOk=false) {
				String message = "Errore! Non è stato possibile effettuare l'accesso: email mancante o password errata.";
				request.setAttribute("errValidazione", message);
			}
		}return tuttoOk;
	}

	private boolean confronta(Amministratore a1, Amministratore a2) {
		return a1.getEmail().equals(a2.getEmail())&&a1.getPassword().equals(a2.getPassword());
	}
	
}