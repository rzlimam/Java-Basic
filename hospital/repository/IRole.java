package com.lawencon.hospital.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lawencon.hospital.entity.Role;

@Repository
public interface IRole extends JpaRepository<Role, Long> {
	
	@Query("from Role r where r.roleName like %?1%")
	List<Role> searchRoleByName(String name);

}
