package com.konwar.CoreJava.IOlibrary;

import java.io.DataInputStream;
//Example on DataInputStream
public class IOLab1 {
public static void main(String[] args) {
	try {
		DataInputStream dis = new DataInputStream(System.in);
		System.out.println("Enter First Number");
		int a = Integer.parseInt(dis.readLine());
		System.out.println("Enter Second Number");
		int b = Integer.parseInt(dis.readLine());
		
		int sum = a+b;
		System.out.println("Sum is "+sum);
		
	}catch(Exception e) {
		e.printStackTrace();
	}
}
}
