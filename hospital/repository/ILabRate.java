package com.lawencon.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lawencon.hospital.entity.LabRate;

public interface ILabRate extends JpaRepository<LabRate, Long> {

}
