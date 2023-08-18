package com.app.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity 
@Table(name = "Appointments") 
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Appointment extends BaseEntity 
{
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name= "patient_id", nullable=false)
	private Patient patient;
	
	@ManyToOne(fetch= FetchType.LAZY)
	@JoinColumn(name= "doctor_id", nullable=false)
	private Doctor doctor;
	
	@Column(name="appointment_date")	
	private LocalDate date ;
	
	private int fees;
	
	
	
	//private Priscription p;
	
	
	
	
}
