package com.grupo25.hospital.models.dtos;

public class EditDrugDTO {
	private int code;
	private String nombre;
	private String laboratorio; 
	private String activo;
	private float porcentaje_activo;
	
	public EditDrugDTO(int code, String nombre, String laboratorio, String activo, float porcentaje_activo) {
		super();
		this.code = code;
		this.nombre = nombre;
		this.laboratorio = laboratorio;
		this.activo = activo;
		this.porcentaje_activo = porcentaje_activo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getLaboratorio() {
		return laboratorio;
	}
	public void setLaboratorio(String laboratorio) {
		this.laboratorio = laboratorio;
	}
	public String getActivo() {
		return activo;
	}
	public void setActivo(String activo) {
		this.activo = activo;
	}
	public float getPorcentaje_activo() {
		return porcentaje_activo;
	}
	public void setPorcentaje_activo(float porcentaje_activo) {
		this.porcentaje_activo = porcentaje_activo;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
}
