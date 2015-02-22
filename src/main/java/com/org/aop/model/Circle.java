package com.org.aop.model;

public class Circle {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		System.out.println("circle setter is called");
		throw(new RuntimeException());
	}
	
	public String setNamenadReturn(String name) {
		this.name = name;
		System.out.println("circle setter is called");
		return name+" Returning";
	}

}
