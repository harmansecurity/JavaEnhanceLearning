package com.ecnu.thread;

public class MultiThreadShareData {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final ShareData1 data1 = new ShareData1();
		
		new Thread(new MyRunnable1(data1)).start();
		new Thread(new MyRunnable2(data1)).start();
				
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				data1.decrement();
			}
		}).start();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				data1.increment();
			}
		}).start();
	}

}

class MyRunnable1 implements Runnable{
	private ShareData1 data1;
	public MyRunnable1(ShareData1 data1){
		this.data1 = data1;
	}
	public void run(){
		data1.decrement();
	}
}
class MyRunnable2 implements Runnable{
	private ShareData1 data1;
	public MyRunnable2(ShareData1 data1){
		this.data1 = data1;
	}
	public void run(){
		data1.increment();
	}	
}
class ShareData1 /*implements  Runnable*/{
	
/*	private int count = 100;
	public void run() {
		while(true){
			count --;
		}
	}*/
	private int j = 0;
	public synchronized void increment(){
		j++;
	}
	public synchronized void decrement(){
		j--;
	}
}