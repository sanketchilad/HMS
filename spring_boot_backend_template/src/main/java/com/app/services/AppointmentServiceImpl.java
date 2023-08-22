package com.app.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dao.AppointmentDao;
import com.app.dao.DoctorDao;
import com.app.dao.PatientDao;
import com.app.dto.AppointmentDto;
import com.app.entity.Appointment;
import com.app.entity.Doctor;
import com.app.entity.Patient;

@Service
@Transactional
public class AppointmentServiceImpl implements AppointmentService
{
	@Autowired
	private AppointmentDao appointmentdao;
	
	@Autowired
	private PatientDao patientdao;
	
	@Autowired
	private DoctorDao doctordao;
	
	
	
	@Autowired
	private ModelMapper mapper;
	
	public AppointmentDto addAppointment(AppointmentDto addappointment) {
		System.out.println(addappointment);
		
		Appointment a = new Appointment();
		
		a.setFees(50);
		
		Patient patient = patientdao.findById(addappointment.getPatient_id()).orElseThrow(() -> new ResourceNotFoundException("Invalid"));
		
		Doctor doctor = doctordao.findById(addappointment.getDoctor_id()).orElseThrow(() -> new ResourceNotFoundException("Invalid"));
		
		Appointment appointment = mapper.map(addappointment,Appointment.class);
		//appointment.setPatient(patient);
		
		patient.addAppointment(appointment);
		doctor.addAppointment(appointment);
		
		
		//appointmentdao.save(a);
		//System.out.println(appointment);
		//System.out.println("appointment checkpoint");
		
		return mapper.map(appointmentdao.save(appointment),AppointmentDto.class);
				//return "appointment added";
	}

}
