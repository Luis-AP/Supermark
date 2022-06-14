package supermark.code;

import java.sql.Date;
import java.util.HashMap;

public class Comprobante {
	private Integer id;
	private Float total;
	private Character tipo;
	private Date fecha;
	private HashMap<Integer, Detalle> detalles;
	private Usuario destinatario;
	
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
	public Character getTipo() {
		return tipo;
	}
	public void setTipo(Character tipo) {
		this.tipo = tipo;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
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
}
