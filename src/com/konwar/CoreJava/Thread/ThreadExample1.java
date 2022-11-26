package com.konwar.CoreJava.Thread;

public class ThreadExample1 {
  public static void main(String []args) throws InterruptedException {
	  Thread t1 = new Thread(new Runner());
	  t1.start();
	 // t1.join();
	  
	  Thread t2 = new Thread(new Runner());
	  t2.start();
  }
}


class Runner implements Runnable{
	public void run() {
		for(int i = 0; i<10; i++) {
			System.out.println("Hello " + i);
		}
		try {
			Thread.sleep(1000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
}
