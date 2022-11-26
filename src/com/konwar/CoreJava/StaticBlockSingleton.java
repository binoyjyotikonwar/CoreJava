package com.konwar.CoreJava;

public class StaticBlockSingleton {
	private static final StaticBlockSingleton aStaticBlockSingleton;

	private StaticBlockSingleton() {

	}

	static {
		try {
			aStaticBlockSingleton = new StaticBlockSingleton();
		} catch (Exception e) {
			throw new RuntimeException("Exception occured in creating singleton instance");
		}
	}

	public static StaticBlockSingleton getStaticBlockSingleton() {
		return aStaticBlockSingleton;
	}
}
