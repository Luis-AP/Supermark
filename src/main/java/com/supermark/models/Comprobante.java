package com.supermark.models;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;

public class Comprobante {
	private Integer id;
	private Float total;
	private String tipo;
	private Timestamp fecha;
	private ArrayList<Detalle> detalles;
	private Usuario destinatario;
	private TarjetaCredito tarjeta;
	private Descuento descuento;
	
	public Comprobante() {
		super();
	}
	
	
	public Comprobante(String tipo,ArrayList<Detalle> detalles,
			Usuario destinatario, TarjetaCredito tarjeta) {
		super();
		System.out.println("Here");
		this.tipo = tipo;
		this.fecha = new Timestamp(System.currentTimeMillis());
		this.detalles = detalles;
		this.destinatario = destinatario;
		this.tarjeta = tarjeta;
	}
	
	private HashMap<Integer, Detalle>
    convertArrayListToHashMap(ArrayList<Detalle> list){
  
        HashMap<Integer, Detalle> hashMap = new HashMap<>();
  
        for (int i=0;i<list.size();i++) {
            hashMap.put(i, list.get(i));
        }
  
        return hashMap;
    }
	
//	public Comprobante(String tipo, Timestamp fecha, HashMap<Integer, Detalle> detalles,
//			Usuario destinatario, TarjetaCredito tarjeta) {
//		super();
//		this.tipo = tipo;
//		this.fecha = fecha;
//		this.detalles = detalles;
//		this.destinatario = destinatario;
//		this.tarjeta = tarjeta;
//	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Float getTotal() {
		return total;
	}
	public void setTotal(Float total) {
		this.total = total;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Timestamp getFecha() {
		return fecha;
	}
	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}
	
	public ArrayList<Detalle> getDetalles() {
		return detalles;
	}
	
	public Usuario getDestinatario() {
		return destinatario;
	}
	public void setDestinatario(Usuario destinatario) {
		this.destinatario = destinatario;
	}
	public Descuento getDescuento() {
		return descuento;
	}
	public void setDescuento(Descuento descuento) {
		this.descuento = descuento;
	}
	public void setDetalles(ArrayList<Detalle> detalles) {
		this.detalles = detalles;
	}
	
	public TarjetaCredito getTarjeta() {
		return tarjeta;
	}
	public void setTarjeta(TarjetaCredito tarjeta) {
		this.tarjeta = tarjeta;
	}
	@Override
	public String toString() {
		String comprobante = "";
		comprobante += "Comprobante [id=" + id + ", total=" + total + ", tipo=" + tipo + ", fecha=" + fecha + ", destinatario=" + destinatario + ", descuento=" + descuento + ", detalles={";
		for(Detalle clave:detalles) {
			comprobante += "\n Producto: "+clave.getProducto();
		}
		comprobante += "} ]";
		return comprobante;
	}
	
	
}
