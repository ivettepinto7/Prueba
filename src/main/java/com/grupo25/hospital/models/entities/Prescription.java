package com.grupo25.hospital.models.entities;

public class Prescription {
	private int id_prescription;
	private int id_drug;
	private String idication;
	private float daily_amount;
	private int quantity;
	public Prescription(int id_prescription, int id_drug, String idication, float daily_amount, int quantity) {
		super();
		this.id_prescription = id_prescription;
		this.id_drug = id_drug;
		this.idication = idication;
		this.daily_amount = daily_amount;
		this.quantity = quantity;
	}
	public int getId_prescription() {
		return id_prescription;
	}
	public void setId_prescription(int id_prescription) {
		this.id_prescription = id_prescription;
	}
	public int getId_drug() {
		return id_drug;
	}
	public void setId_drug(int id_drug) {
		this.id_drug = id_drug;
	}
	public String getIdication() {
		return idication;
	}
	public void setIdication(String idication) {
		this.idication = idication;
	}
	public float getDaily_amount() {
		return daily_amount;
	}
	public void setDaily_amount(float daily_amount) {
		this.daily_amount = daily_amount;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
