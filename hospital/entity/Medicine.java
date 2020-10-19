package com.lawencon.hospital.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "tbl_medicine",
uniqueConstraints = {@UniqueConstraint (columnNames = {"medicineCode"})})
public class Medicine implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idMedicine;
	
	private String medicineCode;
	private String medicineName;
	private String medicineUnit;
	private Integer medicineRate;
	
	public Medicine() {
		super();
	}

	public Long getIdMedicine() {
		return idMedicine;
	}

	public void setIdMedicine(Long idMedicine) {
		this.idMedicine = idMedicine;
	}

	public String getMedicineCode() {
		return medicineCode;
	}

	public void setMedicineCode(String medicineCode) {
		this.medicineCode = medicineCode;
	}

	public String getMedicineName() {
		return medicineName;
	}

	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}

	public String getMedicineUnit() {
		return medicineUnit;
	}

	public void setMedicineUnit(String medicineUnit) {
		this.medicineUnit = medicineUnit;
	}

	public Integer getMedicineRate() {
		return medicineRate;
	}

	public void setMedicineRate(Integer medicineRate) {
		this.medicineRate = medicineRate;
	}

	
}
