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

import com.lawencon.hospital.entity.Role;
import com.lawencon.hospital.repository.IRole;

@Controller
@RestController
public class RoleController {

	@Autowired
	private IRole role;
	
	@GetMapping(path="role")
	public ResponseEntity<?> getAllRole(){
		try {
			
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(this.role.findAll());
	}
	
	@GetMapping(path="role/{id}")
	public ResponseEntity<?> findRoleById(@PathVariable("id") Long id){
		try {
			
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(this.role.findById(id));
		
	}
	
	@GetMapping(path="role/search/{name}")
	public ResponseEntity<?> searchRoleByName(@PathVariable("name") String name){
		try {
			
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(this.role.searchRoleByName(name));
	}
	
	@PostMapping(path="role")
	public ResponseEntity<?> insertRole(@RequestBody Role role){
		try {
			this.role.save(role);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(role);
	}
	
	@DeleteMapping(path="role/{id}")
	public ResponseEntity<?> deleteRole(@PathVariable("id") Long id){
		Optional<Role> role = null;
		try {
			role = this.role.findById(id);
			this.role.delete(role.get());
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(e.getMessage());
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(role.get());
	}
	
	@PutMapping(path="role")
	public ResponseEntity<?> updateRole(@PathVariable("id") Long id, @RequestBody Role r){
		Optional<Role> role = null;
		try {
			role = this.role.findById(id);
			r.setIdRole(role.get().getIdRole());
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(r);
	}
}
