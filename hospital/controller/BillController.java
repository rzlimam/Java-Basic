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

import com.lawencon.hospital.entity.Bill;
import com.lawencon.hospital.repository.IBill;

@Controller
@RestController
public class BillController {

	@Autowired
	private IBill bill;
	
	@GetMapping(path="bill")
	public ResponseEntity<?> getAllBill(){
		try {
			
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(this.bill.findAll());
	}
	
	@GetMapping(path="bill/{id}")
	public ResponseEntity<?> findBillById(@PathVariable("id") Long id){
		try {
			
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(this.bill.findById(id));
	}
	
//	@GetMapping(path="bill/search/{name}")
//	public ResponseEntity<?> searchBillByName(@PathVariable("name") String name){
//		try {
//			
//		}catch(Exception e) {
//			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
//		}
//		//return ResponseEntity.status(HttpStatus.OK).body(this.bill.searchUnitByName(name));
//	}
	
	@PostMapping(path="bill")
	public ResponseEntity<?> insertBill(@RequestBody Bill bill) {
		try {
			this.bill.save(bill);	
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(bill);
	}
	
	@DeleteMapping(path="bill/{id}")
	public ResponseEntity<?> deleteBill(@PathVariable("id") Long id) {
		Optional<Bill> bill = null;
		try {
			bill = this.bill.findById(id);
			this.bill.delete(bill.get());	
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(bill.get());
	}
	
	@PutMapping(path="bill/{id}")
	public ResponseEntity<?> updateBill(@PathVariable("id")Long id,  @RequestBody Bill b) {
		Optional<Bill> bill = null;
		try {
			bill = this.bill.findById(id);
			b.setIdBill(bill.get().getIdBill());
			this.bill.save(b);	
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(b);
	}
}
