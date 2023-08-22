package com.app.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="bill")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter


public class Bill extends BaseEntity

{
	@OneToOne(fetch= FetchType.LAZY)
	@JoinColumn(name= "patient_id", nullable=false)
	private Patient patient;
	
	@Column(name="date")
	private LocalDate date;
	
	@Column(name="total_amount")
	private long total_amount;
}
