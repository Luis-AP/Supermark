package com.supermark.models;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;

public class Comprobante {
	private Integer id;
	private Float total;
	private String tipo;
	private Timestamp fecha;
	private HashMap<Integer, Detalle> detalles;
	private Usuario destinatario;
	private TarjetaCredito tarjeta;
	private Descuento descuento;
	
	public Comprobante() {
		super();
	}
	
	public Comprobante(String tipo, ArrayList<Detalle> detalles,
			Usuario destinatario, TarjetaCredito tarjeta) {
		super();
		this.tipo = tipo;
		this.detalles = this.convertArrayListToHashMap(detalles);
		this.destinatario = destinatario;
		this.tarjeta = tarjeta;
	}
	
	private HashMap<Integer, Detalle>
    convertArrayListToHashMap(ArrayList<Detalle> list){
  
        HashMap<Integer, Detalle> hashMap = new HashMap<>();
  
        for (Detalle det : list) {
        	det.setId_comprobante(this.id);
            hashMap.put(det.getId(), det);
        }
  
        return hashMap;
    }
	
	public Comprobante(String tipo, Timestamp fecha, HashMap<Integer, Detalle> detalles,
			Usuario destinatario, TarjetaCredito tarjeta) {
		super();
		this.tipo = tipo;
		this.fecha = fecha;
		this.detalles = detalles;
		this.destinatario = destinatario;
		this.tarjeta = tarjeta;
	}
	
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
	
	public HashMap<Integer, Detalle> getDetalles() {
		return detalles;
	}
	public void setProdutos(HashMap<Integer, Detalle> detalles) {
		this.detalles = detalles;
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
	public void setDetalles(HashMap<Integer, Detalle> detalles) {
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
		for(Integer clave:detalles.keySet()) {
			comprobante += "\n Producto: "+detalles.get(clave).getProducto();
		}
		comprobante += "} ]";
		return comprobante;
	}
	
	
}
