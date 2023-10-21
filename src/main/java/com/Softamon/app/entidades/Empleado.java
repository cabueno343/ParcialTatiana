package com.Softamon.app.entidades;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "empleados")
public class Empleado {

	@Id
	private String id;
	private String nombre_em;
	private String apell_em;
	private String correo_em;
	private String pass_usu;
	private String direc_em;
	private Integer Tel;
	private String estado_civ;
	private Integer sueldo_em;
	private String fecha_ini;
	private String fecha_fin;
	private String cargo;
	private Integer cc;
	private String imagen;
	
	
	public Empleado() {
		super();
	}

	public Empleado(String id, String nombre_em, String apell_em, String correo_em, String pass_usu, String direc_em,
			Integer tel, String estado_civ, Integer sueldo_em) {
		super();
		this.id = id;
		this.nombre_em = nombre_em;
		this.apell_em = apell_em;
		this.correo_em = correo_em;
		this.pass_usu = pass_usu;
		this.direc_em = direc_em;
		Tel = tel;
		this.estado_civ = estado_civ;
		this.sueldo_em = sueldo_em;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre_em() {
		return nombre_em;
	}

	public void setNombre_em(String nombre_em) {
		this.nombre_em = nombre_em;
	}

	public String getApell_em() {
		return apell_em;
	}

	public void setApell_em(String apell_em) {
		this.apell_em = apell_em;
	}

	public String getCorreo_em() {
		return correo_em;
	}

	public void setCorreo_em(String correo_em) {
		this.correo_em = correo_em;
	}

	public String getPass_usu() {
		return pass_usu;
	}

	public void setPass_usu(String pass_usu) {
		this.pass_usu = pass_usu;
	}

	public String getDirec_em() {
		return direc_em;
	}

	public void setDirec_em(String direc_em) {
		this.direc_em = direc_em;
	}

	public Integer getTel() {
		return Tel;
	}

	public void setTel(Integer tel) {
		Tel = tel;
	}

	public String getEstado_civ() {
		return estado_civ;
	}

	public void setEstado_civ(String estado_civ) {
		this.estado_civ = estado_civ;
	}

	public Integer getSueldo_em() {
		return sueldo_em;
	}

	public void setSueldo_em(Integer sueldo_em) {
		this.sueldo_em = sueldo_em;
	}
	
	
	public String getFecha_ini() {
		return fecha_ini;
	}

	public void setFecha_ini(String fecha_ini) {
		this.fecha_ini = fecha_ini;
	}

	public String getFecha_fin() {
		return fecha_fin;
	}

	public void setFecha_fin(String fecha_fin) {
		this.fecha_fin = fecha_fin;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	
	
	public Integer getCc() {
		return cc;
	}

	public void setCc(Integer cc) {
		this.cc = cc;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}



	

}
