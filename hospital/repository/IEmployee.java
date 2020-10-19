package com.lawencon.hospital.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lawencon.hospital.entity.Employee;

@Repository
public interface IEmployee extends JpaRepository<Employee, Long> {
	
	@Query("from Employee e where e.empName like %?1%")
	List<Employee> searchEmployeeByName(String empName);
	
	@Query("from Employee e where e.empType.empTypeName like %?1%")
	List<Employee> groupEmployeeByEmployeeType(String empType);
	
	@Query("from Employee e order by e.empType")
	List<Employee> orderEmployeeByEmpType();

}
