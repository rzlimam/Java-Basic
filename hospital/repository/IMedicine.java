package com.lawencon.hospital.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lawencon.hospital.entity.Medicine;

@Repository
public interface IMedicine extends JpaRepository<Medicine, Long> {
	
	@Query("from Medicine m where m.medicineName like %?1%")
	List<Medicine> searchMedicineByName(String name);

}
