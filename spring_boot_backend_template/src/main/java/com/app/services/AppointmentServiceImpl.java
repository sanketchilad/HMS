package com.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.AppointmentDao;
import com.app.entity.Appointment;

@Service
@Transactional
public class AppointmentServiceImpl implements AppointmentService
{
	@Autowired
	private AppointmentDao dao;
	
	public Appointment addAppointment(Appointment ap) {
		return dao.save(ap);
	}

}
