package com.app.mapper;

import org.dozer.Mapping;

public class EmpMapper {
	public EmpMapper() {
		// TODO Auto-generated constructor stub
	}
	public EmpMapper(Integer id, String lastName) {
		super();
		this.id = id;
		this.lastName = lastName;
	}

	@Mapping("id")
	private Integer id; 
	
	@Mapping("name")
	private String lastName; 
	
	
	


	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}




	
}
