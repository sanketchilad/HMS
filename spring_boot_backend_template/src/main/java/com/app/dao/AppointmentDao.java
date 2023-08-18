package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.Appointment;
import com.app.entity.Patient;
import com.app.entity.Person;

public interface AppointmentDao extends JpaRepository<Appointment, Long> 
{

}
