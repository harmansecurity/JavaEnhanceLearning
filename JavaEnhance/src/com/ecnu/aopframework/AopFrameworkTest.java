package com.ecnu.aopframework;

import java.io.InputStream;

public class AopFrameworkTest {
	
	public static void main(String[] args){
		InputStream ips = AopFrameworkTest.class.getResourceAsStream("config.properties");
		Object bean = new BeanFactory(ips).getBean("xxx");
		System.out.println(bean.getClass().getName());
	}
}
