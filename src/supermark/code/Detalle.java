package supermark.code;

public class Detalle {
	private Producto producto;
	private Integer cantidad;
	
	public Detalle(Producto producto, Integer cantidad) {
		super();
		this.producto = producto;
		this.cantidad = cantidad;
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
	@Override
	public String toString() {
		return "Detalle [producto=" + producto + ", cantidad=" + cantidad + "]";
	}
}
