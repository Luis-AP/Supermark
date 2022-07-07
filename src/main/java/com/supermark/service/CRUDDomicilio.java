package com.supermark.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.supermark.models.Domicilio;

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
		this.sql = "INSERT INTO Domicilio "+
				"(calle1,numero,depNumero,piso,id_localidad) "+
				"VALUE ('"+
				dom.getCalle()+"',"+
				dom.getNumero()+","+
				dom.getDepNumero()+","+
				dom.getPiso()+","+
				dom.getLocalidad().getId()+
				")";
		try {
			PreparedStatement stmt = conexion.getConn().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			int filas = stmt.executeUpdate();
			if(filas>0) {
				ResultSet rs = stmt.getGeneratedKeys();
				while(rs.next()) {
					dom.setId(rs.getInt(1));
				}
			}
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
