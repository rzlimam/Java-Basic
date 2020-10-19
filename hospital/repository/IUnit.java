package com.lawencon.hospital.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lawencon.hospital.entity.Unit;

@Repository
public interface IUnit extends JpaRepository<Unit, Long> {

	@Query("from Unit u where u.unitName like %?1%")
	List<Unit> searchUnitByName(String name);
}
