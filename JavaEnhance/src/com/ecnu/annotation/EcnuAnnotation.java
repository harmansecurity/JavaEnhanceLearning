package com.ecnu.annotation;

import com.ecnu.enumtest.EnumTest;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//Ԫע������þ��Ǹ���ע������ע�⡣
//�ĸ�Ԫע��ֱ��ǣ�@Target,@Retention,@Documented,@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD,ElementType.TYPE})
public @interface EcnuAnnotation {
	String color() default "blue";
	String value();
	int[] arrayAttr() default {3,4,5};
	
	EnumTest.TrafficLamp  lamp() default EnumTest.TrafficLamp.RED;
	
	MetaAnnotation annotationAttr() default @MetaAnnotation("1hm");
}
