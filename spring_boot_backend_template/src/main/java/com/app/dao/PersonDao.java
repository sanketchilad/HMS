package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.Person;

public interface PersonDao extends JpaRepository<Person, Long> 
{

}
