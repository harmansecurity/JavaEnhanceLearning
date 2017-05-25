package com.ecnu.generic;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

import com.ecnu.reflect.ReflectPoint;

public class GenericTest {
	public static void main(String [] args) throws Exception{
		ArrayList collection1 = new ArrayList();
		collection1.add(1);
		collection1.add(2L);
		collection1.add("abc");
		//int i = (Integer) collection1.get(1);
		
		ArrayList<String> collection2 = new ArrayList();
		collection2.add("abc");
		String  element = collection2.get(0);
		
		ArrayList<Integer> collection3 = new ArrayList();
		System.out.println(collection3.getClass() == collection2.getClass());
		collection3.getClass().getMethod("add", Object.class).invoke(collection3, "abc");
		System.out.println(collection3.get(0));
		
		printCollection(collection3);
		
		HashMap<String, Integer> maps = new HashMap<String, Integer>();
		maps.put("zxx", 32);
		maps.put("wer", 45);
		
		Set<Map.Entry<String, Integer>> entrySet = maps.entrySet();
		for(Map.Entry<String, Integer> entry : entrySet){
			System.out.println(entry.getKey() + ":" + entry.getValue());
		}
		
		add(3, 5);
		add(3.5, 3);
		add(3, "abc");
		
		swap(new String[]{"a","b","c"}, 1, 2);
		
		Object obj = "abc";
		String x3 = autoConvert(obj);
		
		copy1(new Vector<String>(), new String[10]);
		
		
		GenericDao dao = new GenericDao();
		dao.add(new ReflectPoint(3, 5));
		//String s = dao.findById(id);
		
		//Vector<Date> v1 = new Vector<Date>();
		//v1.getClass();
		Method applyMethod = GenericTest.class.getMethod("applyVector", Vector.class);
		Type[] types = applyMethod.getGenericParameterTypes();
		ParameterizedType pType = (ParameterizedType)types[0];
		System.out.println(pType.getActualTypeArguments()[0]);
	}
	
	public static void applyVector(Vector<Date> v1){
		
	}
	
	//编写一个泛型方法，自动将Object类型的对象转化成其他类型
	private static <T> void swap(T[] a,int i,int j){
		T tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}
	private static <T> T autoConvert(Object obj){
		return (T)obj;
	}
	
	//T类型必须是引用类型不能是基本类型
	private static <T> T add(T x,T y){
		return null;
	}
	
	public static void printCollection(Collection<?> collection){
		System.out.println(collection.size());
		for(Object obj : collection){
			System.out.println(obj);
		}
	}
	
	public static <T> void printCollection2(Collection<T> collection,T obj1){
		System.out.println(collection.size());
		for(Object obj : collection){
			System.out.println(obj);
		}
		collection.add(obj1);
	}
	
	public static <T> void copy1(Collection<T> dest,T[] src){
		
	}
	
	public static <T> void copy2(Collection[] dest,T[] src){
		
	}
}
