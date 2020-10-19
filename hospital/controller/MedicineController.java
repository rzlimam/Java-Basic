package com.lawencon.hospital.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lawencon.hospital.entity.Medicine;
import com.lawencon.hospital.repository.IMedicine;

@Controller
@RestController
public class MedicineController {

	@Autowired
	private IMedicine medicine;
	
	@GetMapping(path="medicine")
	public ResponseEntity<?> getAllMedicine(){
		try {
			
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(this.medicine.findAll());
	}
	
	@GetMapping(path="medicine/{id}")
	public ResponseEntity<?> findMedicineById(@PathVariable("id") Long id){
		try {
			
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(this.medicine.findById(id));
	}
	
	@GetMapping(path="medicine/search/{name}")
	public ResponseEntity<?> searchMedicineByName(@PathVariable("name") String name) {
		try {
			
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(this.medicine.searchMedicineByName(name));
	}
	
	@PostMapping(path="medicine")
	public ResponseEntity<?> insertMedicine(@RequestBody Medicine medicine) {
		try {
			this.medicine.save(medicine);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(medicine);
		
		
	}
	
	@DeleteMapping(path="medicine/{id}")
	public ResponseEntity<?> deleteMedicine(@PathVariable("id") Long id) {
		Optional<Medicine> medicine = null;
		try {
			medicine = this.medicine.findById(id);
			this.medicine.delete(medicine.get());
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(medicine.get());
	}
	
	@PutMapping(path="medicine/{id}")
	public ResponseEntity<?> updateMedicine(@PathVariable("id") Long id, @RequestBody Medicine med) {
		Optional<Medicine> medicine = null;
		try {
			medicine = this.medicine.findById(id);
			med.setIdMedicine(medicine.get().getIdMedicine());
			this.medicine.save(med);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(med);
	}
}
