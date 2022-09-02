package com.app.mapper;

public class Items {
	
	
	
	private Integer id; 
	
	private String name; 

	
	private Integer price;
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	/**
	 * @return the price
	 */
	public Integer getPrice() {
		return price;
	}


	/**
	 * @param price the price to set
	 */
	public void setPrice(Integer price) {
		this.price = price;
	}



}
