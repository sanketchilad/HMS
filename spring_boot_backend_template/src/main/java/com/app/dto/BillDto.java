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
public class BillDto 
{

	@JsonProperty(access = Access.READ_ONLY) // used during serialization
	private Long id;
	
	private long patient_id;
	
	private String first_name;
	
	private String last_name;
	
	
	private LocalDate date;
	
	private long total_amount;
	
	
}
