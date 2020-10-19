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

import com.lawencon.hospital.entity.RoomType;
import com.lawencon.hospital.repository.IRoomType;

@Controller
@RestController
@CrossOrigin("*")
public class RoomTypeController {

	@Autowired
	private IRoomType roomType;
	
	@GetMapping(path = "roomtype")
	public ResponseEntity<?> getAllRoomType(){
		try {
			
		}catch(Exception e) {
			return ResponseEntity. status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		return ResponseEntity. status(HttpStatus.OK).body(this.roomType.findAll());
	}
	
	@GetMapping(path = "roomtype/{id}")
	public ResponseEntity<?> findRoomTypeById(@PathVariable("id") Long id) {
		try {
			
		}catch(Exception e) {
			return ResponseEntity. status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		return ResponseEntity. status(HttpStatus.OK).body(this.roomType.findById(id));
	}
	
	@GetMapping(path = "roomtype/search/{name}")
	public ResponseEntity<?> searchRoomTypeByName(@PathVariable("name") String name){
		try {
			
		}catch(Exception e) {
			return ResponseEntity. status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		return ResponseEntity. status(HttpStatus.OK).body(this.roomType.searchRoomTypeByName(name));
	}
	
	@PostMapping(path = "roomtype")
	public ResponseEntity<?> insertRoomType(@RequestBody RoomType roomType) {
		try {
			this.roomType.save(roomType);	
		}catch(Exception e) {
			return ResponseEntity. status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		return ResponseEntity. status(HttpStatus.OK).body(roomType);
	}
	
	@DeleteMapping(path = "roomtype/{id}")
	public ResponseEntity<?> deleteRoomType(@PathVariable("id") Long id) {
		Optional<RoomType> roomType = null;
		try {
			roomType = this.roomType.findById(id);
			this.roomType.delete(roomType.get());	
		}catch(Exception e) {
			return ResponseEntity. status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		return ResponseEntity. status(HttpStatus.OK).body(roomType.get());
	}
	
	@PutMapping(path = "roomtype/{id}")
	public ResponseEntity<?> updateRoomType(@PathVariable("id") Long id, @RequestBody RoomType rt) {
		Optional<RoomType> roomType = null;
		try {
			roomType = this.roomType.findById(id);
			rt.setIdRoomType(roomType.get().getIdRoomType());
			this.roomType.save(rt);	
		}catch(Exception e) {
			return ResponseEntity. status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		return ResponseEntity. status(HttpStatus.OK).body(rt);
	}
}
