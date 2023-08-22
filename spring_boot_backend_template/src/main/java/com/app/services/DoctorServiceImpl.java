package com.app.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.modelmapper.*;

import com.app.custom_exceptions.ApiException;
import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dao.DepartmentDao;
import com.app.dao.DoctorDao;
import com.app.dao.PersonDao;
import com.app.dao.PrescriptionDao;
import com.app.dto.AddDoctorDTO;
import com.app.dto.ApiResponse;
import com.app.dto.AuthRequest;
import com.app.dto.AuthResp;
import com.app.dto.DoctorRespDTO;
import com.app.entity.Department;
import com.app.entity.Doctor;
import com.app.entity.Person;
import com.app.entity.Prescription;



@Service
@Transactional
public class DoctorServiceImpl implements DoctorService 
{

	@Autowired
	private DoctorDao doctorDao;

	@Autowired
	private DepartmentDao deptDao;

	@Autowired
	private ModelMapper mapper;
	
	@Override
	public DoctorRespDTO getDocDetails(Long deptId, Long docId) {
		Doctor doctor = doctorDao.findById(docId)
				.orElseThrow(() -> new ResourceNotFoundException("Invalid Emp ID!!!"));
		if (doctor.getDept().getId() != deptId)
			throw new ResourceNotFoundException("Dept id does not match !!!");
		return mapper.map(doctor, DoctorRespDTO.class);
	}

	@Override
	public  DoctorRespDTO addNewDoctor(AddDoctorDTO dto) {

		if (dto.getConfirmPassword().equals(dto.getPassword())) {
			Department dept = deptDao.findById(dto.getDeptId()).orElseThrow(
					() -> new ResourceNotFoundException("Invalid Dept id !!!"));
			  
			
			Doctor doctor = mapper.map(dto, Doctor.class);
			dept.addDoctor(doctor);//cascade on save
			
			return mapper.map(doctorDao.save(doctor), DoctorRespDTO.class);
		} else
			throw new ApiException("Passwords don't match!!!!!");

	}

	@Override
	public List<DoctorRespDTO> getAllDoctorFromDept(Long deptId) {
		List<Doctor> empList = doctorDao.findByDeptId(deptId);
		return empList.stream() //Stream<Emp>
				.map(doc -> mapper.map(doc, DoctorRespDTO.class)) //Stream<DTO>
				.collect(Collectors.toList());
	}
	
	@Override
	public DoctorRespDTO updateDoctor(Long docId, AddDoctorDTO dto) {
		// validate if emp exists by id
		Doctor doc = doctorDao.findById(docId)
				.orElseThrow(() -> new ResourceNotFoundException("Invalid doc ID , Doc not found !!!!"));
		// => emp exists
		// validate confirm password
		if (dto.getPassword().equals(dto.getConfirmPassword())) {
			Department dept = deptDao.findById(dto.getDeptId())
					.orElseThrow(() -> new ResourceNotFoundException("Invalid Dept Id!!!"));
			// dto contains the updates , so apply it --> to entity
			mapper.map(dto, doc);// but after this id : null
			doc.setId(docId);// so setting it again
			// System.out.println("after mapping " + emp);
			dept.addDoctor(doc);
			return mapper.map(doc, DoctorRespDTO.class);
		}
		throw new ApiException("Passwords don't match");

	}
	@Override
	public ApiResponse deleteDocDetails(Long docId) {
//		// checking if adr is assigned for this emp , using emp id (=adr id : since
//		// @MapsId)
//		Optional<Address> optionalAdr = adrRepo.findById(empId);
//		if (optionalAdr.isPresent()) // child rec : adr exists ,so first delete that
//			adrRepo.delete(optionalAdr.get());
//		// what is the relationship between Emp n Project ?
//		// Employee *<--------->* Project : both are parents , child : join table
//		// (project_emps)
//		// You will have to delete those links in the join table , for the emp assigned
//		// to the project first n then delete parent emp record
		Doctor doc = doctorDao.findById(docId).orElseThrow(() -> new ResourceNotFoundException("Invalid emp id"));

//		Iterator<Project> projectItr = doc.getProjects().iterator();
//		while (projectItr.hasNext())
//			projectItr.next().getEmps().remove(emp);
//		doctorDao.delete(doc);
		return new ApiResponse("emp details deleted !");
	}
	
	@Override
	public AuthResp authenticateEmp(AuthRequest request) {
		// autheticate emp
		Doctor doc=doctorDao.
				findByEmailAndPassword(request.getEmail(), request.getPassword())
				.orElseThrow(() -> new ResourceNotFoundException("Invalid Email or Password !!!!!"));
		//=> valid login --> map Entity --> DTO
		//ModelMapper API : public T map(Object src , Class<T> class)
		//only matching will get map call geter of emp map with authresp setter
		return mapper.map(doc, AuthResp.class);
	}
}
