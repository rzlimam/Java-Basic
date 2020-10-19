package com.lawencon.hospital.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lawencon.hospital.entity.RoomType;

@Repository
public interface IRoomType extends JpaRepository<RoomType, Long> {

	@Query("from RoomType rt where rt.roomTypeName like %?1%")
	List<RoomType> searchRoomTypeByName(String name);
}
