package com.konwar.CoreJava;

public class EagerInitializedSingleton {

	private static final EagerInitializedSingleton aEagerInitializedSingleton = new EagerInitializedSingleton();

	private EagerInitializedSingleton() {

	}

	public static EagerInitializedSingleton getEagerInitializedSingleton() {
		return aEagerInitializedSingleton;
	}
}
