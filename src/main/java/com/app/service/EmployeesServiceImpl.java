package com.app.service;

import java.util.List;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.app.dao.EmployeesJpa;
import com.app.dao.JpaRepo;
import com.app.entity.Employees;
import com.app.mapper.EmpMapper;
import com.app.mapper.EmployeesView;
@Service
public class EmployeesServiceImpl  extends EmployeesService {

	@Autowired
	private JpaRepo jpaRepo;
	
	@Autowired
	private EmployeesJpa employeesJpa;
	
	private Mapper mapper = new DozerBeanMapper();
	
	
	@Override
	public EmployeesView findView() {
		// TODO Auto-generated method stub
		return this.jpaRepo.find();

//	return null;
	}

	public JpaRepo getJpaRepo() {
		return jpaRepo;
	}

	public void setJpaRepo(JpaRepo jpaRepo) {
		this.jpaRepo = jpaRepo;
	}

	@Override
	public EmpMapper findEmpl(Integer id) {
		// TODO Auto-generated method stub
		return  this.mapper.map(this.employeesJpa.findById(id).get(),EmpMapper.class);
	}

	public EmployeesJpa getEmployeesJpa() {
		return employeesJpa;
	}

	public void setEmployeesJpa(EmployeesJpa employeesJpa) {
		this.employeesJpa = employeesJpa;
	}

	public Mapper getMapper() {
		return mapper;
	}

	public void setMapper(Mapper mapper) {
		this.mapper = mapper;
	}

	@Override
	public EmpMapper getEmployees() {
		// TODO Auto-generated method stub
		
		
		return this.mapper.map(this.employeesJpa.getData(), EmpMapper.class);
		
		
//		return this.employeesJpa.getData();
	}

	@Override
	public List<Employees> findAll (int page,int slice) {
		// TODO Auto-generated method stub
		PageRequest pageable =PageRequest.of(page,slice);
		Page<Employees> findAll = this.employeesJpa.findAll(pageable);
		 return findAll.getContent();
//	return findAll;
//	return null;
	}

	@Override
	public Employees findById(int id) {
		// TODO Auto-generated method stub
		return this.employeesJpa.findById(id).get();
	}

}
