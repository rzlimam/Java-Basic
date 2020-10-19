package com.lawencon.hospital.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lawencon.hospital.entity.Employee;
import com.lawencon.hospital.repository.IEmployee;

@Controller
@RestController
@CrossOrigin("*")
public class EmployeeController {

	@Autowired
	private IEmployee emp;
	
	@GetMapping(path = "employee/orderempby")
	public ResponseEntity<?> orderEmployeeByEmpType(){
		try {
			
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(this.emp.orderEmployeeByEmpType());
	}
	
	@GetMapping(path = "employee")
	public ResponseEntity<?> getAllEmployee() {
		try {
		
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(this.emp.findAll());
	}
	
	@GetMapping(path = "employee/{id}")
	public ResponseEntity<?> findEmployeeById(@PathVariable("id") Long id){
		try {
			
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(this.emp.findById(id));
	}
	
//	@PostMapping(path = "employee/{idEmpType}")
//	public @ResponseBody Employee addEmployee(@PathVariable("idEmpType") Long id, @RequestBody Employee emp) {
//		EmployeeType empType = new EmployeeType();
//		empType.setIdEmpType(id);
//		emp.setEmpType(empType);
//		this.emp.save(emp);
//		return emp;
//	}
	
	@PostMapping(path = "employee")
	public ResponseEntity<?> addEmployee(@RequestBody Employee emp) {
		try {
			this.emp.save(emp);	
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
			//return null;
			
		}
		//return emp;
		return ResponseEntity.status(HttpStatus.CREATED).body(emp);
	}
	
	@DeleteMapping(path = "employee/{id}")
	public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id) {
		Optional<Employee> emp = null;
		try {
			emp = this.emp.findById(id);
			this.emp.delete(emp.get());	
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(emp.get());
		
		
	}
	
	@PutMapping(path = "employee/{id}")
	public ResponseEntity<?> updateEmployee(@PathVariable("id")Long id, @RequestBody Employee employee) {
		Optional<Employee> emp = null;
		try {
			emp = this.emp.findById(id);
			employee.setIdEmp(emp.get().getIdEmp());
			this.emp.save(employee);	
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(employee);
	}
	
	@GetMapping(path = "employee/search/{name}")
	public @ResponseBody List<Employee> searchEmployeeByName(@PathVariable("name") String name){
		return this.emp.searchEmployeeByName(name);
	}
	
	
	@GetMapping(path = "employee/searchbytype/{name}")
	public @ResponseBody List<Employee> groupEmployeeByEmployeeType(@PathVariable("name") String name){
		return this.emp.groupEmployeeByEmployeeType(name);
	}
	
}
