package com.konwar.CoreJava.Thread;

import java.util.Scanner;

public class ThreadExample3 {
	public static void main(String []args) {
		Pocessor aPocessor = new Pocessor();
		aPocessor.start();
		System.out.println("Please press return to stop...");
		Scanner sc = new Scanner(System.in);
		sc.nextLine();
		aPocessor.shutdown();
		
	}
}


class Pocessor extends Thread{
	private volatile boolean running = true;    
	public void run() {
		while(running) {
			//for(int i = 0; i<10; i++) {
				System.out.println("Hello ..");
			//}
			try {
				Thread.sleep(1000);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		}
			
	public void shutdown() {
		running = false;
	}
}