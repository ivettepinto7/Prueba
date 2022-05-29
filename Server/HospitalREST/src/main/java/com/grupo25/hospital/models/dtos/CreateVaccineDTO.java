package com.grupo25.hospital.models.dtos;

public class CreateVaccineDTO {
	private String name;
	private int dosis_requeridas;
	private int frecuencia;
	public CreateVaccineDTO(String name, int dosis_requeridas, int frecuencia) {
		super();
		this.name = name;
		this.dosis_requeridas = dosis_requeridas;
		this.frecuencia = frecuencia;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
}
