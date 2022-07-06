package com.supermark.models;

public class Carrito {
	private Integer id;
	private Usuario usuario;
	private Producto producto;
	private Integer cantidad;
	
	public Carrito(Usuario usuario, Producto producto, Integer cantidad) {
		super();
		this.usuario = usuario;
		this.producto = producto;
		this.cantidad = cantidad;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
	
}
