package com.ecnu.base;
//�ɱ����
public class VariableParameter {
	public static void main(String[] args){
		System.out.println(add(2, 3, 4));
		System.out.println(add(2, 3, 6, 7));
	}
	
	public static int add(int x,int ...args){
		int sum = x;
//		for(int i=0;i<args.length;i++){
//			sum += args[i];
//		}
		//��ǿforѭ��
		for(int arg : args){
			sum += arg;
		}
		return sum;
	}
}
