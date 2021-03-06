package com.spring.soap.webservices.soapspringboot.soap.bean;

public class Course {
	
	public Course(int id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		Description = description;
	}

	private int id;
	private String name;
	private String Description;
	
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
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	
	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", Description=" + Description + "]";
	}
	
	

}
