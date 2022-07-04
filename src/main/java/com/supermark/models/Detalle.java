package com.supermark.models;

public class Detalle {
	private Integer id;
	private Producto producto;
	private Integer cantidad;
	private Integer id_comprobante;
	
	public Detalle(Producto producto, Integer cantidad) {
		super();
		this.producto = producto;
		this.cantidad = cantidad;
	}
	public Detalle(Producto producto, Integer cantidad,Integer id_comprobante) {
		super();
		this.producto = producto;
		this.cantidad = cantidad;
		this.id_comprobante = id_comprobante;
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getId_comprobante() {
		return id_comprobante;
	}
	public void setId_comprobante(Integer id_comprobante) {
		this.id_comprobante = id_comprobante;
	}
	@Override
	public String toString() {
		return "Detalle [producto=" + producto + ", cantidad=" + cantidad + "]";
	}
}
