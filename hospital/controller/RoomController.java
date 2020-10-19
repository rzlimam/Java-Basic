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

import com.lawencon.hospital.entity.Room;
import com.lawencon.hospital.repository.IRoom;

@Controller
@RestController
@CrossOrigin("*")
public class RoomController {

	@Autowired
	private IRoom room;
	
	@GetMapping(path="room")
	public ResponseEntity<?> getAllRoom(){
		try {
			
		}catch(Exception e) {
			return ResponseEntity. status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		return ResponseEntity. status(HttpStatus.OK).body(this.room.findAll());
	}
	
	@GetMapping(path="room/{id}")
	public ResponseEntity<?> findRoomById(@PathVariable("id") Long id){
		try {
			
		}catch(Exception e) {
			return ResponseEntity. status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(this.room.findById(id));
	}
	
	@GetMapping(path="room/search/{name}")
	public ResponseEntity<?> searchRoomByName(@PathVariable("name") String name){
		try {
			
		}catch(Exception e) {
			return ResponseEntity. status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(this.room.searchRoomByName(name));
	}
	
	@GetMapping(path="room/searchbytype/{name}")
	public ResponseEntity<?> searchRoomByRoomTypeName(@PathVariable("name") String name){
		try {
			
		}catch(Exception e) {
			return ResponseEntity. status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(this.room.searchRoomByRoomTypeName(name));
	}
	
	@PostMapping(path="room")
	public ResponseEntity<?> insertRoom(@RequestBody Room room) {
		try {
			this.room.save(room);	
		}catch(Exception e) {
			return ResponseEntity. status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(room);
	}
	
	@DeleteMapping(path="room/{id}")
	public ResponseEntity<?> deleteRoom(@PathVariable("id") Long id) {
		Optional<Room> room = null;
		try {
			 room = this.room.findById(id);
			this.room.delete(room.get());	
		}catch(Exception e) {
			return ResponseEntity. status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(room.get());
	}
	
	@PutMapping(path = "room/{id}")
	public ResponseEntity<?> updateRoom(@PathVariable("id") Long id, @RequestBody Room r) {
		Optional<Room> room = null;
		try {
			room = this.room.findById(id);
			r.setIdRoom(room.get().getIdRoom());
			this.room.save(r);	
		}catch(Exception e) {
			return ResponseEntity. status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(r);
	}
}
