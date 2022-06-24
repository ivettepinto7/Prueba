package com.grupo25.hospital.models.entities;

public class PrescriptionXAppointment {
	private int id_prescription;
	private int id_appointment;
	public PrescriptionXAppointment(int id_prescription, int id_appointment) {
		super();
		this.id_prescription = id_prescription;
		this.id_appointment = id_appointment;
	}
	public int getId_prescription() {
		return id_prescription;
	}
	public void setId_prescription(int id_prescription) {
		this.id_prescription = id_prescription;
	}
	public int getId_appointment() {
		return id_appointment;
	}
	public void setId_appointment(int id_appointment) {
		this.id_appointment = id_appointment;
	}
	
	
}
