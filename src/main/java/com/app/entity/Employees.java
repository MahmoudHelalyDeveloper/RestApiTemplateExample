package com.app.entity;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;

import org.hibernate.annotations.NamedQueries;

import com.app.mapper.EmpMapper;

@Entity
@Table(name="employees")

@NamedNativeQuery( name = "Employees.getData",query = "select e.employee_id as id, e.last_name as surName  from Employees e where e.employee_id=102 ",resultSetMapping    ="Mapping.EmpMapper" )
@SqlResultSetMapping(classes = @ConstructorResult(targetClass = EmpMapper.class,columns = {@ColumnResult( name =  "surName"),@ColumnResult( name =  "id")}), name = "Mapping.EmpMapper" )
public class Employees {

	@Id
	@Column(name="employee_id")
	private int id; 
	
	
	@Column(name="first_name")

	private String name; 
	
	
	@Column(name="last_name")
	private String surName;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


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
	
	
	
}
