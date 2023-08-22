package com.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.AppointmentDto;
import com.app.entity.Appointment;
import com.app.services.AppointmentService;

@RestController
public class AppointmentController {
	
	@Autowired
	private AppointmentService appointmentservice;
	
//	@PostMapping("/addappointment")
//	public String addAppointment(@RequestBody AppointmentDto addappointment)
//	{
//		return service.addAppointment(addappointment);
//	}
	
	
	@PostMapping
	public ResponseEntity<?> addAppointment(@RequestBody @Valid AppointmentDto addappointmentdto)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(appointmentservice.addAppointment(addappointmentdto)); 
	}

}
