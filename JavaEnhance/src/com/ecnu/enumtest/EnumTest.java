package com.ecnu.enumtest;


public class EnumTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WeekDay1 weekDay = WeekDay1.SUN;
		System.out.println(weekDay.nextDay());
		WeekDay weekDay2 = WeekDay.FRI;
		System.out.println(weekDay2);
		System.out.println(weekDay2.name());
		System.out.println(weekDay2.ordinal());
	}
	
	public enum WeekDay {
		SUN(2),MON,TUE,WED,THR,FRI,SAT;
		private WeekDay(){System.out.println("first");};
		private WeekDay(int day){System.out.println("second");};
	}

	public enum TrafficLamp{
		RED(50){

			@Override
			public TrafficLamp nextLamp() {
				// TODO Auto-generated method stub
				return GREEN;
			}
			
		},
		GREEN(40){

			@Override
			public TrafficLamp nextLamp() {
				// TODO Auto-generated method stub
				return YELLOW;
			}
			
		},
		YELLOW(30){

			@Override
			public TrafficLamp nextLamp() {
				// TODO Auto-generated method stub
				return RED;
			}
			
		};
		public abstract TrafficLamp nextLamp();
		private int time;
		private TrafficLamp(int time){this.time = time;}
	}
}
