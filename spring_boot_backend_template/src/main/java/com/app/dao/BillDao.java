package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.Bill;
import com.app.entity.Person;

public interface BillDao extends JpaRepository<Bill, Long> 
{
	List<Bill> findByPatientId(Long patientId);
}
