//package com.app.entity;
//
//
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.persistence.CascadeType;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.EnumType;
//import javax.persistence.Enumerated;
//import javax.persistence.FetchType;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToMany;
//import javax.persistence.ManyToOne;
//import javax.persistence.Table;
//
//import org.springframework.format.annotation.DateTimeFormat;
//
//import lombok.EqualsAndHashCode;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import lombok.ToString;
//
//@Entity 
//@Table(name = "Nurses") 
//@NoArgsConstructor
//@Getter
//@Setter
//@ToString(exclude = {"dept","projects"})
//@EqualsAndHashCode(callSuper = false, doNotUseGetters = true,of = "email")
//public class Nurse extends Person {
//	
//	
//	
//	@Enumerated(EnumType.STRING) // col : varchar => enum constant name
//	@Column(length = 30)
//	private SpecType specialization;
//	
//	
//	@Column(length = 30)
//	private String qualafication;
//	
//	
//	
//	private int experience;
//	
//
//	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.MERGE)//MERGE : NEW n INTERESTING !!!!!
//	@JoinColumn(name = "department_id") // Optional BUT reco , to specify the name of FK col.
//	private Department dept;
//	
//	
//	@DateTimeFormat(pattern = "yyyy-MM-dd")
//	private LocalDate joinDate;
//
//	//@Lob // large object :col : longblob
//	//private byte[] image;
//	private String imagePath;
//	
//	
//	private double salary;
//	// many to one association
//	
//	
////	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.MERGE)//MERGE : NEW n INTERESTING !!!!!
////	@JoinColumn(name = "department_id") // Optional BUT reco , to specify the name of FK col.
////	private Department dept;
//	
//	
//	//@ManyToMany(mappedBy = "emps")
//	//private List<Project> patient = new ArrayList<>();
//	
//	
//	
//	/*
//	 one to one association Employee ----> AdharCard
//	@Embedded // OPTIONAL
//	private AdhaarCard card;
//	// Employee HAS-A skills (string)
//	@ElementCollection // mandatory
//	@CollectionTable(name = "emp_skills", joinColumns = @JoinColumn(name = "emp_id"))
//	@Column(name = "skill_name", length = 20)
//	private List<String> skills = new ArrayList<>();
//	// one to many association between Employee 1--->* PaymentCard
//	@ElementCollection
//	@CollectionTable(name = "emp_payment_cards", 
//	joinColumns = @JoinColumn(name = "emp_id"))
//	private List<PaymentCard> cards = new ArrayList<>();
//	
//	*/
//
//
//
//}
