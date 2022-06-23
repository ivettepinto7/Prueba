package com.grupo25.hospital.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity(name = "vaccine")
public class Vaccine {
	
	@Id
	@Column(name = "id_vaccine")
	@SequenceGenerator(name = "vaccine_id_vaccine_gen", sequenceName = "vaccine_id_vaccine_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vaccine_id_vaccine_gen")
	private Long id_vaccine;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "required_doses")
	private Integer required_doses;

	public Vaccine() {
		super();
	}

	public Vaccine(Long id_vaccine, String name, Integer required_doses) {
		super();
		this.id_vaccine = id_vaccine;
		this.name = name;
		this.required_doses = required_doses;
	}

	public Long getId_vaccine() {
		return id_vaccine;
	}

	public void setId_vaccine(Long id_vaccine) {
		this.id_vaccine = id_vaccine;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getRequired_doses() {
		return required_doses;
	}

	public void setRequired_doses(Integer required_doses) {
		this.required_doses = required_doses;
	}
	
	
}
