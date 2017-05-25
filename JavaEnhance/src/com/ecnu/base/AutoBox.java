package com.ecnu.base;

public class AutoBox {
	public static void main(String[] args){
		Integer obj1 = 3;//自动装箱  整数类型被封装成对象
		System.out.println(obj1 + 3);
		String s1 = new String("abc");
		String s2 = new String("abc");
		
		Integer i1 = 13;
		Integer i2 = 13;
		//-128到127的时候i1=i2，超过则为false  享元模式  （小的数先缓存起来，下次遇到直接拿出来用）
		//小的整数在装箱的时候是同一个对象，大的整数装箱的时候不是同一个对象。
		System.out.println(i1 == i2);
		System.out.println(s1 == s2);
	}
}
