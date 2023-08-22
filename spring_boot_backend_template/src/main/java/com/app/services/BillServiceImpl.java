package com.app.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.modelmapper.*;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dao.BillDao;
import com.app.dao.PatientDao;
import com.app.dao.PersonDao;
import com.app.dto.BillDto;
import com.app.entity.Bill;
import com.app.entity.Patient;
import com.app.entity.Person;



@Service
@Transactional
public class BillServiceImpl implements BillService 
{
	@Autowired
	private BillDao billdao;
	
	@Autowired
	private PatientDao patientdao;
	
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public List<Bill> getAllBills() 
	{	
		return billdao.findAll();
	}

//	@Override
//	public String addBill(Bill addbill) 
//	{
//		billdao.save(addbill);
//		return "bill is added";
//	}
//
//	@Override
//	public Bill updateBill(Bill bill, Long id) {
//		// TODO Auto-generated method stub
//		Bill bill2 = mapper.map(bill,Bill.class);
//		bill2.setId(id);
//		Bill bill3 = billdao.save(bill2);
//		return mapper.map(bill3, Bill.class);
//	}
	
//	@Override
//	public BillDto addNewBill(BillDto bill) {
//		// TODO Auto-generated method stub
//		Bill billentity = mapper.map(bill, Bill.class);
//		Bill persistentBill = billdao.save(billentity);
//		return mapper.map(persistentBill, BillDto.class);
//	}
	
	
	@Override
	public BillDto addNewBill(BillDto bill) {
		// TODO Auto-generated method stub
		
		Patient patient = patientdao.findById(bill.getPatient_id()).orElseThrow(() -> new ResourceNotFoundException("Invalid"));
		
		Bill billentity = mapper.map(bill, Bill.class);
		
		patient.addBills(billentity);
		Bill persistentBill = billdao.save(billentity);
		return mapper.map(persistentBill, BillDto.class);
	}
	
	@Override
	public List<BillDto> getAllBillsByPatient(Long patientId) {
		List<Bill> billList = billdao.findByPatientId(patientId);
		return billList.stream()
					.map(bill -> mapper.map(bill, BillDto.class))
					.collect(Collectors.toList());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
