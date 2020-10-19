package com.lawencon.hospital.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
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

import com.lawencon.hospital.entity.MedicalRecord;
import com.lawencon.hospital.repository.IMedicalRecord;

@Controller
@RestController
public class MedicalRecordController {

	@Autowired
	private IMedicalRecord medRec;
	
	@GetMapping(path="medrec/orderpatient/{name}")
	public ResponseEntity<?> orderMedRecPatienByDate(@PathVariable("name") String name){
		try {
			
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(this.medRec.orderMedRecByPatientAndDate(name));
	}
	
	@GetMapping(path="medrec/orderdoctor/{name}")
	public ResponseEntity<?> orderMedRecDoctorByDate(@PathVariable("name") String name){
		try {
			
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(this.medRec.orderMedRecByDocterAndDate(name));
	}
	
	@GetMapping(path="medrec/orderdate/{date}")
	public ResponseEntity<?> orderDate(@PathVariable("date") String date){
		Date date1 = null;
		try {
			date1=new SimpleDateFormat("yyyy-MM-dd").parse(date);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(this.medRec.orderDate(date1));
	}
	
	
	
	@GetMapping(path="medrec")
	public ResponseEntity<?> getAllMedRec(){
		try {
			
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(this.medRec.findAll());
	}
	
	@GetMapping(path="medrec/{id}")
	public ResponseEntity<?> findMedRecById(@PathVariable("id") Long id){
		try {
			
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(this.medRec.findById(id));
	}
	
	@PostMapping(path="medrec")
	public ResponseEntity<?> insertMedRec(@RequestBody MedicalRecord medRec) {	
		try {
			this.medRec.save(medRec);	
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(medRec);
	}
	
	@DeleteMapping(path="medrec/{id}")
	public ResponseEntity<?> deleteMedRec(@PathVariable("id") Long id) {
		Optional<MedicalRecord> medRec = null;
		try {
			medRec = this.medRec.findById(id);
			this.medRec.delete(medRec.get());	
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(medRec.get());
	}
	
	@PutMapping(path="medrec/{id}")
	public ResponseEntity<?> updateMedRec(@PathVariable("id") Long id, @RequestBody MedicalRecord mr) {
		Optional<MedicalRecord> medRec = null;
		try {
			medRec = this.medRec.findById(id);
			mr.setIdMedRec(medRec.get().getIdMedRec());
			this.medRec.save(mr);	
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(mr);
	}
}

