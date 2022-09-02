package com.app.mapper;

import java.util.List;

public class EmployeesView {
	
	private List<DeptMapper> dept; 
	
	
	private EmpMapper emp; 
	
	
	
	private JobMapper job;



	public List<DeptMapper> getDept() {
		return dept;
	}



	public void setDept(List<DeptMapper> dept) {
		this.dept = dept;
	}



	public EmpMapper getEmp() {
		return emp;
	}



	public void setEmp(EmpMapper emp) {
		this.emp = emp;
	}



	public JobMapper getJob() {
		return job;
	}



	public void setJob(JobMapper job) {
		this.job = job;
	}
	

}
