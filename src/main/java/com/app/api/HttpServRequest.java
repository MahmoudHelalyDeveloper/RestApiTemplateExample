package com.app.api;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.Employees;
import com.app.mapper.LocationMapper;
import com.app.mapper.EmpMapper;
import com.app.mapper.LocationMapper;
import com.app.service.EmployeesService;

@RestController
public class HttpServRequest {
@Autowired
	private EmployeesService employeesService;
	
	@RequestMapping("/hello")
	public String hello(  @RequestBody EmpMapper emp,  HttpServletRequest httpServletRequest ) {
		
		System.err.println(httpServletRequest.getLocalAddr());
		String header = httpServletRequest.getHeader("email");
		
		if(emp.getId().equals(1)) {
			
			return "no";
		}
		return header;
		
	}
	
	@RequestMapping("/page")
	public  ResponseEntity<List<Employees>> findAll(@RequestHeader("pageno") int page, @RequestHeader("sliceno") int slice )  throws Exception {
		
		
		if (slice==-1) {
			
			throw new Exception("Exception");
		}
		
		return  new ResponseEntity (this.employeesService.findAll(page,slice),HttpStatus.OK);
	}
	
	@RequestMapping("findEmp")
	public ResponseEntity<Employees> findEmp( @RequestParam("p")int id) {
		
		return  new ResponseEntity(this.employeesService.findById(id),HttpStatus.OK);
		
	}
	
	
	public LocationMapper getLocation(LocationMapper location ) {
		
		LocationMapper loc = new LocationMapper();
		loc.setCity("ddd");
	loc.setCountry("e");
	return null;
	}

	public EmployeesService getEmployeesService() {
		return employeesService;
	}

	public void setEmployeesService(EmployeesService employeesService) {
		this.employeesService = employeesService;
	}
	
}
