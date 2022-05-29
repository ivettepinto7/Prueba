package com.grupo25.hospital.models.entities;

import java.time.LocalDate;

public class Appointment {
	private int id_appointment;
	private int id_patient;
	private int id_doctor;
	private LocalDate appointment_time;
	private int status;
	private String appointment_details;
	private int id_appointment_type;
	private int id_inmunization;
	private int id_test;
	public Appointment(int id_appointment, int id_patient, int id_doctor, LocalDate appointment_time, int status,
			String appointment_details, int id_appointment_type, int id_inmunization, int id_test) {
		super();
		this.id_appointment = id_appointment;
		this.id_patient = id_patient;
		this.id_doctor = id_doctor;
		this.appointment_time = appointment_time;
		this.status = status;
		this.appointment_details = appointment_details;
		this.id_appointment_type = id_appointment_type;
		this.id_inmunization = id_inmunization;
		this.id_test = id_test;
	}
	public int getId_appointment() {
		return id_appointment;
	}
	public void setId_appointment(int id_appointment) {
		this.id_appointment = id_appointment;
	}
	public int getId_patient() {
		return id_patient;
	}
	public void setId_patient(int id_patient) {
		this.id_patient = id_patient;
	}
	public int getId_doctor() {
		return id_doctor;
	}
	public void setId_doctor(int id_doctor) {
		this.id_doctor = id_doctor;
	}
	public LocalDate getAppointment_time() {
		return appointment_time;
	}
	public void setAppointment_time(LocalDate appointment_time) {
		this.appointment_time = appointment_time;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getAppointment_details() {
		return appointment_details;
	}
	public void setAppointment_details(String appointment_details) {
		this.appointment_details = appointment_details;
	}
	public int getId_appointment_type() {
		return id_appointment_type;
	}
	public void setId_appointment_type(int id_appointment_type) {
		this.id_appointment_type = id_appointment_type;
	}
	public int getId_inmunization() {
		return id_inmunization;
	}
	public void setId_inmunization(int id_inmunization) {
		this.id_inmunization = id_inmunization;
	}
	public int getId_test() {
		return id_test;
	}
	public void setId_test(int id_test) {
		this.id_test = id_test;
	}
	
	
}
