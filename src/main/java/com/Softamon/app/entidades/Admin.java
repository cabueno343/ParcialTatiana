package com.Softamon.app.entidades;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "admins")
public class Admin {
	
	@Id
	private String id;
	private String nombre;
	private String pass_usu;
	private String email_usu;
	
	public Admin() {
		super();
	}

	public Admin(String id, String nombre, String pass_usu, String email_usu) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.pass_usu = pass_usu;
		this.email_usu = email_usu;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPass_usu() {
		return pass_usu;
	}

	public void setPass_usu(String pass_usu) {
		this.pass_usu = pass_usu;
	}

	public String getEmail_usu() {
		return email_usu;
	}

	public void setEmail_usu(String email_usu) {
		this.email_usu = email_usu;
	}
	
	
	
	
	

}
