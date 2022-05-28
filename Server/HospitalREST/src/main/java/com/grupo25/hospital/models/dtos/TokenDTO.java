package com.grupo25.hospital.models.dtos;

public class TokenDTO {
	private String token;

	public TokenDTO(String token) {
		super();
		this.token = token;
	}

	public TokenDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	

}
