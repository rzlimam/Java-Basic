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

import com.lawencon.hospital.entity.Service;
import com.lawencon.hospital.repository.IService;

@Controller
@RestController
@CrossOrigin("*")
public class ServiceController {

	@Autowired
	private IService service;
	
	@GetMapping(path="service")
	public ResponseEntity<?> getAllService(){
		try {
			
		}catch(Exception e) {
			return ResponseEntity. status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		return ResponseEntity. status(HttpStatus.OK).body(this.service.findAll());
	}
	
	@GetMapping(path="service/{id}")
	public ResponseEntity<?> findServiceById(@PathVariable("id") Long id){
		try {
			
		}catch(Exception e) {
			return ResponseEntity. status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		return ResponseEntity. status(HttpStatus.OK).body(this.service.findById(id));
	}
	
	@GetMapping(path="service/search/{name}")
	public ResponseEntity<?> searchServiceByName(@PathVariable("name") String name){
		try {
			
		}catch(Exception e) {
			return ResponseEntity. status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		return ResponseEntity. status(HttpStatus.OK).body(this.service.searchServiceByName(name));
	}
	
	@PostMapping(path="service")
	public ResponseEntity<?> insertService(@RequestBody Service service) {
		try {
			this.service.save(service);	
		}catch(Exception e) {
			return ResponseEntity. status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		return ResponseEntity. status(HttpStatus.OK).body(service);
	}
	
	@DeleteMapping(path="service/{id}")
	public ResponseEntity<?> deleteService(@PathVariable("id") Long id) {
		Optional<Service> service = null;
		try {
			service = this.service.findById(id);
			this.service.delete(service.get());	
		}catch(Exception e) {
			return ResponseEntity. status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(service.get());
	}
	
	@PutMapping(path="service/{id}")
	public ResponseEntity<?> updateService(@PathVariable("id") Long id, @RequestBody Service s) {
		Optional<Service> service = null;
		try {
			service = this.service.findById(id);
			s.setIdService(service.get().getIdService());
			this.service.save(s);	
		}catch(Exception e) {
			return ResponseEntity. status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		return ResponseEntity. status(HttpStatus.OK).body(s);
	}
}
