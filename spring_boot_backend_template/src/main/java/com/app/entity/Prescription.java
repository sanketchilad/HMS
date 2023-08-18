package com.app.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="prescription")
//@NoArgsConstructor
//@AllArgsConstructor
@Getter
@Setter

public class Prescription extends BaseEntity
{
	@Column(name="medicines")
	private String medicines;
	
	@Column(name="remark")
	private String remark;

}
