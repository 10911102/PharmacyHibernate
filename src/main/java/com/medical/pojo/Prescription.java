package com.medical.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Prescription {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int	id;
	private int medicine_id;
	private int Quantity;
	private int Doctor_id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMedicine_id() {
		return medicine_id;
	}
	public void setMedicine_id(int medicine_id) {
		this.medicine_id = medicine_id;
	}
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
	public int getDoctor_id() {
		return Doctor_id;
	}
	public void setDoctor_id(int doctor_id) {
		Doctor_id = doctor_id;
	}
	@Override
	public String toString() {
		return "Prescription [id=" + id + ", medicine_id=" + medicine_id + ", Quantity=" + Quantity + ", Doctor_id="
				+ Doctor_id + "]";
	}

}
