package com.grupo25.hospital.models.dtos;

public class EditUserDTO {
	private int code;
	private String corre;
	private String pass;
	private boolean status;
	
	public EditUserDTO(int code, String corre, String pass, boolean status) {
		super();
		this.code = code;
		this.corre = corre;
		this.pass = pass;
		this.status = status;
	}
	public String getCorre() {
		return corre;
	}
	public void setCorre(String corre) {
		this.corre = corre;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	
}
