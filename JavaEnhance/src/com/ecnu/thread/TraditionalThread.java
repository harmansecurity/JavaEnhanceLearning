package com.ecnu.thread;

public class TraditionalThread {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread thread = new Thread(){
				public void run() {
					while(true){
						try {
							Thread.sleep(500);
						} catch (Exception e) {
							e.printStackTrace();
						}
						System.out.println("1:"+Thread.currentThread().getName());
						System.out.println("2:"+this.getName());
					}
				}
		};
		thread.start();
		
		Thread thread2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(true){
					try {
						Thread.sleep(500);
					} catch (Exception e) {
						e.printStackTrace();
					}
					System.out.println("1:"+Thread.currentThread().getName());
				}
			}
		});
		thread2.start();
		
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(true){
					try {
						Thread.sleep(500);
					} catch (Exception e) {
						e.printStackTrace();
					}
					System.out.println("runnable:"+Thread.currentThread().getName());
				}
			}
		}){
			public void run() {
				while(true){
					try {
						Thread.sleep(500);
					} catch (Exception e) {
						e.printStackTrace();
					}
					System.out.println("thread:"+Thread.currentThread().getName());
				}
			}
		}.start();
	}

}
