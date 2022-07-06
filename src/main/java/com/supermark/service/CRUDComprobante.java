package com.supermark.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.supermark.models.Comprobante;
import com.supermark.models.Detalle;
import com.supermark.models.Usuario;

public class CRUDComprobante {
	private Conexion conexion;
	private String sql;
	
	public CRUDComprobante() {
		super();
		this.conexion = new Conexion("supermark");
		this.conexion.connect();//Abre la conexion
		this.sql = "";
	}
	
	public void registrarCompra(Comprobante comprobante) {
		CRUDCarrito ccarr = new CRUDCarrito();
		ArrayList<Detalle> detalles = ccarr.getListado(comprobante.getDestinatario());
		comprobante.setDetalles(detalles);
		this.sql = "INSERT INTO Comprobante "+
				"(tipo,fecha,id_usuario,id_tc) "+
				"VALUE ('"+
				comprobante.getTipo()+"','"+
				comprobante.getFecha()+"',"+
				comprobante.getDestinatario().getId()+","+
				comprobante.getTarjeta().getNumero()+")";
		try {
			PreparedStatement stmt = conexion.getConn().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			int rows = stmt.executeUpdate();
			if(rows>0) {
				conexion.setRs(stmt.getGeneratedKeys());
				while(conexion.getRs().next()) {
					comprobante.setId(conexion.getRs().getInt(1));
				}
			}
			agregarDetallesAComprobante(detalles,comprobante.getId());
			ccarr.vaciar(comprobante.getDestinatario());
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			System.out.println("Comprobante registrado");
		}
	}
	
	private void agregarDetallesAComprobante(ArrayList<Detalle> detalles,Integer id_comprobante) {
		CRUDDetalle cd = new CRUDDetalle();
		CRUDProducto cp = new CRUDProducto();
		for(Detalle det:detalles) {
			det.getProducto().setStock(cp.getStockActual(det.getProducto()));
			if(det.getProducto().getStock()-det.getCantidad()>=0) {
				//Insertamos una fila en la tabla Detalle
				cd.registrarDetalle(det,id_comprobante);
				//Actualizacion sobre la tabla Producto
				//cp.getStockActual(det.getProducto());
				cp.actualizarStock(det.getProducto(), -det.getCantidad());
			}else {
				System.out.println("No se dispone del stock necesario para realizar esta venta");
			}
		}
	}
	
	public ArrayList<Comprobante> getComprobantes(Usuario usuario) {
		ArrayList<Comprobante> comprobantes = new ArrayList<Comprobante>();
		this.sql = "SELECT * FROM comprobante WHERE id_usuario ="+
					usuario.getId();
		try {
			conexion.setRs(conexion.getStmt().executeQuery(sql));
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			System.out.println("Comprobantes del Usuario:");
			ResultSet rs = conexion.getRs();
			try {
				CRUDDetalle cd = new CRUDDetalle();
				while (rs.next()) {//Mientras exista un fila siguiente/Elementos en el conjunto
					Comprobante comp = new Comprobante();
					comp.setId(rs.getInt("id"));
					comp.setTipo(rs.getString("tipo"));
					comp.setFecha(rs.getTimestamp("fecha"));
					//Busco las lineas de detalle asociadas al comprobante
					comp.setDetalles(cd.getLineasDetalle(comp));
					
					comprobantes.add(comp);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return comprobantes;
	}
}
