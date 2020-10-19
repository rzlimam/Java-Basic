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

import com.lawencon.hospital.entity.Lab;
import com.lawencon.hospital.repository.ILab;

@Controller
@RestController
@CrossOrigin("*")
public class LabController {

	@Autowired
	private ILab lab;
	
	@GetMapping(path="lab")
	public ResponseEntity<?> getAllLab(){
		try {
			
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(this.lab.findAll());
	}
	
	@GetMapping(path="lab/{id}")
	public ResponseEntity<?> findLabById(@PathVariable("id") Long id){
		try {
			
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(this.lab.findById(id));
	}
	
	@GetMapping(path="lab/search/{name}")
	public ResponseEntity<?> searchLabByName(@PathVariable("name") String name){
		try {
			
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(this.lab.searchLabByName(name));
		
	}
	
	@PostMapping(path="lab")
	public ResponseEntity<?> insertLab(@RequestBody Lab lab) {
		try {
			this.lab.save(lab);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(lab);
	}
	
	@DeleteMapping(path="lab/{id}")
	public ResponseEntity<?> deleteLab(@PathVariable("id") Long id) {
		Optional<Lab> lab = null;
		try {
			lab = this.lab.findById(id);
			this.lab.delete(lab.get());
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(lab.get());
	}
	
	@PutMapping(path="lab/{id}")
	public ResponseEntity<?> updateLab(@PathVariable("id") Long id, @RequestBody Lab l) {
		Optional<Lab> lab = null;
		try {
			lab = this.lab.findById(id);
			l.setIdLab(lab.get().getIdLab());
			this.lab.save(l);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(l);
	}
}
