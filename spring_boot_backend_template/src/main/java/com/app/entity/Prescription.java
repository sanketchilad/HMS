package com.app.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
