package com.grupo25.hospital.models.dtos;

import java.util.Date;

import javax.validation.constraints.NotBlank;

public class ScheduleAppointmentDTO {
	@NotBlank
	private Long type; 
	@NotBlank
	private Long idTVD; //test vaccine or doctor
	@NotBlank
	private Date date;
	public ScheduleAppointmentDTO(Long type, Long idTVD, Date date) {
		super();
		this.type = type;
		this.idTVD = idTVD;
		this.date = date;
	}
	public Long getType() {
		return type;
	}
	public void setType(Long type) {
		this.type = type;
	}
	public Long getIdTVD() {
		return idTVD;
	}
	public void setIdTVD(Long idTVD) {
		this.idTVD = idTVD;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
}
