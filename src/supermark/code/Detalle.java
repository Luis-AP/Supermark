package supermark.code;

public class Detalle {
	private Producto descripcion;
	private Float descuento;
	private Integer cantidad;
	
	public Producto getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(Producto descipcion) {
		this.descripcion = descipcion;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public Float getDescuento() {
		return descuento;
	}
	public void setDescuento(Float descuento) {
		this.descuento = descuento;
	}
	
}
