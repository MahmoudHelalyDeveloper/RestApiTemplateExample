package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.app.entity.Employees;
import com.app.entity.EmployeesPojo;
import com.app.mapper.EmpMapper;

@Repository
public interface EmployeesJpa  extends PagingAndSortingRepository<Employees, Integer> {
	@Query(nativeQuery = true)
public	EmployeesPojo getData();

}
