package com.grupo25.hospital.models.dtos;

public class PersonResponseDTO {
	private String email;
	private Boolean status;
	private String username;
	
	public PersonResponseDTO() {
		super();
	}
	
	

	public PersonResponseDTO(String email, Boolean status, String username) {
		super();
		this.email = email;
		this.status = status;
		this.username = username;
	}



	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	
}
