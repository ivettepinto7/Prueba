package com.grupo25.hospital.models.dtos;

public class IniciarSesionDTO {
	private int code;
	private String pass;
	public IniciarSesionDTO(int code, String pass) {
		super();
		this.code = code;
		this.pass = pass;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
}
