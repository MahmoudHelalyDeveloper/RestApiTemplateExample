package com.app.mapper;

//import org.dozer.Mapping;

public class Personne {
//@Mapping("name")
	private String nom;
	
	
	private String surNom; 
	
	
	private String age;


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getSurNom() {
		return surNom;
	}


	public void setSurNom(String surNom) {
		this.surNom = surNom;
	}


	public String getAge() {
		return age;
	}


	public void setAge(String age) {
		this.age = age;
	}
	
	
	
}
