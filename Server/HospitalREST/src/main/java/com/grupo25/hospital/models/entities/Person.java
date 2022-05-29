package com.grupo25.hospital.models.entities;

import java.time.LocalDate;

public class Person {
	private int id_person;
	private String name;
	private String last_name;
	private String status;
	private String email;
	private String password;
	private int id_rol;
	private LocalDate birthdate;
	private int id_area;
	public Person(int id_person, String name, String last_name, String status, String email, String password,
			int id_rol, LocalDate birthdate, int id_area) {
		super();
		this.id_person = id_person;
		this.name = name;
		this.last_name = last_name;
		this.status = status;
		this.email = email;
		this.password = password;
		this.id_rol = id_rol;
		this.birthdate = birthdate;
		this.id_area = id_area;
	}
	public int getId_person() {
		return id_person;
	}
	public void setId_person(int id_person) {
		this.id_person = id_person;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getId_rol() {
		return id_rol;
	}
	public void setId_rol(int id_rol) {
		this.id_rol = id_rol;
	}
	public LocalDate getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}
	public int getId_area() {
		return id_area;
	}
	public void setId_area(int id_area) {
		this.id_area = id_area;
	}
	
	
}
