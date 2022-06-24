package com.grupo25.hospital.models.dtos;

import java.time.LocalDate;

public class InmunizationsDTO {
	private int id_inmunization;
	private String vaccine_name;
	private int age;
	private LocalDate date;
	public InmunizationsDTO(int id_inmunization, String vaccine_name, int age, LocalDate date) {
		super();
		this.id_inmunization = id_inmunization;
		this.vaccine_name = vaccine_name;
		this.age = age;
		this.date = date;
	}
	public int getId_inmunization() {
		return id_inmunization;
	}
	public void setId_inmunization(int id_inmunization) {
		this.id_inmunization = id_inmunization;
	}
	public String getVaccine_name() {
		return vaccine_name;
	}
	public void setVaccine_name(String vaccine_name) {
		this.vaccine_name = vaccine_name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
}
