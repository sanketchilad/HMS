package com.app.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.RequestBody;

import com.app.dto.AddDoctorDTO;
import com.app.dto.ApiResponse;
import com.app.dto.AuthRequest;
import com.app.dto.AuthResp;
import com.app.dto.DoctorRespDTO;
import com.app.entity.Appointment;
import com.app.entity.Doctor;

public interface DoctorService 
{

	public DoctorRespDTO getDocDetails(Long deptId, Long docId);
	  DoctorRespDTO addNewDoctor(AddDoctorDTO dto);
	  public DoctorRespDTO updateDoctor(Long docId, AddDoctorDTO dto);
	  public ApiResponse deleteDocDetails(Long docId);
	  List<DoctorRespDTO> getAllDoctorFromDept(Long deptId);
	  public AuthResp authenticateEmp(AuthRequest request);
}
