package com.bjk;

public class YogeshTest {
	
	
	static String str;
	public void YogeshTest() {
		System.out.println("In constructore");
		str = "Hello World";
	}
	static int doSfuff(String[] args) {
		return Integer.parseInt(args[0]);
	}
	public static void main(String[] args) {
		YogeshTest c = new YogeshTest();
		try {
			System.out.println(doSfuff(args));
		}catch(Exception e) {
			System.out.println("exec");
		}
		doSfuff(args);
		
	}
}
