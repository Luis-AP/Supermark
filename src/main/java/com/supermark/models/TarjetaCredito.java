package com.supermark.models;

public class TarjetaCredito {
	private Integer numero;
	private Usuario usuario;
	private String banco;
	protected double balance;
	private double limite;
	
	public TarjetaCredito(Integer numero) {
		super();
		this.numero = numero;
	}
	
	public TarjetaCredito(Integer numero, Usuario usuario, String banco, double balance, double limite) {
		super();
		this.usuario = usuario;
		this.numero = numero;
		this.banco = banco;
		this.balance = balance;
		this.limite = limite;
	}

	public Integer getNumero() {
		return numero;
	}

	public String getBanco() {
		return banco;
	}

	public void setBanco(String banco) {
		this.banco = banco;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getLimite() {
		return limite;
	}

	public void setLimite(double limite) {
		this.limite = limite;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}
