package com.ecnu.annotation;

@EcnuAnnotation(annotationAttr=@MetaAnnotation("flx"),color = "red",value = "abc",arrayAttr = {1,2,3})
public class AnnotationTest {

	/**
	 * @param args
	 * ע�����ͣ�@SuppressWarnings��@Deprecated��@Override
	 */
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.runFinalizersOnExit(true);
		if(AnnotationTest.class.isAnnotationPresent(EcnuAnnotation.class)){
			EcnuAnnotation annotation = (EcnuAnnotation)AnnotationTest.class.getAnnotation(EcnuAnnotation.class);
			System.out.println(annotation.color());
			System.out.println(annotation.value());
			System.out.println(annotation.arrayAttr().length);
			System.out.println(annotation.lamp().nextLamp().name());
			System.out.println(annotation.annotationAttr().value());
		}
	}
	
	@Deprecated //��ʱ
	public static void sayHello(){
		System.out.println("hi,helloworld");
	}

}
