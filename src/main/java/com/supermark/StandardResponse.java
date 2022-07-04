package com.supermark;

import com.google.gson.JsonElement;

public class StandardResponse {
	private StatusResponse estado;
	private String mensaje;
	private JsonElement datos;
	    
	public StandardResponse(StatusResponse status) {
	    this.estado = status;
	}
	public StandardResponse(StatusResponse status, String message) {
		this.estado = status;
		this.mensaje = message;
	}
	public StandardResponse(StatusResponse status, JsonElement data) {
		this.estado = status;
		this.datos = data;
	}
	public StatusResponse getStatus() {
		return estado;
	}
	public void setStatus(StatusResponse status) {
		this.estado = status;
	}
	public String getMessage() {
		return mensaje;
	}
	public void setMessage(String message) {
		this.mensaje = message;
	}
	public JsonElement getData() {
		return datos;
	}
	public void setData(JsonElement data) {
		this.datos = data;
	}
}
