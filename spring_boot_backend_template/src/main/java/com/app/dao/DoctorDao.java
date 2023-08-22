package com.app.dao;

import java.util.List;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.Doctor;


public interface DoctorDao extends JpaRepository<Doctor, Long> 
{
	 List<Doctor> findByDeptId(Long deptId);
		Optional<Doctor> findByEmailAndPassword(String em,String pass);

}
