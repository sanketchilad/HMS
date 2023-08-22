package com.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.AddPatientDto;
import com.app.dto.BillDto;
import com.app.entity.Bill;
import com.app.entity.Patient;
import com.app.entity.Person;
import com.app.services.BillService;
import com.app.services.PatientService;
import com.app.services.PersonService;

@RestController
@RequestMapping("/bill")
public class BillController 
{
	@Autowired
	private BillService billservice;
	
	@GetMapping
	public List<Bill> findAllPatient()
	{
		return billservice.getAllBills();
	}
	
//	@PostMapping
//	public String save(@RequestBody AddPatientDto addpatient) {
//		return patientservice.addPatient(addpatient);
//	}
//	
//	@DeleteMapping("/{id}")
//	public String delete(@PathVariable Long id) {
//		return patientservice.deletePatient(id);
//	}
//	
//	@PutMapping(value="/{id}")
//	public Patient updatePatient(@RequestBody Patient patient,@PathVariable Long id) {
//		System.out.println("Patient is Updated");
//		return patientservice.updatePatient(patient, id);
//	}
//
	@PostMapping
	public ResponseEntity<?> addNewBill(@RequestBody @Valid BillDto bill){
		System.out.println("in add new bill : "+bill);
		return ResponseEntity.status(HttpStatus.CREATED).body(billservice.addNewBill(bill));
	}
	
//	@PostMapping(value="{billId}", consumes = "multipart/form-data")
//	public ResponseEntity<?> addNewBill(@PathVariable Long billId){
//		System.out.println("in add new bill : "+billId);
//		return ResponseEntity.status(HttpStatus.CREATED).body(billservice.addNewBill(billId));
//	}
	
	
	@GetMapping("/patient/{patientId}")
	public ResponseEntity<?> getBillByPatient(@PathVariable Long patientId)
	{
		System.out.println("in get bill" + patientId);
		List<BillDto> list = billservice.getAllBillsByPatient(patientId);
		if(list.isEmpty())
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		
		return ResponseEntity.ok(list);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
