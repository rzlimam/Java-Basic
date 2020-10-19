package com.lawencon.hospital.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "tbl_employeetype",
uniqueConstraints = {@UniqueConstraint (columnNames = {"empTypeCode"})})
public class EmployeeType implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idEmpType;
	
	private String empTypeCode;
	private String empTypeName;
	private String description;
	@Column(nullable = true)
	private Integer masterId;
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getMasterId() {
		return masterId;
	}

	public void setMasterId(Integer masterId) {
		this.masterId = masterId;
	}
	
	public EmployeeType() {
		super();
	}

	public Long getIdEmpType() {
		return idEmpType;
	}

	public void setIdEmpType(Long idEmpType) {
		this.idEmpType = idEmpType;
	}

	public String getEmpTypeCode() {
		return empTypeCode;
	}

	public void setEmpTypeCode(String empTypeCode) {
		this.empTypeCode = empTypeCode;
	}

	public String getEmpTypeName() {
		return empTypeName;
	}

	public void setEmpTypeName(String empTypeName) {
		this.empTypeName = empTypeName;
	}

	
	

}
