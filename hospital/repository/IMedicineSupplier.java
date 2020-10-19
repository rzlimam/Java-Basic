package com.lawencon.hospital.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lawencon.hospital.entity.MedicineSupplier;

@Repository
public interface IMedicineSupplier extends JpaRepository<MedicineSupplier, Long> {
	
	@Query("from MedicineSupplier ms where ms.supplier.supplierName like %?1%")
	List<MedicineSupplier> searchBySupplier(String name);
	
	@Query("from MedicineSupplier ms where ms.medicine.medicineName like %?1%")
	List<MedicineSupplier> searchByMedicine(String name);
}
