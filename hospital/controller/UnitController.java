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

import com.lawencon.hospital.entity.Unit;
import com.lawencon.hospital.repository.IUnit;

@Controller
@RestController
@CrossOrigin("*")
public class UnitController {

	@Autowired
	private IUnit unit;
	
	@GetMapping(path = "unit")
	public ResponseEntity<?> getAllUnit(){
		try {
			
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(this.unit.findAll());
	}
	
	@GetMapping(path = "unit/{id}")
	public ResponseEntity<?> findUnitById(@PathVariable("id") Long id){
		try {
			
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(this.unit.findById(id));
	}
	
	@GetMapping(path="unit/search/{name}")
	public ResponseEntity<?> searchUnitByName(@PathVariable("name") String name){
		try {
			
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(this.unit.searchUnitByName(name));
	}
	
	@PostMapping(path="unit")
	public ResponseEntity<?> insertUnit(@RequestBody Unit unit) {
		try {
			this.unit.save(unit);	
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(unit);
	}
	
	@DeleteMapping(path="unit/{id}")
	public ResponseEntity<?> deleteUnit(@PathVariable("id") Long id) {
		Optional<Unit> unit = null;
		try {
			unit = this.unit.findById(id);
			this.unit.delete(unit.get());	
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(unit.get());
	}
	
	@PutMapping(path="unit/{id}")
	public ResponseEntity<?> updateUnit(@PathVariable("id")Long id,  @RequestBody Unit u) {
		Optional<Unit> unit = null;
		try {
			unit = this.unit.findById(id);
			u.setIdUnit(unit.get().getIdUnit());
			this.unit.save(u);	
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(u);
	}
}
