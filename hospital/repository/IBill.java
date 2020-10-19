package com.lawencon.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lawencon.hospital.entity.Bill;

@Repository
public interface IBill extends JpaRepository<Bill, Long> {

}
