package com.lawencon.hospital.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lawencon.hospital.entity.Patient;

@Repository
public interface IPatient extends JpaRepository<Patient, Long> {
	
	@Query("from Patient p where p.fullName like %?1%")
	List<Patient> searchPatientByName(String fullName);

}
