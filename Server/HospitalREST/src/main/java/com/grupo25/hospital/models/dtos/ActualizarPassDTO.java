package com.grupo25.hospital.models.dtos;

public class ActualizarPassDTO {
	private int code;
	private String current_password;
	private String new_password;
	private String confirm_password;
	public ActualizarPassDTO(int code, String current_password, String new_password, String confirm_password) {
		super();
		this.code = code;
		this.current_password = current_password;
		this.new_password = new_password;
		this.confirm_password = confirm_password;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getCurrent_password() {
		return current_password;
	}
	public void setCurrent_password(String current_password) {
		this.current_password = current_password;
	}
	public String getNew_password() {
		return new_password;
	}
	public void setNew_password(String new_password) {
		this.new_password = new_password;
	}
	public String getConfirm_password() {
		return confirm_password;
	}
	public void setConfirm_password(String confirm_password) {
		this.confirm_password = confirm_password;
	}
	
	
}
