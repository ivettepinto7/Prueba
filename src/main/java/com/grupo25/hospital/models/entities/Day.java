package com.grupo25.hospital.models.entities;

public class Day {
	private int day;
	private String name;
	public Day(int day, String name) {
		super();
		this.day = day;
		this.name = name;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
