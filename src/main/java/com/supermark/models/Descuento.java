package com.supermark.models;

public class Descuento {
	private Float porcentaje;
	private String dia;
	
	public Descuento(Float porcentaje, String dia) {
		super();
		this.porcentaje = porcentaje;
		this.dia = dia;
	}

	public Float getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(Float porcentaje) {
		this.porcentaje = porcentaje;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}
}
