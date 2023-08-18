package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.AddPatientDto;
import com.app.entity.Patient;
import com.app.entity.Person;
import com.app.services.PatientService;
import com.app.services.PersonService;

@RestController
@RequestMapping("/patient")
public class PatientController 
{
	@Autowired
	private PatientService patientservice;
	
	@GetMapping
	public List<Patient> findAllPatient()
	{
		return patientservice.getAllPatients();
	}
	
	@PostMapping
	public String save(@RequestBody AddPatientDto addpatient) {
		return patientservice.addPatient(addpatient);
	}
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable Long id) {
		return patientservice.deletePatient(id);
	}
	
	@PutMapping(value="/{id}")
	public Patient updatePatient(@RequestBody Patient patient,@PathVariable Long id) {
		System.out.println("Patient is Updated");
		return patientservice.updatePatient(patient, id);
	}

}
