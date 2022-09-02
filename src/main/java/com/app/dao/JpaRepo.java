package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.entity.User;
import com.app.mapper.EmployeesView;

@Repository
public interface JpaRepo  extends JpaRepository<User, Integer> {
	
	@Query( nativeQuery = true,value  = "select E.EMPLOYEE_ID , E.LAST_NAME , E.FIRST_NAME ,D.DEPARTMENT_ID,D.DEPARTMENT_NAME ,J.JOB_ID ,J.JOB_TITLE  \r\n" + 
			"from employees e , departments d , jobs j\r\n" + 
			"where E.DEPARTMENT_ID=D.DEPARTMENT_ID \r\n" + 
			"and J.JOB_ID =e.JOB_ID \r\n" + 
			"order by D.DEPARTMENT_ID"  )
	public EmployeesView find();
	

}
