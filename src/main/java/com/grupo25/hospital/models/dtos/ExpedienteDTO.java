package com.grupo25.hospital.models.dtos;

import java.time.LocalDate;

public class ExpedienteDTO {
	private LocalDate fecha;
	private String tipo;
	private String detallesCita;
	
	public ExpedienteDTO(LocalDate fecha, String tipo, String detallesCita) {
		super();
		this.fecha = fecha;
		this.tipo = tipo;
		this.detallesCita = detallesCita;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getDetallesCita() {
		return detallesCita;
	}
	public void setDetallesCita(String detallesCita) {
		this.detallesCita = detallesCita;
	}
}
