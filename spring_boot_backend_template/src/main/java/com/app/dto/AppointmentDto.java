package com.app.dto;

import java.time.LocalDate;

import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString



public class AppointmentDto 
{
	//@JsonProperty(access = Access.READ_ONLY)
	private Long id;
	
	private long patient_id;
	
	private long doctor_id;
		
	private LocalDate date ;
	
	private int fees;
	

}
