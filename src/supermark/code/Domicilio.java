package supermark.code;

public class Domicilio {
	private String localidad;
	private String calle;
	private Integer numero;
	private Integer depNumero;
	private Integer piso;
	
	
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public Integer getDepNumero() {
		return depNumero;
	}
	public void setDepNumero(Integer depNumero) {
		this.depNumero = depNumero;
	}
	public Integer getPiso() {
		return piso;
	}
	public void setPiso(Integer piso) {
		this.piso = piso;
	}
	public String getLocalidad() {
		return localidad;
	}
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	
	
}
