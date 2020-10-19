package com.lawencon.hospital.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lawencon.hospital.entity.Service;

@Repository
public interface IService extends JpaRepository<Service, Long> {
	
	@Query("from Service s where s.serviceName like %?1%")
	List<Service> searchServiceByName(String name);

}
