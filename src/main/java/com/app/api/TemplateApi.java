package com.app.api;

import java.util.ArrayList;

import javax.websocket.server.PathParam;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.Employees;
import com.app.mapper.EmpMapper;
import com.app.mapper.EmployeesView;
import com.app.mapper.Items;
import com.app.mapper.Person;
import com.app.mapper.Personne;
import com.app.service.EmployeesService;
import com.app.service.PersonServices;

@RestController
public class TemplateApi {
@Autowired
	private PersonServices PersonServices;

@Autowired
private EmployeesService employeesService;


private Mapper mapper = new DozerBeanMapper() ;
	
	
	@RequestMapping("/getname")
	public Items getName() {
		Items i = new Items(); 
		i.setId(1)
		;
		i.setName("pen");
		i.setPrice(500);
		
		return i;
	}
	
	
	@RequestMapping("/findall")
	public ArrayList<Items> findAll() {
		
		ArrayList<Items> array = new ArrayList<Items>();
		
		Items i = new Items(); 
		i.setId(1)
		;
		i.setName("pen");
		i.setPrice(500);
		array.add(i);
		i.setId(2)
		;
		i.setName("paper");
		i.setPrice(100);
		array.add(i);
		return array;
	}
	
	@RequestMapping("/filter")
	public String findByOne( @RequestParam("id") String name) {
		
		
		return "Helaly"+name;
	}
	
	@PostMapping("/additems")
	public Items addItem(@RequestBody Items items) {
		
		
		return items;
	}
	
	
	
	@PutMapping("/updateitems")
	public Items updateItem(@RequestBody Items items) {
		
		
		return items;
	}

	@DeleteMapping("/deleteitem")
	public void removeItem() {
		
		
	}
	@RequestMapping("/getperson")
	public Personne getPerson () {
		
		return  this.PersonServices.getPerson();
		
	}
@PostMapping("/addperson")
	public Personne addPerson( @RequestBody Personne person) {
		
	
		return this.PersonServices.addPerson(this.mapper.map(person, Person.class));
	}


@RequestMapping("/findView")
public EmployeesView findView() {
	
	return  this.employeesService.findView();
//return null;	
}

	
@RequestMapping("/getEmployees")
public EmpMapper findByOne(@RequestParam("id")  int employeeId) {
	EmpMapper findEmpl = this.employeesService.findEmpl(employeeId);
	
	System.err.println("findEmpl is "+findEmpl);
	
	return findEmpl;
	
}

@RequestMapping("/customemployee")
public EmpMapper getCustomEmp() {
	
return	this.employeesService.getEmployees();
	
}


	public PersonServices getPersonServices() {
		return PersonServices;
	}


	public void setPersonServices(PersonServices personServices) {
		PersonServices = personServices;
	}


	public Mapper getMapper() {
		return mapper;
	}


	public void setMapper(Mapper mapper) {
		this.mapper = mapper;
	}


	public EmployeesService getEmployeesService() {
		return employeesService;
	}


	public void setEmployeesService(EmployeesService employeesService) {
		this.employeesService = employeesService;
	}
	
}
