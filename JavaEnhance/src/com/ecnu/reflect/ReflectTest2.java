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
		
		//�����������ֻ�������ļ�:����.class.getClassLoader().getResourceAsStream(str);
		//InputStream ips =ReflectTest2.class.getClassLoader().getResourceAsStream("com/ecnu/reflect/config.properties");
		InputStream ips =ReflectTest2.class.getResourceAsStream("config.properties");
		Properties props = new Properties();
		props.load(ips);
		ips.close();
		
		String className = props.getProperty("className");
		Collection collections = (Collection)Class.forName(className).newInstance();
		
		
		//Collection collections = new ArrayList();//����new HashSet()�����һ��
		//HashSet���ǲ��ù�ϣ�㷨��ȡ����ļ��ϣ����ڲ����ö�ĳ������n����ȡ��ķ�ʽ��
		//��ϣ����з���ͻ��ֶ���Ĵ洢����Object���ж�����һ��hashCode����������
		//ÿ��Java����Ĺ�ϣ�롣����HashSet�����в���ĳ������ʱ��Java�������ȵ��ö����
		//hashCode������ö���Ĺ�ϣ�룬Ȼ����ݹ�ϣ���ҵ���Ӧ�Ĵ洢�������ȡ���Ĵ洢
		//�����ڵ�ÿ��Ԫ����ö������equals�����Ƚϣ��������ñ��������е�����Ԫ�ؾ��ܵõ������
		//Collection collections = new HashSet();
		ReflectPoint pt1 = new ReflectPoint(3, 3);
		ReflectPoint pt2 = new ReflectPoint(5, 3);
		ReflectPoint pt3 = new ReflectPoint(3, 3);
		collections.add(pt1);
		collections.add(pt2);
		collections.add(pt3);
		collections.add(pt1);
		
		//�������hascode����ĳ�Ա������;�����仯�������removeʱʧ�ܣ�����ڴ�й¶
		pt1.y = 7;
		collections.remove(pt1);
		
		System.out.println(collections.size());
		
	}
}
