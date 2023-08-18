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

import com.app.entity.Person;
import com.app.entity.Prescription;
import com.app.services.PersonService;
import com.app.services.PrescriptionService;

@RestController
@RequestMapping("/prescription")
public class PrescriptionController 
{
	@Autowired
	private PrescriptionService prescriptionservice;
	
	@GetMapping
	public List<Prescription> findAllPerson()
	{
		return prescriptionservice.getAllPrescription();
	}
	
	@PostMapping
	public String save(@RequestBody Prescription addprescription) {
		return prescriptionservice.addPrescription(addprescription);
	}
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable Long id) {
		return prescriptionservice.deletePrescription(id);
	}
	
	@PutMapping(value="/{id}")
	public Prescription updatePrescription(@RequestBody Prescription prescription,@PathVariable Long id) {
		System.out.println("Prescription is Updated");
		return prescriptionservice.updatePrescription(prescription, id);
	}

}
