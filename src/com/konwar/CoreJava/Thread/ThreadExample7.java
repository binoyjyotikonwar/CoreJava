package com.konwar.CoreJava.Thread;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

//Producer and Consumer Program
// WE will use BlockingQueue , ArrayBlockingQueue , these are thread safe and can be access from multi thread
//ArrayBlockingQueue is a data structure which will gono hold the data items , we can add items to it and remove from it (FIFO)
public class ThreadExample7 {
	
	private static BlockingQueue queue = new ArrayBlockingQueue(10);
	public static void main(String[] args) throws InterruptedException {
		
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
				producer();
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		});
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
				consumer();
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		});
		
		
		t1.start();
		t2.start();
		t1.join();
		t2.join();
	}
	
	
	private static void producer() throws InterruptedException {
		Random aRandom = new Random();
		while(true) {
			queue.put(aRandom.nextInt(100));
		}
	}
	
	private static void consumer() throws InterruptedException {
		Random aRandom = new Random();
		while(true) {
			Thread.sleep(10);
			if(aRandom.nextInt(10) == 0) {
				Integer value = (Integer) queue.take();
				System.out.println("Taken Value...."+value+ "   Queue Size.."+ queue.size() );
			}
			
		}
	}
	
}
