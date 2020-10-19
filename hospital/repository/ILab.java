package com.lawencon.hospital.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lawencon.hospital.entity.Lab;

@Repository
public interface ILab extends JpaRepository<Lab, Long> {
	
	@Query("from Lab l where l.labName like %?1%")
	List<Lab> searchLabByName(String name);

}
