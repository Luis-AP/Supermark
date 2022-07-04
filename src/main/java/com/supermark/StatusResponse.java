package com.supermark;

public enum StatusResponse {
	SUCCESS("Completado"),
	ERROR("Error");

	private String status;
	
	StatusResponse(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
