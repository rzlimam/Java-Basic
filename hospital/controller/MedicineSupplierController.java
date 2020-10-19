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

import com.lawencon.hospital.entity.MedicineSupplier;
import com.lawencon.hospital.repository.IMedicineSupplier;

@Controller
@RestController
public class MedicineSupplierController {

	@Autowired
	private IMedicineSupplier medSup;
	
	@GetMapping(path="medsup")
	public ResponseEntity<?> getAllMedSup(){
		try {
			
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(this.medSup.findAll());
	}
	
	@GetMapping(path="medsup/searchbysup/{name}")
	public ResponseEntity<?> searchBySupplier(@PathVariable("name") String name){
		try {
			
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(this.medSup.searchBySupplier(name));
	}
	
	@GetMapping(path="medsup/searchbymed/{name}")
	public ResponseEntity<?> searchByMedicine(@PathVariable("name") String name){
		try {
			
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(this.medSup.searchByMedicine(name));
	}
	
	@GetMapping(path="medsup/{id}")
	public ResponseEntity<?> findMedSupById(@PathVariable("id") Long id){
		try {
			
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body( this.medSup.findById(id));
	}
	
	@PostMapping(path="medsup")
	public ResponseEntity<?> insertMedSup(@RequestBody MedicineSupplier medSup) {
		try {
			this.medSup.save(medSup);	
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(medSup);
	}
	
	@DeleteMapping(path="medsup/{id}")
	public ResponseEntity<?> deleteMedSup(@PathVariable("id") Long id) {
		Optional<MedicineSupplier> medSup = null;
		try {
			medSup = this.medSup.findById(id);
			this.medSup.delete(medSup.get());	
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(medSup.get());
	}
	
	@PutMapping(path="medsup/{id}")
	public ResponseEntity<?> updateMedSup(@PathVariable("id") Long id, @RequestBody MedicineSupplier ms) {
		Optional<MedicineSupplier> medSup = null;
		try {
			medSup = this.medSup.findById(id);
			ms.setIdMedicineSupplier(medSup.get().getIdMedicineSupplier());
			this.medSup.save(ms);	
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(ms);
	}
}
