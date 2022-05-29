package com.grupo25.hospital.models.dtos;

public class RecuperarPassDTO {
	private int code;

	public RecuperarPassDTO(int code) {
		super();
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
}
