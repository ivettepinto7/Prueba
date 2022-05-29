package com.grupo25.hospital.models.entities;

public class Appointment_type {
	private int id_appointment_type;
	private String type_name;
	public Appointment_type(int id_appointment_type, String type_name) {
		super();
		this.id_appointment_type = id_appointment_type;
		this.type_name = type_name;
	}
	public int getId_appointment_type() {
		return id_appointment_type;
	}
	public void setId_appointment_type(int id_appointment_type) {
		this.id_appointment_type = id_appointment_type;
	}
	public String getType_name() {
		return type_name;
	}
	public void setType_name(String type_name) {
		this.type_name = type_name;
	}
	
	
}
