package com.konwar.CoreJava.Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

// Creating thread pull using ExecutorService  Executors.newFixedThreadPool
public class ThreadExample5 {
	public static void main(String[] args) {
		ExecutorService aExecutorService = Executors.newFixedThreadPool(3);
		
		for(int i = 0; i < 6; i++) {
			aExecutorService.submit(new Processor(i));
		}
		
		aExecutorService.shutdown();
		System.out.println("All task are submited..");
		
		try {
			aExecutorService.awaitTermination(1, TimeUnit.DAYS);
			
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		
	}
}


class Processor implements Runnable{
	private int id;
	public Processor(int id) {
		this.id = id;
	}
	public void run() {
		System.out.println("Starting... "+id);
		try {
			Thread.sleep(1000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Completed... "+id);
	}
}
