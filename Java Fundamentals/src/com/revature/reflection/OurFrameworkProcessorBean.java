package com.revature.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class OurFrameworkProcessorBean {

	/**
	 * Pass a class name and method name, I will invoke this method
	 * Will throw a lot of exceptions. Can either catch or throw 
	 * @param className
	 * @param methodName
	 * @return
	 * @throws ClassNotFoundException 
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public static Object inspectAndInvoke(String className, String methodName) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		//STEP 1: Find class by its name using the Class class
		Class c = Class.forName(className);
		//STEP 2: Find constructor
		Constructor cons = c.getConstructor();
		//STEP 3: Invoke constructor
		Object obj = cons.newInstance();
		//STEP 4: Find the method 
		Method method = c.getDeclaredMethod(methodName);
		method.setAccessible(true);
		
		//STEP 4.5 -- only works if @Pickleable
//		if(method.getDeclaredAnnotation(Pickleable.class)!= null) {
//			//STEP 5: Invoke the method
			return method.invoke(obj);
//		}
//		else {
//			throw new RuntimeException("Not Pickleable");
//		}
	}
	
	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Object result = inspectAndInvoke("com.revature.reflection.Trainee", "code");
		System.out.println(result);
	};

}