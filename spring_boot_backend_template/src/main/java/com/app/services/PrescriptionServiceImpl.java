package com.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.modelmapper.*;

import com.app.dao.PersonDao;
import com.app.dao.PrescriptionDao;
import com.app.entity.Person;
import com.app.entity.Prescription;



@Service
@Transactional
public class PrescriptionServiceImpl implements PrescriptionService 
{
	@Autowired
	private PrescriptionDao prescriptiondao;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public List<Prescription> getAllPrescription() {
		// TODO Auto-generated method stub
		return prescriptiondao.findAll();
	}

	@Override
	public String addPrescription(Prescription addprescription) {
		// TODO Auto-generated method stub
		prescriptiondao.save(addprescription);
		return "Prescription is added";
	}

	@Override
	public String deletePrescription(Long id) {
		// TODO Auto-generated method stub
		return "Prescription is Deleted";
	}

	@Override
	public Prescription updatePrescription(Prescription prescription, Long id) {
		// TODO Auto-generated method stub
		Prescription prescription2 = mapper.map(prescription,Prescription.class);
		prescription2.setId(id);
		Prescription prescription3 = prescriptiondao.save(prescription2);
		return mapper.map(prescription3, Prescription.class);
	}

}
