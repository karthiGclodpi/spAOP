package com.org.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.org.aop.Service.FactoryService;
import com.org.aop.Service.ShapeService;
import com.org.data.dao.HibernateDAOImpl;
import com.org.data.dao.JdbcDAOImpl;
import com.org.data.dao.SimpleJdbaDAOImpl;
import com.org.data.model.Circle;

/**
 * Hello world!
 *
 */


public class App 
{
    public static void main( String[] args )
    {/*  AOP Tutorilas
    	//ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
    	//ShapeService shapeService=ctx.getBean("shapeService",ShapeService.class);
    	
    	FactoryService fs=new FactoryService();
    	ShapeService shapeService= (ShapeService) fs.getBean("shapeService");
    	shapeService.getCircle();
    	//System.out.println( shapeService.getTriangle().getName());
    	shapeService.getCircle().setNamenadReturn("Dummy Circle");
    	try
    	{
    	shapeService.getCircle().setName("Dummy Circle");
    	}
    	catch(Exception e){}
    	
    	//shapeService.getTriangle().setName("fdgfer");
       
    	//System.out.println( shapeService.getTriangle().getName());
*/    
    	
    /*Spring Data*/
    	ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
    	
    	JdbcDAOImpl dao=ctx.getBean("jdbcDAOImpl",JdbcDAOImpl.class);
    	SimpleJdbaDAOImpl sdao=ctx.getBean("simpleJdbaDAOImpl",SimpleJdbaDAOImpl.class);
    	HibernateDAOImpl hdao=ctx.getBean("hibernateDAOImpl",HibernateDAOImpl.class);
    	//Circle circle =dao.getCircle(1);
    	System.out.println(dao.getCircleCount());
    	System.out.println(dao.getCircleNema(1));
    	System.out.println(dao.getCircleforID(1));
    	//dao.insertCircle(new Circle(3, "Third Circle"));
    	//dao.insertCircleNamedP(new Circle(5, "Fifth Circle"));
    	//dao.createTriangle();
    	System.out.println(dao.getAllcircle());
    	System.out.println(sdao.getCircleCount());
    	System.out.println("hibernate : "+ hdao.getCircleCount());
    	//System.out.println(circle.getName());
    	
    }
}
