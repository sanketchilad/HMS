package com.app.dto;

import java.time.LocalDate;


import javax.validation.constraints.Email;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class AddDoctorDTO {
	
	@JsonProperty(access = Access.READ_ONLY) // used during serialization
	private Long id;
	
	
	@NotBlank(message = "firstName can't be blank or null!!!")
	private String first_name;
	
	
	@Length(min = 3,max = 20,message = "inval len of last name")
	private String last_name;
	
	@Past(message = "invalid date")
	private LocalDate date_of_birth;
	
	private String gender;
	private long contact;
	
	
	@NotBlank(message = "Email can't be blank or null!!!")
	@Email(message = "Invalid email format !!!!")
	private String email;
	
	
	@JsonProperty(access = Access.WRITE_ONLY)
	@NotBlank(message = "Password required !!!!")
	private String password;
	
	
	@JsonProperty(access = Access.WRITE_ONLY)
	@NotBlank(message = "confirmation of Password required !!!!")
	private String confirmPassword;
	
	private String address;
	private String city;
	
	private String state;
	
	private String blood_group;
	private String qualafication;
	private int experience;


	private String current_medication;
	private String license_no;

	
	@FutureOrPresent(message = "invalid date")
	private LocalDate joinDate;
	
	@Min(value = 30000,message = "sal is <30000")
	@Max(value = 150000,message = "sal is >150000")
	private double salary;	
		
	private Long deptId;
	

	

	
	
	//non string me not null is compulsary other wise null pointer wxcep

}
