package com.ecnu.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class LockTest {

	/**
	 * @param args
	 */
	//��̬�����಻�����ڲ���ʵ������
	public static void main(String[] args) {
		new LockTest().init();
	}
	
	void init(){
		//�ڲ��಻�ܷ��ʾֲ���������Ҫ��final
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
		Lock lock = new ReentrantLock();
		public void output1(String name){
			int len = name.length();
			//����Ҫ��ͬһ������
			lock.lock();
			try{
				for(int i = 0;i<len;i++){
					System.out.print(name.charAt(i));
				}
				System.out.println();
			}finally{
				lock.unlock();
			}
		}
		
		public synchronized void output2(String name){
			int len = name.length();
			//����Ҫ��ͬһ������
				for(int i = 0;i<len;i++){
					System.out.print(name.charAt(i));
				}
				System.out.println();
		}
		
		public static synchronized void output3(String name){
			int len = name.length();
			//����Ҫ��ͬһ������
				for(int i = 0;i<len;i++){
					System.out.print(name.charAt(i));
				}
				System.out.println();
		}
	}
}
