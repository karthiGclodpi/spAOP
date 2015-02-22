package com.org.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/*Moved to XML Aop Confug
 * @Aspect*/
public class LogingAspect { 
	
		/*@Before("allGetters() && allCircleMethods()")*/
	  /*  @Before("allCircleMethods()")
		public void logingAdvice(JoinPoint joinPoint)
		{
			System.out.println("Advice run get methoid called "+ joinPoint.toLongString());
		}*/
		
		/*@Before("allGetters()")
		public void secondAdvice()
		{
			System.out.println("Second Advice run get methoid called");
		}*/
	   /* @AfterReturning(pointcut="args(name)",returning="retString")
		public void AterstringArguments(String name,Object retString)
		{
			System.out.println("After Returning String Args called " + name +" "+ retString.toString());
		}*/
	    
	    
	    /*custom Annotation (X)
	     * @Around("@annotation(com.org.aop.aspect.Logable)")*/
	    public Object myAround(ProceedingJoinPoint procJp){
	    	Object returnValue=null;
	    	try {
	    		System.out.println("execution before " +procJp.toString());
				returnValue=procJp.proceed();
				System.out.println("execution after");
			} catch (Throwable e) {
				
				System.out.println("after Throwing");
			}
	    	
	    	System.out.println("after finaly");
	    	return returnValue;
	    }
	   /* @AfterThrowing(pointcut="args(name)",throwing="ex")
		public void AterthrostringArguments(String name,Exception ex)
		{
			System.out.println("After throwing String Args called" + name+" Exception "+ex);
		}
	    
		@Before("args(name)")
		public void stringArguments(String name)
		{
			System.out.println("String Args called" + name);
		}*/
		
		/*Moved to XML Aop COnfig
		 * @Pointcut("execution(public * get*())")
		public void allGetters(){}*/
		
		/*@Pointcut("within(com.org.aop.model.Circle)")
		public void allCircleMethods(){}*/
		
}
