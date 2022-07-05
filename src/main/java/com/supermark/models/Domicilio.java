package com.supermark.models;

public class Domicilio {
	private Integer id;
	private String calle;
	private Integer numero;
	private Integer depNumero;
	private Integer piso;
	private Localidad localidad;
	
	public Domicilio(Integer id) {
		this.id = id;
	}
	
	public Domicilio(Integer id, String calle, Integer numero, Integer depNumero, Integer piso) {
		super();
		this.id = id;
		this.calle = calle;
		this.numero = numero;
		this.depNumero = depNumero;
		this.piso = piso;
	}
	
	public Domicilio(String calle, Integer numero,Localidad localidad) {
		super();
		this.calle = calle;
		this.numero = numero;
		this.localidad = localidad;
	}
	
	public Domicilio(Integer id, String calle, Integer numero, Integer depNumero, Integer piso,Localidad localidad) {
		super();
		this.id = id;
		this.calle = calle;
		this.numero = numero;
		this.depNumero = depNumero;
		this.piso = piso;
		this.localidad = localidad;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public Integer getDepNumero() {
		return depNumero;
	}
	public void setDepNumero(Integer depNumero) {
		this.depNumero = depNumero;
	}
	public Integer getPiso() {
		return piso;
	}
	public void setPiso(Integer piso) {
		this.piso = piso;
	}

	public Localidad getLocalidad() {
		return localidad;
	}

	public void setLocalidad(Localidad localidad) {
		this.localidad = localidad;
	}
	
	
}
