package com.lawencon.hospital.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lawencon.hospital.entity.DetailBill;

@Repository
public interface IDetailBill extends JpaRepository<DetailBill, Long> {

	@Query("from DetailBill db where db.bill.status like %?1%")
	List<DetailBill> searcPatientByStatus(String name);
	
	@Query("from DetailBill db where db.bill.patient.fullName like %?1% order by db.startDate")
	List<DetailBill> searchPatientByName(String name);
	
//	@Query("from DetailBill db where db.unitDoctor.employee.empName like %?1%")
//	List<DetailBill> searchByDocterName(String name);
	
	@Query("select sum(db.service.serviceRate) from DetailBill db where db.bill.noBill = ?1")
	Integer getSumService(String noBill);
	
	@Query("select sum(db.labRate.labRate) from DetailBill db where db.bill.noBill = ?1")
	Integer getSumLabRate(String noBill);
	
	@Query("select sum(db.medicine.medicineRate) from DetailBill db where db.bill.noBill = ?1")
	Integer getSumMedicine(String noBill);
	
	@Query("select sum(db.room.roomType.roomTypeRate) from DetailBill db where db.bill.noBill = ?1")
	Integer getSumRoom(String noBill);
	
//	@Query("select (sum(db.unitDoctor.service.serviceRate) + sum(db.labRate.labRate) + sum(db.medicine.medicineRate) + sum(db.room.roomType.roomTypeRate)) from DetailBill db where db.bill.noBill = ?1")
//	Integer getSumBill(String noBill);
}

