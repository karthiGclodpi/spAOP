package com.org.aop.Service;

import com.org.aop.aspect.Logable;
import com.org.aop.model.Circle;
import com.org.aop.model.Triangle;

public class ShapeService {
     private Circle circle;
     private Triangle triangle;
     
     
    @Logable
	public Circle getCircle() {
    	System.out.println("get circle called");
		return circle;
	}
	public void setCircle(Circle circle) {
		this.circle = circle;
	}
	public Triangle getTriangle() {
		return triangle;
	}
	public void setTriangle(Triangle triangle) {
		this.triangle = triangle;
	}
}
