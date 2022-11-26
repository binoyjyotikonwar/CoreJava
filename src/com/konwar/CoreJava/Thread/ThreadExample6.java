package com.konwar.CoreJava.Thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//Count down latches is a thread safe class
// Count down latch can be used in multi threaded environment without synchronisation 
// if we have CountDownLatch(3)    till one thread reach the count down 3 the other thread can not access it
public class ThreadExample6 {
	public static void main(String[] args) {
		CountDownLatch latch = new CountDownLatch(4);
		ExecutorService aExecutorService = Executors.newFixedThreadPool(2);
		for (int i= 0 ; i< 5; i++) {
			aExecutorService.submit(new Processor2(latch));
		}
		try {
			latch.await();
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		
	}
}

class Processor2 implements Runnable {

	private CountDownLatch aCountDownLatch;

	public Processor2(CountDownLatch aCountDownLatch) {
		this.aCountDownLatch = aCountDownLatch;
	}

	@Override
	public void run() {
		System.out.println("Stated...."+aCountDownLatch.getCount());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		aCountDownLatch.countDown();

	}

}