package com.app.controller;

import java.io.IOException;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.app.dto.AddDoctorDTO;
import com.app.dto.ApiResponse;
import com.app.dto.AuthRequest;
import com.app.dto.DoctorRespDTO;
import com.app.services.DoctorService;
import com.app.services.ImageHandlingService;
import static org.springframework.http.MediaType.*;


@RestController
@RequestMapping("/doctor")
public class DoctorController {

	@Autowired
	private DoctorService doctorService;
	
	@Autowired
	private ImageHandlingService imgService;
	
	
	@PostMapping
	public ResponseEntity<?> addDocToExistingDept(@RequestBody @Valid AddDoctorDTO dto) {
		System.out.println(dto.toString());
		System.out.println("in add doc " + dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(doctorService.addNewDoctor(dto));
	}
	
	
	// 2. Get all emps by dept id
	// http://host:port/employees/departments/{deptId} , method=GET
	@GetMapping("/departments/{deptId}")
	public ResponseEntity<?> getDocsByDepartment(@PathVariable Long deptId) {
		System.out.println("in get doc " + deptId);
		List<DoctorRespDTO> list = doctorService.getAllDoctorFromDept(deptId);
		if (list.isEmpty())
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		// emps found
		return ResponseEntity.ok(list);
	}
	
	@PostMapping("/signIn")
	public ResponseEntity<?> authenticateDoc(@RequestBody @Valid AuthRequest request) {
		System.out.println("in sign in " + request);
	//	try {
			return new ResponseEntity<>(doctorService.authenticateEmp(request), 
					HttpStatus.OK);
//		} catch (RuntimeException e) {
//			System.out.println(e);
//			return ResponseEntity.status
//					(HttpStatus.NOT_FOUND).
//					body(new ApiResponse(e.getMessage()));
//		}
	}
	
	@DeleteMapping("/{docId}")
	// @PathVariable : method arg level anno , for binding URI template var to req
	// handling method arg.
	public ApiResponse deleteDocDetails(@PathVariable Long docId) {
		System.out.println("in del doc " + docId);
		return doctorService.deleteDocDetails(docId);
	}
	
	@PutMapping
	public ResponseEntity<?>  updateDocDetails(@PathVariable Long docId,@RequestBody AddDoctorDTO detachedDoc) {
		System.out.println("in update doc " + detachedDoc.getId());// not null
		// validate
		doctorService.getDocDetails(detachedDoc.getDeptId(),detachedDoc.getId());
		// => emp exists by the id --> continue to update
		return new ResponseEntity<>(doctorService.updateDoctor(docId,detachedDoc), 
				HttpStatus.OK);
	}
	@PostMapping(value = "/images/{docId}", consumes = "multipart/form-data")
	public ResponseEntity<?> uploadImage(@PathVariable Long docId, @RequestParam MultipartFile imageFile)
			throws IOException {
		System.out.println("in upload img " + docId);
		return ResponseEntity.status(HttpStatus.CREATED).body(imgService.uploadImage(docId, imageFile));
	}

	// 5 . serve(download image) of specific emp
	// http://host:port/employees/images/{empId} , method=GET
	@GetMapping(value="/images/{docId}",produces = {IMAGE_GIF_VALUE,
			IMAGE_JPEG_VALUE,IMAGE_PNG_VALUE})
	public ResponseEntity<?> serveDocImage(@PathVariable Long docId) throws IOException {
		System.out.println("in download img " + docId);
		return ResponseEntity.ok(imgService.downloadImage(docId));
	}
}
