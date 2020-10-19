package com.lawencon.hospital.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lawencon.hospital.entity.EmployeeType;

@Repository
public interface IEmployeeType extends JpaRepository<EmployeeType, Long> {
	
	@Query("from EmployeeType et where et.empTypeName like %?1% order by et.masterId")
	List<EmployeeType> searchEmpTypeByName(String empTypeName);
	
	@Query("from EmployeeType et order by et.masterId")
	List<EmployeeType> findAllAndOrderByMaster();
	

}
