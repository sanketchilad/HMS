package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.Person;
import com.app.entity.Prescription;

public interface PrescriptionDao extends JpaRepository<Prescription, Long> 
{

}
