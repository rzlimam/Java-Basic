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

import com.lawencon.hospital.entity.LabRate;
import com.lawencon.hospital.repository.ILabRate;

@Controller
@RestController
@CrossOrigin("*")
public class LabRateController {

	@Autowired
	private ILabRate labRate;
	
	@GetMapping(path="labrate")
	public ResponseEntity<?> getAllLabRate(){
		try {
			
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(this.labRate.findAll());
	}
	
	@GetMapping(path="labrate/{id}")
	public ResponseEntity<?> findLabRateById(@PathVariable("id") Long id){
		try {
			
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(this.labRate.findById(id));
	}
	
	@PostMapping(path="labrate")
	public ResponseEntity<?> insertLabRate(@RequestBody LabRate labRate) {
		try {
			this.labRate.save(labRate);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(labRate);
	}
	
	@DeleteMapping(path="labrate/{id}")
	public ResponseEntity<?> deleteLabRate(@PathVariable("id") Long id) {
		Optional<LabRate> labRate = null;
		try {
			labRate = this.labRate.findById(id);
			this.labRate.delete(labRate.get());
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(labRate.get());
	}
	
	@PutMapping(path="labrate/{id}")
	public ResponseEntity<?> updateLabRate(@PathVariable("id") Long id, @RequestBody LabRate lr) {
		Optional<LabRate> labRate = null;
		try {
			labRate = this.labRate.findById(id);
			lr.setIdLabRate(labRate.get().getIdLabRate());
			this.labRate.save(lr);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(lr);
	}
}
