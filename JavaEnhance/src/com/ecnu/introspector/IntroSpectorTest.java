package com.ecnu.introspector;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;

import com.ecnu.reflect.ReflectPoint;

public class IntroSpectorTest {

	/**
	 * @param args
	 * @throws IntrospectionException 
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ReflectPoint pt1 = new ReflectPoint(3, 5);
		
		String propertyName = "x";
		//"x"-->"X"-->"getX"-->"methodGetX"
		Object retVal = getProperty(pt1, propertyName);
		System.out.println(retVal);
		
		Object value = 7;
		setProperty(pt1, propertyName, value);
		System.out.println(pt1.getX());
		
		//使用Beanutils工具包
		System.out.println(BeanUtils.getProperty(pt1, "x"));
		BeanUtils.setProperty(pt1, "x", "9");
		System.out.println(pt1.getX());
		
/*		//java7新特性
		Map map = {name:"zxx",age:18};
		BeanUtils.setProperty(map, "name", "value");*/
		
		BeanUtils.setProperty(pt1, "birthday.time", "1994");
		System.out.println(BeanUtils.getProperty(pt1, "birthday.time"));
		
		PropertyUtils.setProperty(pt1, "x", 9);
		System.out.println(PropertyUtils.getProperty(pt1, "x").getClass().getName());
	}

	private static void setProperty(ReflectPoint pt1, String propertyName,
			Object value) throws IntrospectionException,
			IllegalAccessException, InvocationTargetException {
		PropertyDescriptor pd2 = new PropertyDescriptor(propertyName, pt1.getClass());
		Method methodSetX = pd2.getWriteMethod();
		methodSetX.invoke(pt1, value);
	}

	private static Object getProperty(Object pt1, String propertyName)
			throws IntrospectionException, IllegalAccessException,
			InvocationTargetException {
/*		PropertyDescriptor pd1 = new PropertyDescriptor(propertyName, pt1.getClass());
		Method methodGetX = pd1.getReadMethod();
		Object retVal = methodGetX.invoke(pt1);*/
		//麻烦实现
		Object retVal = null;
		BeanInfo beanInfo = Introspector.getBeanInfo(pt1.getClass());
		PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
		for(PropertyDescriptor pd : pds){
			if(pd.getName().equals(propertyName)){
				Method methodGetX = pd.getReadMethod();
			    retVal = methodGetX.invoke(pt1);
			    break;
			}
		}
		return retVal;
	}

}
