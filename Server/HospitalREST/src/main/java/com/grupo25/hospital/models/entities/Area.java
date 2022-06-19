package com.grupo25.hospital.models.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity(name = "area")
public class Area {
	@Id
	@Column(name = "id_area")
	@SequenceGenerator(name = "area_id_area_gen", sequenceName = "area_id_area_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "area_id_area_gen")
	private Long id_area;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "gender")
	private Character gender;
	
	@Column(name = "start_age")
	private Integer start_age;
	
	@Column(name = "frequency")
	private Integer frequency;
	
	@OneToMany(mappedBy = "id_area", fetch = FetchType.LAZY, cascade = CascadeType.ALL )
	private List<Person> people;

	public Area() {
		super();
	}

	public Area(String name, Character gender, Integer start_age, Integer frequency) {
		super();
		this.name = name;
		this.gender = gender;
		this.start_age = start_age;
		this.frequency = frequency;
	}

	public Long getId_area() {
		return id_area;
	}

	public void setId_area(Long id_area) {
		this.id_area = id_area;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Character getGender() {
		return gender;
	}

	public void setGender(Character gender) {
		this.gender = gender;
	}

	public Integer getStart_age() {
		return start_age;
	}

	public void setStart_age(Integer start_age) {
		this.start_age = start_age;
	}

	public int getFrequency() {
		return frequency;
	}

	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}

	public List<Person> getPeople() {
		return people;
	}

	public void setPeople(List<Person> people) {
		this.people = people;
	}
	
	
}
