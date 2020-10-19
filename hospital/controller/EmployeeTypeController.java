package com.lawencon.hospital.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lawencon.hospital.entity.EmployeeType;
import com.lawencon.hospital.repository.IEmployeeType;

@Controller
@RestController
@CrossOrigin("*")
public class EmployeeTypeController {

	@Autowired
	private IEmployeeType empType;
	
	//Get all employe
	@GetMapping (path = "emptype")
	public ResponseEntity<?> getAllEmployeeType(){
		try {
			
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(this.empType.findAll());
	}
	
	@GetMapping(path = "emptype/findall")
	public ResponseEntity<?> getAllEmployeOrderByMaster(){
		try {
			
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(this.empType.findAllAndOrderByMaster());
	}
	
	//find Employee By Id
	@GetMapping (path = "emptype/{id}")
	public ResponseEntity<?> findEmployeeTypeById(@PathVariable("id") Long id){
		try {
			
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(this.empType.findById(id));
	}
	
	//search employee type by name
	@GetMapping (path = "emptype/search/{name}")
	public ResponseEntity<?> searchEmployeeType(@PathVariable("name") String name){
		try {
			
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(this.empType.searchEmpTypeByName(name));
	}
	
	//insert employee type
	@PostMapping (path = "emptype")
	public ResponseEntity<?> insertEmpType(@RequestBody EmployeeType empType) {
		try {
			this.empType.save(empType);	
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(empType);
	}
	
	//delete employee type
	@DeleteMapping (path = "emptype/{id}")
	public ResponseEntity<?> deleteEmpType(@PathVariable("id") Long id) {
		Optional<EmployeeType> empType = null;
		try {
			empType = this.empType.findById(id);
			this.empType.delete(empType.get());	
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(empType.get());
	}
	
//	@PutMapping (path = "emptype/{idEmpType}")
//	public @ResponseBody EmployeeType updateEmpType(@PathVariable("idEmpType") Long id, @RequestBody EmployeeType empType) {
//		Optional<EmployeeType> empTypes = this.empType.findById(id);
//		empType.setIdEmpType(empTypes.get().getIdEmpType());
//		this.empType.save(empTypes.get());
//		return empType;
//	}
	
	//update emplayee
	@PutMapping(path = "emptype/{id}")
	public ResponseEntity<?> updateEmpType(@PathVariable("id") Long id, @RequestBody EmployeeType et) {
		Optional<EmployeeType> empType = null;
		try {
			empType = this.empType.findById(id);
			et.setIdEmpType(empType.get().getIdEmpType());
			this.empType.save(et);	
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(et);
	}
	
}
