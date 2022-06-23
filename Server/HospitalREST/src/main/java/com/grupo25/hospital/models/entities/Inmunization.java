package com.grupo25.hospital.models.entities;

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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "inmunization")
public class Inmunization {
	
	@Id
	@Column(name = "id_inmunization")
	@SequenceGenerator(name = "inmunization_id_inmunization_gen", sequenceName = "inmunization_id_inmunization_gen", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "inmunization_id_inmunization_gen")
	private Long id_inmunization;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_vaccine")
	private Vaccine id_vaccine;
	
	@Column(name="age")
	private Integer age;
	
	@Column(name="gender")
	private Character gender;
	
	@OneToMany(mappedBy = "id_inmunization", fetch = FetchType.LAZY, cascade = CascadeType.MERGE )
	@JsonIgnore
	private List<Appointment> appointments;
	
	

	public Inmunization(Vaccine id_vaccine, Integer age, Character gender) {
		super();
		this.id_vaccine = id_vaccine;
		this.age = age;
		this.gender = gender;
	}

	public Inmunization() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId_inmunization() {
		return id_inmunization;
	}

	public void setId_inmunization(Long id_inmunization) {
		this.id_inmunization = id_inmunization;
	}

	public Vaccine getId_vaccine() {
		return id_vaccine;
	}

	public void setId_vaccine(Vaccine id_vaccine) {
		this.id_vaccine = id_vaccine;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Character getGender() {
		return gender;
	}

	public void setGender(Character gender) {
		this.gender = gender;
	}

	
	
	
	
}
