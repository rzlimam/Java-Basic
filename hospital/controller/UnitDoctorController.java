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

import com.lawencon.hospital.entity.UnitDoctor;
import com.lawencon.hospital.repository.IUnitDoctor;

@Controller
@RestController
@CrossOrigin("*")
public class UnitDoctorController {
	
	@Autowired
	private IUnitDoctor unitDoctor;
	
	@GetMapping(path="unitdoctor")
	public ResponseEntity<?> getAllUnitDoctor(){
		try {
			
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(this.unitDoctor.findAll());
	}
	
	@GetMapping(path="unitdoctor/{id}")
	public ResponseEntity<?> findUnitDoctorById(@PathVariable("id") Long id){
		try {
			
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(this.unitDoctor.findById(id));
	}
	
	@PostMapping(path="unitdoctor")
	public ResponseEntity<?> insertUnitDoctor(@RequestBody UnitDoctor unitDoctor) {
		try {
			this.unitDoctor.save(unitDoctor);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(unitDoctor);
	}
	
	@DeleteMapping(path="unitdoctor/{id}")
	public ResponseEntity<?> deleteUnitDoctor(@PathVariable("id") Long id) {
		Optional<UnitDoctor> unitDoctor = null;
		try {
			unitDoctor = this.unitDoctor.findById(id);
			this.unitDoctor.delete(unitDoctor.get());
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(unitDoctor.get());
	}
	
	@PutMapping(path="unitdoctor/{id}")
	public ResponseEntity<?> updateUnitDoctor(@PathVariable("id") Long id, @RequestBody UnitDoctor ud) {
		Optional<UnitDoctor> unitDoctor = null;
		try {
			unitDoctor = this.unitDoctor.findById(id);
			ud.setIdUnitDoctor(unitDoctor.get().getIdUnitDoctor());
			this.unitDoctor.save(ud);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(ud);
	}

}
