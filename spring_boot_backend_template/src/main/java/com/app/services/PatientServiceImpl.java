package com.app.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.modelmapper.*;

import com.app.dao.PatientDao;
import com.app.dao.PersonDao;
import com.app.dto.AddPatientDto;
import com.app.entity.Patient;
import com.app.entity.Person;



@Service
@Transactional
public class PatientServiceImpl implements PatientService 
{
	@Autowired
	private PatientDao patientdao;
	
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public List<Patient> getAllPatients() {
		
		return patientdao.findAll();
	}

	@Override
	public String addPatient(AddPatientDto dto) {
		
		Patient patient = mapper.map(dto, Patient.class);
		patientdao.save(patient);
		return "added";
	}

	@Override
	public String deletePatient(Long id) {
		
		return "Patient is Deleted";
	}

	@Override
	public Patient updatePatient(Patient patient, Long id) {
		
		Patient patient2 = mapper.map(patient,Patient.class);
		patient2.setId(id);
		Patient patient3 = patientdao.save(patient2);
		return mapper.map(patient3, Patient.class);
	}

}
