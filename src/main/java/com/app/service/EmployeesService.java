package com.app.service;

import java.util.List;

import com.app.entity.Employees;
import com.app.mapper.EmpMapper;
import com.app.mapper.EmployeesView;

public abstract class EmployeesService {

	
	public abstract  EmployeesView findView ();
	
	
	public abstract EmpMapper findEmpl(Integer id);
	
	public abstract EmpMapper getEmployees();
	
	
	public abstract List<Employees> findAll(int page,int slice);
	
	
	public abstract Employees findById(int id);
	
}
