package com.ecnu.aopframework;

import java.lang.reflect.Method;

public class MyAdvice implements Advice
{

	public void afterMethod() {
		System.out.println("�Ӵ��Ǳ�ҵϰ��");
	}

	public void beforeMethod() {
		// TODO Auto-generated method stub
		System.out.println("������ѧϰ��");
	}
	
}
