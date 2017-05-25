package com.ecnu.aopframework;

import java.lang.reflect.Method;

public class MyAdvice implements Advice
{

	public void afterMethod() {
		System.out.println("从传智毕业习啦");
	}

	public void beforeMethod() {
		// TODO Auto-generated method stub
		System.out.println("来传智学习啦");
	}
	
}
