package com.lawencon.hospital.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lawencon.hospital.entity.Supplier;

@Repository
public interface ISupplier extends JpaRepository<Supplier, Long> {

	@Query("from Supplier s where s.supplierName like %?1%")
	List<Supplier> searchSupplierByName(String name);
}
