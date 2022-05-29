package com.grupo25.hospital.models.dtos;

public class CreateAreaDTO {
	private String nombre;
	private String genero;
	private int edad_inicial;
	private int frecuencia_visita;
	public CreateAreaDTO(String nombre, String genero, int edad_inicial, int frecuencia_visita) {
		super();
		this.nombre = nombre;
		this.genero = genero;
		this.edad_inicial = edad_inicial;
		this.frecuencia_visita = frecuencia_visita;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public int getEdad_inicial() {
		return edad_inicial;
	}
	public void setEdad_inicial(int edad_inicial) {
		this.edad_inicial = edad_inicial;
	}
	public int getFrecuencia_visita() {
		return frecuencia_visita;
	}
	public void setFrecuencia_visita(int frecuencia_visita) {
		this.frecuencia_visita = frecuencia_visita;
	}
	
	
}
