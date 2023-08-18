package com.app.services;

import java.util.List;

import com.app.entity.Person;

public interface PersonService 
{
	List<Person> getAllPersons();
	public String addPerson(Person addperson);
	public String deletePerson(Long id);
	
	Person updatePerson(Person person,Long id);
}
