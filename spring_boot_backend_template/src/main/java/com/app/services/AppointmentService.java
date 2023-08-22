package com.app.services;

import org.springframework.web.bind.annotation.RequestBody;

import com.app.dto.AppointmentDto;
import com.app.entity.Appointment;

public interface AppointmentService 
{
	public AppointmentDto addAppointment(AppointmentDto addappointment);

}
