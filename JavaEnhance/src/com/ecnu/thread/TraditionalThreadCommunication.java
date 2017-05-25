package com.ecnu.thread;

public class TraditionalThreadCommunication {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) {
		final Business business = new Business();
		new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				for (int i = 1; i <= 50; i++) {
/*					synchronized (Thread.class) {
						for (int j = 1; j <= 10; j++) {
							System.out.println("sub thread of " + j);
						}
					}*/
					try {
						business.sub(i);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}).start();
		
		for (int i = 1; i <= 50; i++) {
/*			synchronized (TraditionalThreadCommunication.class) {
				for (int j = 1; j <= 10; j++) {
					System.out.println("main thread of " + j);
				}
			}*/
			try {
				business.main(i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}

class Business{
	private boolean bShouldSub = true;
	public synchronized void sub(int i) throws InterruptedException{
		while(!bShouldSub){
			this.wait();
		}
		for (int j = 1; j <= 10; j++) {
			System.out.println("sub thread of " + j);
		}
		bShouldSub = false;
		this.notify();
	}
	
	public synchronized void main(int i) throws InterruptedException{
		while(bShouldSub){
			this.wait();
		}
		for (int j = 1; j <= 10; j++) {
			System.out.println("main thread of " + j);
		}
		bShouldSub = true;
		this.notify();
	}
}
