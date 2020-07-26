package com.m2m.shoppingbackend.dto;

public class Category {
	
	/*
	 * Private Fields
	 * */
	private int id;
	private String name;
	private String description;
	private String image_URL;
	private boolean active = true;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImage_URL() {
		return image_URL;
	}
	public void setImage_URL(String image_URL) {
		this.image_URL = image_URL;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	
	

}
