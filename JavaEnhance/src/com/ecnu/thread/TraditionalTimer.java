package com.ecnu.thread;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TraditionalTimer {

	/**
	 * @param args
	 */
	static int count = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*		new Timer().schedule(new TimerTask() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("bombling!");
			}
		}, 10000,3000);*/

		class MyTimerTask extends TimerTask{
					
			@Override
			public void run() {
				count = (count + 1)%2;
				System.out.println("bombling!");
				new Timer().schedule(new MyTimerTask(), 2000+2000*count);
			}
		}
		
		new Timer().schedule(new MyTimerTask(), 2000);
		while(true){
			System.out.println(new Date().getSeconds());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
