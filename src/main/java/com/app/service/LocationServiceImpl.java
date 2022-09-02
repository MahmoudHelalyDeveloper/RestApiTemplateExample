package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.LocationRepo;
import com.app.entity.Location;

import lombok.Data;

@Service

public class LocationServiceImpl  extends LocationService {

	public LocationRepo getLocationRepo() {
		return locationRepo;
	}

	public void setLocationRepo(LocationRepo locationRepo) {
		this.locationRepo = locationRepo;
	}

	@Autowired
	private LocationRepo locationRepo;
	
	@Override
	public Location addLocation(Location location) {
		// TODO Auto-generated method stub
		return locationRepo.save(location);
	}

}
