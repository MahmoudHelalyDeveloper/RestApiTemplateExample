package com.app.api;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.Location;
import com.app.service.LocationService;

import lombok.Data;

@RestController
//@ImportResource("config.properties")
@PropertySource("classpath:config.properties")
public class RequestValidation {
@Autowired
	private LocationService locationService;
	
	@Value("${player}")
//	@Value("${jwt.secret}")

private String file;

@PostMapping("/addlocation")
	public ResponseEntity<Location> addLocation(  @Valid @RequestBody Location location){
		
		System.err.println("file is "+file);
		return new ResponseEntity(this.locationService.addLocation(location),HttpStatus.OK);
		
	}


public LocationService getLocationService() {
	return locationService;
}


public void setLocationService(LocationService locationService) {
	this.locationService = locationService;
}
	
}
