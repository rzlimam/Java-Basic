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

import com.lawencon.hospital.entity.Supplier;
import com.lawencon.hospital.repository.ISupplier;

@Controller
@RestController
public class SupplierController {

	@Autowired
	private ISupplier supplier;
	
	@GetMapping(path="supplier")
	public ResponseEntity<?> getAllSupplier(){
		try {
			
		}catch(Exception e) {
			return ResponseEntity. status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		return ResponseEntity. status(HttpStatus.OK).body(this.supplier.findAll());
	}
	
	@GetMapping(path="supplier/{id}")
	public ResponseEntity<?> findSupplierById(@PathVariable("id") Long id){
		try {
			
		}catch(Exception e) {
			return ResponseEntity. status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		return ResponseEntity. status(HttpStatus.OK).body(this.supplier.findById(id));
	}
	
	@GetMapping(path="supplier/search/{name}")
	public ResponseEntity<?> searchSupplierByName(@PathVariable("name") String name){
		try {
			
		}catch(Exception e) {
			return ResponseEntity. status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		return ResponseEntity. status(HttpStatus.OK).body(this.supplier.searchSupplierByName(name));
	}
	
	@PostMapping(path="supplier")
	public ResponseEntity<?> insertSupplier(@RequestBody Supplier supplier) {
		try {
			this.supplier.save(supplier);
		}catch(Exception e) {
			return ResponseEntity. status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		return ResponseEntity. status(HttpStatus.OK).body(supplier);
	}
	
	@DeleteMapping(path="supplier/{id}")
	public ResponseEntity<?> deleteSupplier(@PathVariable("id") Long id) {
		Optional<Supplier> supplier = null;
		try {
			supplier = this.supplier.findById(id);
			this.supplier.delete(supplier.get());
		}catch(Exception e) {
			return ResponseEntity. status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		return ResponseEntity. status(HttpStatus.OK).body(supplier.get());
	}
	
	@PutMapping(path="supplier/{id}")
	public ResponseEntity<?> updateSupplier(@PathVariable("id") Long id,@RequestBody Supplier s) {
		Optional<Supplier> supplier = null;
		try {
			supplier = this.supplier.findById(id);
			s.setIdSupplier(supplier.get().getIdSupplier());
			this.supplier.save(s);
		}catch(Exception e) {
			return ResponseEntity. status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		return ResponseEntity. status(HttpStatus.OK).body(s);
	}

}
