package com.app.services;

import java.util.List;

import com.app.entity.Person;
import com.app.entity.Prescription;

public interface PrescriptionService 
{
	List<Prescription> getAllPrescription();
	public String addPrescription(Prescription addprescription);
	public String deletePrescription(Long id);
	
	Prescription updatePrescription(Prescription prescription,Long id);
}
