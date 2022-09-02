package com.app.service;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
//import org.dozer.DozerBeanMapper;
//import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.PersonDao;
import com.app.mapper.Person;
import com.app.mapper.Personne;

@Service
public class PersonServiceImpl  implements PersonServices {

	@Autowired
	private PersonDao personDao;
	
	
	Mapper map = new DozerBeanMapper();
	
	@Override
	public Personne getPerson() {
		// TODO Auto-generated method stub
	return	map.map(this.personDao.getPerson(), Personne.class);
//	return null;
	}

	public PersonDao getPersonDao() {
		return personDao;
	}

	public void setPersonDao(PersonDao personDao) {
		this.personDao = personDao;
	}

	@Override
	public Personne addPerson(Person person) {
		// TODO Auto-generated method stub
		
		
		return map.map(this.personDao.addPerson(person), Personne.class);
	}

	
}
