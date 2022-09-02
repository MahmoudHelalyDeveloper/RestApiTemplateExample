package com.app.service;

import com.app.mapper.Person;
import com.app.mapper.Personne;

public interface PersonServices {

	
	public abstract Personne getPerson();
	
	
	public abstract Personne addPerson(Person person);
	
	
}
