package com.lawencon.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lawencon.hospital.entity.UnitDoctor;

@Repository
public interface IUnitDoctor extends JpaRepository<UnitDoctor, Long> {

}
