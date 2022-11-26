package com.bjk;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Singleton implements Serializable,Cloneable{
//	private static Singleton singleton = new Singleton(); //eager instance creation
	private static Singleton singleton = null;   //for lazy initialisation
	private Singleton() {
		System.out.println("Creating..");
	}
	
	public static Singleton getSinglton() {
		if(singleton == null) {
			singleton = new Singleton();
		}
		return singleton;
		
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
}
class TestClass{
	static void useSingletone() {
		Singleton singleton = Singleton.getSinglton();
		print("singleton",singleton);
	}
	public static void main(String[] args) throws Exception {
		
		ExecutorService service = Executors.newFixedThreadPool(2);
		service.submit(TestClass::useSingletone);
		service.submit(TestClass::useSingletone);
		service.shutdown();
		
		
//		Singleton s1 = Singleton.getSinglton(); 
//		Singleton s2 = Singleton.getSinglton(); 
//		print("S1",s1);
//		print("S2",s2);
//		
//		//Reflection
//		Class aClass= Class.forName("com.bjk.Singleton");
//		Constructor<Singleton> ctor = aClass.getDeclaredConstructor();
//		ctor.setAccessible(true);
//		Singleton s3 = ctor.newInstance();
//		print("S3",s3);
//		
//		
//		//Serialization
//		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("/tmp/s2.ser"));
//		oos.writeObject(s2);
//		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("/tmp/s2.ser"));
//		Singleton s4 = (Singleton) ois.readObject();
//		print("S4",s4);
//		
//		//Clonable
//		Singleton s5 = (Singleton) s2.clone();
//		print("S5",s5);
		
		
	}
	static void print(String name,Singleton object) {
		System.out.println(String.format("Object : %s, Hashcode: %d",name,object.hashCode()));
	}
	
	
}