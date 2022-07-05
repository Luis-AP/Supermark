package com.supermark.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.supermark.models.Comprobante;
import com.supermark.models.Detalle;
import com.supermark.models.Producto;

public class CRUDDetalle {
	private Conexion conexion;
	private String sql;
	
	public CRUDDetalle() {
		super();
		this.conexion = new Conexion("supermark");
		this.conexion.connect();//Abre la conexion
		this.sql = "";
	}
	
	public ArrayList<Detalle> getLineasDetalle(Comprobante comp){
		ArrayList<Detalle> detalles = new ArrayList<Detalle>();
		this.sql = "SELECT * FROM detalle WHERE id_comprobante ="+
				comp.getId();
		ResultSet rs;
		try {
			rs = conexion.getStmt().executeQuery(sql);
			CRUDProducto cp = new CRUDProducto();
			int count = 0;
			while (rs.next()) {
				count++;
				Producto prod = cp.getProducto(rs.getInt("id_producto"));
				Detalle linea = new Detalle(prod, rs.getInt("cantidad"));
				detalles.add(linea);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return detalles;
	}
	
	public void registrarDetalle(Detalle detalle) {
		this.sql = "INSERT INTO detalle "+
				"(id_comprobante,id_producto,cantidad) "+
				"VALUE ("+
				detalle.getId_comprobante()+","+
				detalle.getProducto().getId()+","+
				detalle.getCantidad()+")";
		try {
			conexion.getStmt().executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			System.out.println("Linea de Detalle agregada");
		}
	}
}
