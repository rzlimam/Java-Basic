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

import com.lawencon.hospital.entity.User;
import com.lawencon.hospital.repository.IUser;

@Controller
@RestController
public class UserController {

	@Autowired
	private IUser user;
	
	@GetMapping(path="user")
	public ResponseEntity<?> getAllUser(){
		try {
			
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(this.user.findAll());
	}
	
	@GetMapping(path="user/{id}")
	public ResponseEntity<?> findUserById(@PathVariable("id") Long id){
		try {
			
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(this.user.findById(id));
		
	}
	
	@GetMapping(path="user/search/{username}")
	public ResponseEntity<?> searchRoleByName(@PathVariable("username") String username){
		try {
			
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(this.user.searchUserByUsername(username));
	}
	
	@PostMapping(path="user")
	public ResponseEntity<?> insertUser(@RequestBody User user){
		try {
			this.user.save(user);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(user);
	}
	
	@DeleteMapping(path="user/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable("id") Long id){
		Optional<User> user = null;
		try {
			user = this.user.findById(id);
			this.user.delete(user.get());
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(e.getMessage());
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(user.get());
	}
	
	@PutMapping(path="user")
	public ResponseEntity<?> updateUser(@PathVariable("id") Long id, @RequestBody User u){
		Optional<User> user = null;
		try {
			user = this.user.findById(id);
			u.setIdUser(user.get().getIdUser());
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(u);
	}
}
