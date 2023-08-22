package com.app.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DoctorRespDTO {

	private Long id;
	private String first_name;
	private String last_name;
	private long contact;
	private String address;
    private String city;
	
	private String state;
	private String current_medication;
	private String license_no;
	private LocalDate joinDate;
	private double salary;	


}
