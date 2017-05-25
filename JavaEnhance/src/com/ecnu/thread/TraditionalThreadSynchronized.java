package com.ecnu.thread;

public class TraditionalThreadSynchronized {

	/**
	 * @param args
	 */
	//静态方法类不能用内部类实例对象
	public static void main(String[] args) {
		new TraditionalThreadSynchronized().init();
	}
	
	void init(){
		//内部类不能访问局部变量所以要用final
		final Outputer outputer = new Outputer();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(true){
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					outputer.output3("reqwrwqrwqreqw");
				}
			}
		}).start();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(true){
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					outputer.output1("lihuoming");
				}
			}
		}).start();

	}
	
	static class Outputer{
		public void output1(String name){
			int len = name.length();
			//互斥要是同一个对象
			synchronized (Outputer.class) {
				for(int i = 0;i<len;i++){
					System.out.print(name.charAt(i));
				}
				System.out.println();
			}
		}
		
		public synchronized void output2(String name){
			int len = name.length();
			//互斥要是同一个对象
				for(int i = 0;i<len;i++){
					System.out.print(name.charAt(i));
				}
				System.out.println();
		}
		
		public static synchronized void output3(String name){
			int len = name.length();
			//互斥要是同一个对象
				for(int i = 0;i<len;i++){
					System.out.print(name.charAt(i));
				}
				System.out.println();
		}
	}

}
