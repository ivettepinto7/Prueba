package com.grupo25.hospital.models.dtos;

import java.time.LocalDate;

public class ScheduleAppointmentDTO {
	private int patient_code;
	private int type;
	private String test;
	private LocalDate date;
	public ScheduleAppointmentDTO(int patient_code, int type, String test, LocalDate date) {
		super();
		this.patient_code = patient_code;
		this.type = type;
		this.test = test;
		this.date = date;
	}
	public int getPatient_code() {
		return patient_code;
	}
	public void setPatient_code(int patient_code) {
		this.patient_code = patient_code;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getTest() {
		return test;
	}
	public void setTest(String test) {
		this.test = test;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
}
