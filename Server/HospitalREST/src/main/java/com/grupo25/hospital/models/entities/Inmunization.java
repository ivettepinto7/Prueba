package com.grupo25.hospital.models.entities;

public class Inmunization {
	private int id_inmunization;
	private int id_vaccine;
	private int age;
	private String gender;
	public Inmunization(int id_inmunization, int id_vaccine, int age, String gender) {
		super();
		this.id_inmunization = id_inmunization;
		this.id_vaccine = id_vaccine;
		this.age = age;
		this.gender = gender;
	}
	public int getId_inmunization() {
		return id_inmunization;
	}
	public void setId_inmunization(int id_inmunization) {
		this.id_inmunization = id_inmunization;
	}
	public int getId_vaccine() {
		return id_vaccine;
	}
	public void setId_vaccine(int id_vaccine) {
		this.id_vaccine = id_vaccine;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
}
