package com.grupo25.hospital.models.entities;

import java.time.LocalDate;

public class Shift {
	private int id_shift;
	private int id_doctor;
	private int id_day;
	private LocalDate start_hour;
	private LocalDate finish_hour;
	public Shift(int id_shift, int id_doctor, int id_day, LocalDate start_hour, LocalDate finish_hour) {
		super();
		this.id_shift = id_shift;
		this.id_doctor = id_doctor;
		this.id_day = id_day;
		this.start_hour = start_hour;
		this.finish_hour = finish_hour;
	}
	public int getId_shift() {
		return id_shift;
	}
	public void setId_shift(int id_shift) {
		this.id_shift = id_shift;
	}
	public int getId_doctor() {
		return id_doctor;
	}
	public void setId_doctor(int id_doctor) {
		this.id_doctor = id_doctor;
	}
	public int getId_day() {
		return id_day;
	}
	public void setId_day(int id_day) {
		this.id_day = id_day;
	}
	public LocalDate getStart_hour() {
		return start_hour;
	}
	public void setStart_hour(LocalDate start_hour) {
		this.start_hour = start_hour;
	}
	public LocalDate getFinish_hour() {
		return finish_hour;
	}
	public void setFinish_hour(LocalDate finish_hour) {
		this.finish_hour = finish_hour;
	}
	
}	
