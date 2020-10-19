package com.lawencon.hospital.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lawencon.hospital.entity.User;

@Repository
public interface IUser extends JpaRepository<User, Long> {

	@Query("from User u where u.username like %?1%")
	List<User> searchUserByUsername(String username);
}
