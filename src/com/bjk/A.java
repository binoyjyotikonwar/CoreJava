package com.bjk;

public class A {
	public static void main(String[] args) {
		B b = new B();
//		System.out.println("Helo");
//		System.out.println(b instanceof B);
		System.out.println(b instanceof B);
		System.out.println(b instanceof A);
		System.out.println(!(b instanceof A));
		System.out.println(!(b instanceof C));
	}
}

class B extends A{
	
}

//class c extends B{
//	
//}

//class Test{
//	public static void main(String[] args) {
//		B b = new B();
//		System.out.println("Helo");
//	}
//	
//}