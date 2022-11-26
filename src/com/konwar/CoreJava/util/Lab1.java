package com.konwar.CoreJava.util;

import java.util.Vector;

public class Lab1 {
	public static void main(String[] args) {
		Student s1 = new Student(99);
		Student s2 = new Student(70);
		Student s3 = new Student(80);
		
		Vector v = new Vector();
		v.addElement(s1);
		v.addElement(s2);
		v.addElement(s3);
		
		System.out.println(v);
		
		s1.sid =110;
		s2.sid = 23;
		
		System.out.println(v);
	}
}

class Student{
	int sid;

	public Student(int sid) {
		super();
		this.sid = sid;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	@Override
	public String toString() {
		return String.valueOf(sid);
	}
	
}