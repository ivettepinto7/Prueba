package com.grupo25.hospital.models.entities;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "appointment")
public class Appointment {
	
	@Id
	@Column(name = "id_appointment")
	@SequenceGenerator(name = "appointment_id_appointment_gen", sequenceName = "appointment_id_appointment_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "appointment_id_appointment_seq")
	private Long id_appointment;
	
	//paciente puede tener varias citas, pero una cita puede tener solo un paciente
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_patient")
	private Person id_patient;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_doctor", nullable = true)
	private Person id_doctor;
	
	@Column(name = "appointment_time")
	private Date appointment_time;
	
	@Column(name = "status")
	private Boolean status;
	
	@Column(name = "appointment_details", nullable = true)
	private String appointment_details;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_appointment_type", nullable = true)
	private Appointment_type id_appointment_type;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_inmunization", nullable = true)
	private Inmunization id_inmunization;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_test", nullable = true)
	private Test id_test;


	public Appointment(Person id_patient, Person id_doctor, Date appointment_time, Boolean status,
			String appointment_details, Appointment_type id_appointment_type, Inmunization id_inmunization,
			Test id_test) {
		super();
		this.id_patient = id_patient;
		this.id_doctor = id_doctor;
		this.appointment_time = appointment_time;
		this.status = status;
		this.appointment_details = appointment_details;
		this.id_appointment_type = id_appointment_type;
		this.id_inmunization = id_inmunization;
		this.id_test = id_test;
	}

	

	public Appointment() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Long getId_appointment() {
		return id_appointment;
	}


	public void setId_appointment(Long id_appointment) {
		this.id_appointment = id_appointment;
	}


	public Person getId_patient() {
		return id_patient;
	}


	public void setId_patient(Person id_patient) {
		this.id_patient = id_patient;
	}


	public Person getId_doctor() {
		return id_doctor;
	}


	public void setId_doctor(Person id_doctor) {
		this.id_doctor = id_doctor;
	}


	public Date getAppointment_time() {
		return appointment_time;
	}


	public void setAppointment_time(Date appointment_time) {
		this.appointment_time = appointment_time;
	}


	public Boolean getStatus() {
		return status;
	}


	public void setStatus(Boolean status) {
		this.status = status;
	}


	public String getAppointment_details() {
		return appointment_details;
	}


	public void setAppointment_details(String appointment_details) {
		this.appointment_details = appointment_details;
	}


	public Appointment_type getId_appointment_type() {
		return id_appointment_type;
	}


	public void setId_appointment_type(Appointment_type id_appointment_type) {
		this.id_appointment_type = id_appointment_type;
	}


	public Inmunization getId_inmunization() {
		return id_inmunization;
	}


	public void setId_inmunization(Inmunization id_inmunization) {
		this.id_inmunization = id_inmunization;
	}


	public Test getId_test() {
		return id_test;
	}


	public void setId_test(Test id_test) {
		this.id_test = id_test;
	}
	
	
	
	
}
