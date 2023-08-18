package com.app.services;

import org.springframework.web.bind.annotation.RequestBody;

import com.app.entity.Appointment;

public interface AppointmentService 
{
	public Appointment addAppointment(Appointment ap);

}
