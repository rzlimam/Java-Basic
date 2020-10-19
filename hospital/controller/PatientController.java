package com.lawencon.hospital.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lawencon.hospital.entity.Patient;
import com.lawencon.hospital.repository.IPatient;


@Controller
@RestController
@CrossOrigin("*")
public class PatientController {

	@Autowired
	private IPatient patient;
	
	@RequestMapping(path = "patient", method = RequestMethod.POST)
	public ResponseEntity<?> addPatient(@RequestBody Patient pas) {
		try {
			patient.save(pas);	
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(pas);
	}
	
	@RequestMapping(path = "patient", method = RequestMethod.GET)
	public ResponseEntity<?> getAllPatient(){
		try {
			
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(this.patient.findAll());
	}
	
	@GetMapping(path = "patient/search/{name}")
	public ResponseEntity<?> searchPatientByName(@PathVariable("name") String name){
		try {
			
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(this.patient.searchPatientByName(name));
	}
	
	@RequestMapping(path = "patient/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deletePatient(@PathVariable("id") Long id) {
		Optional<Patient> pas = null;
		try {
			pas = this.patient.findById(id);
			this.patient.delete(pas.get());	
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(pas.get());
	}
	
	@RequestMapping(path = "patient/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updatePatient(@PathVariable("id") Long id, @RequestBody Patient p) {
		Optional<Patient> pas = null;
		try {
			pas = this.patient.findById(id);
			p.setIdPatient(pas.get().getIdPatient());
			this.patient.save(p);	
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(p);
	}
	
	@RequestMapping(path = "patient/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> findPatientById(@PathVariable("id") Long id){
		try {
			
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(this.patient.findById(id));
	}
}
