package com.konwar.CoreJava.util;

import java.util.ArrayList;
import java.util.List;

public class Lab2 {
	public static void main(String[] args) {
		System.out.println("\n With student");
		List stList = new ArrayList();
		Student st = new Student(55);
		stList.add(new Student(99));
		stList.add(new Student(89));
		stList.add(new Student(79));
		stList.add(st);
		
		System.out.println(stList.contains(st));
		System.out.println(stList.contains(new Student(99)));
		System.out.println("\n With User");
		
		
	}
}
