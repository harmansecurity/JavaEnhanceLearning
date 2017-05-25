package com.ecnu.proxy;

import java.lang.reflect.Method;

public class MyAdvice implements Advice {

	long beginTime = 0;
	@Override
	public void afterMethod(Method method) {
		// TODO Auto-generated method stub

		long endTime = System.currentTimeMillis();
		System.out.println(method.getName() + " running time of " + (endTime-beginTime));
	}

	@Override
	public void beforeMethod(Method method) {
		// TODO Auto-generated method stub
		long beginTime= System.currentTimeMillis();
	}

}
