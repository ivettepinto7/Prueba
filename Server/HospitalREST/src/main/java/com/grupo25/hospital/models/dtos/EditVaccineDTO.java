package com.grupo25.hospital.models.dtos;

public class EditVaccineDTO {
	private int code;
	private String nombre;
	private int dosis_requeridas;
	private int frecuencia;
	
	public EditVaccineDTO(int code, String nombre, int dosis_requeridas, int frecuencia) {
		super();
		this.code = code;
		this.nombre = nombre;
		this.dosis_requeridas = dosis_requeridas;
		this.frecuencia = frecuencia;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getDosis_requeridas() {
		return dosis_requeridas;
	}
	public void setDosis_requeridas(int dosis_requeridas) {
		this.dosis_requeridas = dosis_requeridas;
	}
	public int getFrecuencia() {
		return frecuencia;
	}
	public void setFrecuencia(int frecuencia) {
		this.frecuencia = frecuencia;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	
}
