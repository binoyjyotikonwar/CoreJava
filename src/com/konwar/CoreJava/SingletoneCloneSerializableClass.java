package com.konwar.CoreJava;

public class SingletoneCloneSerializableClass implements Cloneable {
	private static final SingletoneCloneSerializableClass aSingletoneCloneSerializableClass = new SingletoneCloneSerializableClass();

	private SingletoneCloneSerializableClass() {
		if (aSingletoneCloneSerializableClass != null) {
			throw new RuntimeException("Its a singletone class , use getInstance() for object");
		}
	}

	public static SingletoneCloneSerializableClass getInstance() {
		return aSingletoneCloneSerializableClass;
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException{
		throw new CloneNotSupportedException("Cloning of this class is not allowed");
	}
	
	protected Object readResolve() {
		return aSingletoneCloneSerializableClass;
	}
}
