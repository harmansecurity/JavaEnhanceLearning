package com.ecnu.base;

//静态导入类下面的所有方法(1.5开始支持)
import static java.lang.Math.*;

public class StaticImport {
	public static void main(String[] args){
		System.out.println(max(3, 6));
		System.out.println(abs(3 - 6));
	}
}
