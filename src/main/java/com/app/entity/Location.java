package com.app.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="location")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Location implements Serializable {

	@Id
	@Column(name="id" )
	@org.springframework.lang.NonNull
	private int id; 
	
	@Column(name="city", unique = true)
	@NotEmpty
	private String city; 
	@NotBlank
	@Column(name = "coutry")
	private String country;
	
}
