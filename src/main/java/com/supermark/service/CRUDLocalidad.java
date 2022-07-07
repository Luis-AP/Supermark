package com.supermark.service;

import java.sql.SQLException;

import com.supermark.models.Localidad;

public class CRUDLocalidad {
	private Conexion conexion;
	private String sql;
	
	public CRUDLocalidad() {
		super();
		this.conexion = new Conexion("supermark");
		this.conexion.connect();//Abre la conexion
		this.sql = "";
	}
	
	public Localidad getLocalidad(Integer id) {
		this.sql = "SELECT * FROM localidad "+
				"WHERE localidad.id="+id;
		Localidad localidad = null;
		try {
			conexion.setRs(conexion.getStmt().executeQuery(sql));
			localidad = new Localidad(
						id
						);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return localidad;
	}
}
