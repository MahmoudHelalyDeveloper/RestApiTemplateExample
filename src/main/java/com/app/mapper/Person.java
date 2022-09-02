package com.app.mapper;

import org.dozer.Mapping;

public class Person {
	@Mapping("nom")
	private String name; 
	@Mapping("surNom")
	private String surName; 
//	
	@Mapping("age")
	private int age; 
	
	private boolean active;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurName() {
		return surName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	} 
	
	
	

}
