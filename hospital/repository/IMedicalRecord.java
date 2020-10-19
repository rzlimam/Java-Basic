package com.lawencon.hospital.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lawencon.hospital.entity.MedicalRecord;

@Repository
public interface IMedicalRecord extends JpaRepository<MedicalRecord, Long> {
	
	@Query("from MedicalRecord mr where mr.patient.fullName like %?1% order by mr.medRecDate ")
	List<MedicalRecord> orderMedRecByPatientAndDate(String name);
	
	@Query("from MedicalRecord mr where mr.employee.empName like %?1% order by mr.medRecDate ")
	List<MedicalRecord> orderMedRecByDocterAndDate(String name);
	
	@Query("from MedicalRecord mr where mr.medRecDate = ?1")
	List<MedicalRecord> orderDate(Date date);
}
