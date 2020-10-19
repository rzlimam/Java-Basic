package com.lawencon.hospital.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lawencon.hospital.entity.Room;

@Repository
public interface IRoom extends JpaRepository<Room, Long> {
	
	@Query("from Room r where r.roomName like %?1%")
	List<Room> searchRoomByName(String name);
	
	@Query("from Room r where r.roomType.roomTypeName like %?1%")
	List<Room> searchRoomByRoomTypeName(String name);
}
