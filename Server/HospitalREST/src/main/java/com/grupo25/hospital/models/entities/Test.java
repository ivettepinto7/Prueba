package com.grupo25.hospital.models.entities;

public class Test {
	private int id_test;
	private String name;
	private String gender;
	private int start_age;
	private int frequency;
	public Test(int id_test, String name, String gender, int start_age, int frequency) {
		super();
		this.id_test = id_test;
		this.name = name;
		this.gender = gender;
		this.start_age = start_age;
		this.frequency = frequency;
	}
	public int getId_test() {
		return id_test;
	}
	public void setId_test(int id_test) {
		this.id_test = id_test;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getStart_age() {
		return start_age;
	}
	public void setStart_age(int start_age) {
		this.start_age = start_age;
	}
	public int getFrequency() {
		return frequency;
	}
	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}
	
	
}
