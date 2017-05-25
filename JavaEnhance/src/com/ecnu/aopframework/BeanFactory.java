package com.ecnu.aopframework;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class BeanFactory {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InputStream ips = BeanFactory.class.getResourceAsStream("config.properties");
		BeanFactory beanFactory = new BeanFactory(ips);
		Object obj = beanFactory.getBean("xxx");
		System.out.println(obj.getClass().getName());
		System.out.println(obj.toString());		
	}

	private InputStream ips = null;
	private Properties props = new Properties();
	
	public BeanFactory(InputStream ips){
		this.ips = ips;
		try {
			props.load(ips);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	Object getBean(String beanName){
		Object obj = null;
		try {
			String className = props.getProperty(beanName);
			Class clazz = Class.forName(className);
			obj = clazz.newInstance();
			if(obj instanceof ProxyFactoryBean){
				ProxyFactoryBean factoryBean = (ProxyFactoryBean)obj;
				String adviceName = props.getProperty(beanName + ".advice");
				String targetName = props.getProperty(beanName + ".target");
				factoryBean.setAdvice((Advice)Class.forName(adviceName).newInstance());
				factoryBean.setTarget(Class.forName(targetName).newInstance());
				obj = factoryBean.getProxy();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj;
	}
}
