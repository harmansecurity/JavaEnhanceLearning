package com.ecnu.base;

public class AutoBox {
	public static void main(String[] args){
		Integer obj1 = 3;//�Զ�װ��  �������ͱ���װ�ɶ���
		System.out.println(obj1 + 3);
		String s1 = new String("abc");
		String s2 = new String("abc");
		
		Integer i1 = 13;
		Integer i2 = 13;
		//-128��127��ʱ��i1=i2��������Ϊfalse  ��Ԫģʽ  ��С�����Ȼ����������´�����ֱ���ó����ã�
		//С��������װ���ʱ����ͬһ�����󣬴������װ���ʱ����ͬһ������
		System.out.println(i1 == i2);
		System.out.println(s1 == s2);
	}
}
