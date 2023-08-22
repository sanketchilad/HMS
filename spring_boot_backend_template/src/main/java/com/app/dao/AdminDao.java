package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.Admin;
import com.app.entity.Person;

public interface AdminDao extends JpaRepository<Admin, Long> 
{

}
