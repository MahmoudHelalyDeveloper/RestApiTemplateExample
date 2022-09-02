package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entity.Location;;

@Repository
public interface LocationRepo  extends JpaRepository<Location, Integer> {
	
	
	

}
