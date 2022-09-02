package com.app.dao;

import org.springframework.stereotype.Service;

import com.app.mapper.Person;

@Service
public class PersonDao {

	
	public Person getPerson() {
		
		Person person = new Person(); 
		
		person.setAge(10);
		
		person.setName("Mahmoud");
		
		
		person.setSurName("Helaly");
		
		return person;
	}
	
	
	public Person addPerson(Person person) {
		
		person.setName("-------------------");
		person.setSurName("helaly sur name");
		return person;
	}
	
	
	
}
