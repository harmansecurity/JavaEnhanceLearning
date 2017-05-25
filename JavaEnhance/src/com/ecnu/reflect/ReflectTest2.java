package com.ecnu.reflect;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Properties;

public class ReflectTest2 {
	public static void main(String[] args) throws Exception{
		//InputStream ips = new FileInputStream("config.properties");
		
		//类加载器加载只读配置文件:类名.class.getClassLoader().getResourceAsStream(str);
		//InputStream ips =ReflectTest2.class.getClassLoader().getResourceAsStream("com/ecnu/reflect/config.properties");
		InputStream ips =ReflectTest2.class.getResourceAsStream("config.properties");
		Properties props = new Properties();
		props.load(ips);
		ips.close();
		
		String className = props.getProperty("className");
		Collection collections = (Collection)Class.forName(className).newInstance();
		
		
		//Collection collections = new ArrayList();//换成new HashSet()结果不一样
		//HashSet就是采用哈希算法存取对象的集合，它内部采用对某个数字n进行取余的方式对
		//哈希码进行分组和划分对象的存储区域。Object类中定义了一个hashCode方法来返回
		//每个Java对象的哈希码。当从HashSet集合中查找某个对象时，Java对象首先调用对象的
		//hashCode方法获得对象的哈希码，然后根据哈希码找到对应的存储区域，最后取出改存储
		//区域内的每个元素与该对象进行equals方法比较，这样不用遍历集合中的所有元素就能得到结果。
		//Collection collections = new HashSet();
		ReflectPoint pt1 = new ReflectPoint(3, 3);
		ReflectPoint pt2 = new ReflectPoint(5, 3);
		ReflectPoint pt3 = new ReflectPoint(3, 3);
		collections.add(pt1);
		collections.add(pt2);
		collections.add(pt3);
		collections.add(pt1);
		
		//如果参与hascode计算的成员变量中途发生变化，则后面remove时失败，造成内存泄露
		pt1.y = 7;
		collections.remove(pt1);
		
		System.out.println(collections.size());
		
	}
}
