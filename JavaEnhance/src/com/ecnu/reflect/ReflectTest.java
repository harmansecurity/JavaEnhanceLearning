package com.ecnu.reflect;

import java.io.File;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;


public class ReflectTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		String str1 = "abc";
		Class cls1 = str1.getClass();
		Class cls2 = String.class;
		Class cls3 = Class.forName("java.lang.String");
		System.out.println(cls1 == cls2);
		System.out.println(cls2 == cls3);
		
		System.out.println(cls1.isPrimitive());
		System.out.println(int.class.isPrimitive());
		//九个预定义Class实例对象参看Class.isPrimitive()方法的帮助
		//int.class==Integer.TYPE
		System.out.println(int.class == Integer.class);
		System.out.println(int.class == Integer.TYPE);
		//数组类型的Class实例对象 Class.isArray()
		//总之只要是在源程序中出现的类型，都有各自的Class实例对象，例如int[],void.
		System.out.println(int[].class.isPrimitive());
		System.out.println(int[].class.isArray());
		
		//new String(new StringBuffer("abc"))
		//第一个代表选择哪个构造方法
		Constructor constructor1 = String.class.getConstructor(StringBuffer.class);
		//调用获得的方法时要用到上面相同类型的实例对象
		String str2 = (String)constructor1.newInstance(new StringBuffer("abc"));
		System.out.println(str2.charAt(2));
		
		ReflectPoint pt1 = new ReflectPoint(3, 5);
		Field fieldY = pt1.getClass().getField("y");
		//fieldY值是多少？是5，错。
		//fieldY不是对象身上的变量，而是类上，要用他去取某个对象上对应的值
		System.out.println(fieldY.get(pt1));
		//访问私有变量
		Field fieldX = pt1.getClass().getDeclaredField("x");
		fieldX.setAccessible(true);//暴力反射
		System.out.println(fieldX.get(pt1));
		
		changeStringValue(pt1);
		System.out.println(pt1);
		
		Method methodCharAt = String.class.getMethod("charAt", int.class);
		System.out.println(methodCharAt.invoke(str1, 1));
		System.out.println(methodCharAt.invoke(str1, new Object[]{2}));
		
		//写一个程序，这个程序能够根据用户提供的类名，去执行该类中的main方法。
		TestArguments.main(new String[]{"111","222","3333"});
		
		String startingClassName = args[0];
		Method mainMethod = Class.forName(startingClassName).getMethod("main", String[].class);
		//mainMethod.invoke(null, new Object[]{new String[]{"111","222","3333"}});
		//mainMethod.invoke(null, (Object)new String[]{"111","222","3333"});
		
		int[] a1 = new int[]{1,2,3};
		int[] a2 = new int[4];
		int[][] a3 = new int[2][3];
		String[] a4 = new String[]{"a","b","c"};
		System.out.println(a1.getClass() == a2.getClass());
		System.out.println(a1.getClass().getName());
		System.out.println(a1.getClass().getSuperclass());
		
		Object aObj1 = a1;
		Object aObj2 = a4;
		//Object[] aObj3 = a1;
		Object[] aObj4 = a3;
		Object[] aObj5 = a4;
		
		System.out.println(a1);
		System.out.println(a4);
		System.out.println(Arrays.asList(a1));
		System.out.println(Arrays.asList(a4));
		
		
		printObject(a4);
		printObject("xyz");
	}

	private static void printObject(Object obj) {
		// TODO Auto-generated method stub
		Class clazz = obj.getClass();
		if(clazz.isArray()){
			int len = Array.getLength(obj);
			for (int i = 0; i < len; i++) {
				System.out.println(Array.get(obj,i));
			}
		}
		
	}

	private static void changeStringValue(Object obj) throws Exception {
		// TODO Auto-generated method stub
		Field[] fields = obj.getClass().getFields();
		for(Field field : fields){
			//field.getType().equals(String.class);
			//字节码用等号比，因为只有一份
			if(field.getType() == String.class){
				String oldValue = (String)field.get(obj);
				String newValue = oldValue.replace('b', 'a');
				field.set(obj, newValue);
			}
		}
	}

}
class TestArguments{
	public static void main(String[] args){
		for(String arg : args){
			System.out.println(arg);
		}
	}
}
