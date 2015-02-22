package com.org.aop.Service;

import com.org.aop.model.Circle;

public class ShapeServiceProxy extends ShapeService {
	
	
	public Circle getCircle() {
    	return super.getCircle();
	}

}
