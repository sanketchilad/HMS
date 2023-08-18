package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.Patient;
import com.app.entity.Person;

public interface PatientDao extends JpaRepository<Patient, Long> 
{

}
