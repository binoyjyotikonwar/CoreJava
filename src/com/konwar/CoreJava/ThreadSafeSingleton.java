package com.konwar.CoreJava;

public class ThreadSafeSingleton {
	private static ThreadSafeSingleton aThreadSafeSingleton;

	private ThreadSafeSingleton() {

	}

	public static ThreadSafeSingleton getThreadSafeSingleton() {
		if (aThreadSafeSingleton == null) {
			synchronized (ThreadSafeSingleton.class) {
				if (aThreadSafeSingleton == null) {
					aThreadSafeSingleton = new ThreadSafeSingleton();
				}
			}
		}
		return aThreadSafeSingleton;
	}
}
