package com.app.dto;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AddPatientDto 
{

	@JsonProperty(access = Access.READ_ONLY) // used during serialization
	private Long id;
	
	private String first_name;
	
	private String last_name;
	
	
	private LocalDate date_of_birth;
	
	private String gender;
	private long contact;
	@Email
	private String email;
	
	
	@JsonProperty(access = Access.WRITE_ONLY)
	private String password;
	
	private String address;
	
	private String city;
	
	private String state;
	
	private String blood_group;
	
	//private String current_medication;

}
