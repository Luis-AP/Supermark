package com.supermark.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.supermark.models.*;

public class CRUDCarrito {
	private Conexion conexion;
	private String sql;
	
	public CRUDCarrito() {
		super();
		this.conexion = new Conexion("Supermark");
		this.conexion.connect();//Abre la conexion
		this.sql = "";
	}
	
	public boolean agregar(Carrito carrito) {//-->Registrar un usuario
		this.sql = "INSERT INTO Carrito "+
				"(id_usuario,id_producto,cantidad) "+
				"VALUE ("+
				carrito.getUsuario().getId()+","+
				carrito.getProducto().getId()+","+
				carrito.getCantidad()+")";
		boolean resultado = false;
		try {
			int rows = conexion.getStmt().executeUpdate(sql);
			if(rows>0){
				resultado = true;
			}
			System.out.println("Producto agregado al Carrito");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultado;
	}
	
	public ArrayList<Detalle> getListado(Usuario usuario){
		ArrayList<Detalle> detalles = new ArrayList<Detalle>();
		
		this.sql = "SELECT id_producto,cantidad FROM Carrito "+
					"WHERE id_usuario = "+usuario.getId();
		
		try {
			conexion.setRs(conexion.getStmt().executeQuery(sql));;
			while(conexion.getRs().next()) {
				detalles.add(new Detalle(
							new Producto(conexion.getRs().getInt("id_producto")),
							conexion.getRs().getInt("cantidad")
						));
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return detalles;
	}
	
	public boolean vaciar(Usuario usuario){
		boolean resultado = false;
		this.sql = "DELETE FROM Carrito WHERE id_usuario = "+usuario.getId();
		
		try {
			int rows = conexion.getStmt().executeUpdate(sql);
			if(rows>0) {
				resultado = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return resultado;
	}
}