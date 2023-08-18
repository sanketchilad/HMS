package com.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.modelmapper.*;

import com.app.dao.PersonDao;
import com.app.entity.Person;



@Service
@Transactional
public class PersonServiceImpl implements PersonService 
{
	@Autowired
	private PersonDao persondao;
	
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public List<Person> getAllPersons() {
		
		return persondao.findAll();
	}

	@Override
	public String addPerson(Person addperson) {
		// TODO Auto-generated method stub
		persondao.save(addperson);
		return "person is added";
	}

	@Override
	public String deletePerson(Long id) {
		// TODO Auto-generated method stub
		return "Person is Deleted";
	}

	@Override
	public Person updatePerson(Person person, Long id) {
		// TODO Auto-generated method stub
		Person person2 = mapper.map(person,Person.class);
		person2.setId(id);
		Person person3 = persondao.save(person2);
		return mapper.map(person3, Person.class);
	}

}
