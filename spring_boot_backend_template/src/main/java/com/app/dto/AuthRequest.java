package com.app.dto;

import javax.validation.constraints.Email;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



//dto for validation and entity for persistence

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class AuthRequest {
	@NotBlank(message = "Email can't be blank or null!!!")
	@Email(message = "Invalid email format !!!!")
	private String email;
	
	
	//@Pattern(regexp = "((?=.*\\d)(?=.*[a-z])(?=.*[#@$*]).{5,20})", message = "Blank or invalid password !!!")
	private String password;
}
//string wle me not blank and non string me not null then other