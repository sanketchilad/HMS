package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.Person;
import com.app.services.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController 
{
	@Autowired
	private PersonService personservice;
	
	@GetMapping
	public List<Person> findAllPerson()
	{
		return personservice.getAllPersons();
	}
	
	@PostMapping
	public String save(@RequestBody Person addperson) {
		return personservice.addPerson(addperson);
	}
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable Long id) {
		return personservice.deletePerson(id);
	}
	
	@PutMapping(value="/{id}")
	public Person updatePerson(@RequestBody Person person,@PathVariable Long id) {
		System.out.println("Person is Updated");
		return personservice.updatePerson(person, id);
	}

}
