package com.supermark.models;

public class Usuario {
	private Integer id;
	private String nombre;
	private String apellido;
	private Integer dni;
	private String contrasenia;
	private String email;
	private Domicilio domicilio;
	
	public Usuario(Integer id) {
		super();
		this.id = id;
	}
	
	public Usuario(String nombre, String apellido, String email, Integer dni, String contrasenia,
			Domicilio domicilio) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.dni = dni;
		this.contrasenia = contrasenia;
		this.domicilio = domicilio;
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
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public Integer getDni() {
		return dni;
	}
	public void setDni(Integer dni) {
		this.dni = dni;
	}
	
	public Domicilio getDomicilio() {
		return domicilio;
	}
	
	public void setDomicilio(Domicilio domicilio) {
		this.domicilio = domicilio;
	}
	public String getContrasenia() {
		return contrasenia;
	}
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
