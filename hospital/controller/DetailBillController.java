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

import com.lawencon.hospital.entity.DetailBill;
import com.lawencon.hospital.repository.IDetailBill;

@Controller
@RestController
public class DetailBillController {

	@Autowired
	private IDetailBill detailBill;
	
	@GetMapping(path="detailbill")
	public ResponseEntity<?> getAllDetailBill(){
		try {
			
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(this.detailBill.findAll());
	}
	
	@GetMapping(path="detailbill/{id}")
	public ResponseEntity<?> findDetailBillById(@PathVariable("id") Long id){
		try {
			
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(this.detailBill.findById(id));
	}
	
	@GetMapping(path="detailbill/searchbystatus/{name}")
	public ResponseEntity<?> searchPatientByStatus(@PathVariable("name") String name){
		try {
			
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage()); 
		}
		return ResponseEntity.status(HttpStatus.OK).body(this.detailBill.searcPatientByStatus(name));
	}
	
	@GetMapping(path="detailbill/searchbypatientname/{name}")
	public ResponseEntity<?> searchPatientByName(@PathVariable("name") String name){
		try {
			
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage()); 
		}
		return ResponseEntity.status(HttpStatus.OK).body(this.detailBill.searchPatientByName(name));
	}
	
//	@GetMapping(path="detailbill/searchbydoctorname/{name}")
//	public ResponseEntity<?> searchByDoctorName(@PathVariable("name") String name){
//		try {
//			
//		}catch(Exception e) {
//			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage()); 
//		}
//		return ResponseEntity.status(HttpStatus.OK).body(this.detailBill.searchByDocterName(name));
//	}
	
//	@GetMapping(path="bill/search/{name}")
//	public ResponseEntity<?> searchBillByName(@PathVariable("name") String name){
//		try {
//			
//		}catch(Exception e) {
//			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
//		}
//		//return ResponseEntity.status(HttpStatus.OK).body(this.bill.searchUnitByName(name));
//	}
	
	@PostMapping(path="detailbill")
	public ResponseEntity<?> insertDetaillBill(@RequestBody DetailBill bill) {
		try {
			this.detailBill.save(bill);	
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(bill);
	}
	
	@DeleteMapping(path="detailbill/{id}")
	public ResponseEntity<?> deleteDetaillBill(@PathVariable("id") Long id) {
		Optional<DetailBill> bill = null;
		try {
			bill = this.detailBill.findById(id);
			this.detailBill.delete(bill.get());	
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(bill.get());
	}
	
	@PutMapping(path="detailbill/{id}")
	public ResponseEntity<?> updateDetaillBill(@PathVariable("id")Long id,  @RequestBody DetailBill b) {
		Optional<DetailBill> bill = null;
		try {
			bill = this.detailBill.findById(id);
			b.setIdDetailBill(bill.get().getIdDetailBill());
			this.detailBill.save(b);	
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(b);
	}
	
	@GetMapping(path="detailbill/sumservice/{nobill}")
	public ResponseEntity<?> getSumUnitDoctor(@PathVariable("nobill") String noBill){
		try {
			
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(this.detailBill.getSumService(noBill));
	}
	
	@GetMapping(path="detailbill/sumlabrate/{nobill}")
	public ResponseEntity<?> getSumLabRate(@PathVariable("nobill") String noBill){
		try {
			
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(this.detailBill.getSumLabRate(noBill));
	}
	
	@GetMapping(path="detailbill/summedicine/{nobill}")
	public ResponseEntity<?> getSumMedicine(@PathVariable("nobill") String noBill){
		try {
			
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(this.detailBill.getSumMedicine(noBill));
	}
	
	@GetMapping(path="detailbill/sumroom/{nobill}")
	public ResponseEntity<?> getSumRoom(@PathVariable("nobill") String noBill){
		try {
			
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(this.detailBill.getSumRoom(noBill));
	}
	
	
//	@GetMapping(path="detailbill/sum/{nobill}")
//	public ResponseEntity<?> getSumBill(@PathVariable("nobill") String noBill){
//		try {
//			
//		}catch(Exception e) {
//			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
//		}
//		return ResponseEntity.status(HttpStatus.OK).body(this.detailBill.getSumBill(noBill));
//	}
}
