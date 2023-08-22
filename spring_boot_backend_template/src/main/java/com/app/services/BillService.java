package com.app.services;

import java.util.List;

import com.app.dto.BillDto;
import com.app.entity.Bill;
import com.app.entity.Person;

public interface BillService 
{
	List<Bill> getAllBills();
	
	List<BillDto> getAllBillsByPatient(Long patientId);
	
//	public String addBill(Bill addbill);	
//	Bill updateBill(Bill bill,Long id);

	BillDto addNewBill(BillDto bill);
	
	
}
