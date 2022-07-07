package com.supermark.models;

import java.sql.Date;

public class Producto {
	private Integer id;
	private String nombre;
	private String marca;
	private Date f_venc;
	private Float precio;
	private Integer stock;
	
	public Producto(Integer id) {
		super();
		this.id = id;
	}
	
	public Producto(Integer id,Float precio) {
		super();
		this.id = id;
		this.precio = precio;
	}
	
	public Producto(Integer id,String nombre,Float precio) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
	}
	
	public Producto(Integer id,Integer stock) {
		super();
		this.id = id;
		this.stock = stock;
	}
	
	public Producto(Integer id, String nombre, String marca, Date f_venc, Float precio, Integer stock) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.marca = marca;
		this.f_venc = f_venc;
		this.precio = precio;
		this.stock = stock;
	}
	
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public Date getF_venc() {
		return f_venc;
	}
	public void setF_venc(Date f_venc) {
		this.f_venc = f_venc;
	}
	public Float getPrecio() {
		return precio;
	}
	public void setPrecio(Float precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", marca=" + marca + ", f_venc=" + f_venc + ", precio="
				+ precio + ", stock=" + stock + "]";
	}
}