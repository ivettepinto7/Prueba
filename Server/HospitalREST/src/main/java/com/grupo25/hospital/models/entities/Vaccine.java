package com.grupo25.hospital.models.entities;

public class Vaccine {
	private int id_vaccine;
	private String name;
	private int required_doses;
	public Vaccine(int id_vaccine, String name, int required_doses) {
		super();
		this.id_vaccine = id_vaccine;
		this.name = name;
		this.required_doses = required_doses;
	}
	public int getId_vaccine() {
		return id_vaccine;
	}
	public void setId_vaccine(int id_vaccine) {
		this.id_vaccine = id_vaccine;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRequired_doses() {
		return required_doses;
	}
	public void setRequired_doses(int required_doses) {
		this.required_doses = required_doses;
	}
}
