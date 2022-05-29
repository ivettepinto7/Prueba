package com.grupo25.hospital.models.dtos;

import java.time.LocalDate;

public class CreateUserDTO {
	private String nombre;
	private String apellido;
	private String correo;
	private String Genero;
	private String pass;
	private String rol;
	private LocalDate fechaDeNacimiento;
	public CreateUserDTO(String nombre, String apellido, String correo, String genero, String pass, String rol,
			LocalDate fechaDeNacimiento) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		Genero = genero;
		this.pass = pass;
		this.rol = rol;
		this.fechaDeNacimiento = fechaDeNacimiento;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getGenero() {
		return Genero;
	}
	public void setGenero(String genero) {
		Genero = genero;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}
	public LocalDate getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}
	public void setFechaDeNacimiento(LocalDate fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}
	
}
