package com.app.dto;

import java.time.LocalDate;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AuthResp {	
	private Long id;
	private String firstName;	
	private String lastName;	
	private LocalDate date_of_birth;
	private String gender;
	private String address;
	private String city;
	private String state;
	private String blood_group;
	private String qualafication;
	private int experience;
	private String license_no;
	private LocalDate joinDate;
	private double salary;	
}
