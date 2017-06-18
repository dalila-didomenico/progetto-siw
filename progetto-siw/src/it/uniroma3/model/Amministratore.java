package it.uniroma3.model;

import javax.persistence.*;

@Entity
@NamedQuery(name= "findAllAmministratori", query="SELECT amm FROM Amministratore amm")
public class Amministratore {
	
	@Id
	private String email;
	private String password;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	 
	

}