package com.supermark.service;

import java.sql.SQLException;

import com.supermark.models.Domicilio;
import com.supermark.models.Localidad;

public class CRUDDomicilio {
	private Conexion conexion;
	private String sql;
	
	public CRUDDomicilio() {
		super();
		this.conexion = new Conexion("supermark");
		this.conexion.connect();//Abre la conexion
		this.sql = "";
	}
	
	public Domicilio register(Domicilio dom) {
//		CRUDLocalidad cl = new CRUDLocalidad();
//		Localidad localidad = cl.getLocalidad();
		this.sql = "INSERT INTO domicilio "+
				"(calle1,numero,depNumero,piso,id_localidad) "+
				"VALUE ('"+
				dom.getCalle()+"',"+
				dom.getNumero()+","+
				dom.getDepNumero()+","+
				dom.getPiso()+","+
				dom.getLocalidad().getId()+
				")";
		try {
			int row = conexion.getStmt().executeUpdate(sql);
			dom.setId(row);
			System.out.println("Domicilio registrado");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dom;
	}
	
	public Domicilio getDomicilio(Integer id) {
		this.sql = "SELECT calle1,numero,depNumero,piso FROM domicilio "+
				"WHERE domicilio.id="+id;
		Domicilio dom = null;
		try {
			conexion.setRs(conexion.getStmt().executeQuery(sql));
			dom = new Domicilio(
						id,
						conexion.getRs().getString("calle1"),
						conexion.getRs().getInt("numero"),
						conexion.getRs().getInt("depNumero"),
						conexion.getRs().getInt("piso")
						);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dom;
	}
}
