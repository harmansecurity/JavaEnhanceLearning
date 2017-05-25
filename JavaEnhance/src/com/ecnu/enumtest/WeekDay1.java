package com.ecnu.enumtest;

public abstract class WeekDay1 {
	private WeekDay1(){}
	
	public static WeekDay1 SUN = new WeekDay1(){

		@Override
		public WeekDay1 nextDay() {
			// TODO Auto-generated method stub
			return Mon;
		}
		
	};
	public static WeekDay1 Mon = new WeekDay1(){

		@Override
		public WeekDay1 nextDay() {
			// TODO Auto-generated method stub
			return SUN;
		}
		
	};

	public abstract WeekDay1 nextDay();
//	public WeekDay nextDay(){
//		if(this == SUN){
//			return Mon;
//		}else {
//			return SUN;
//		}
//	}
	
	public String toString(){
		return this==SUN ? "SUN" : "Mon";
	}
}
