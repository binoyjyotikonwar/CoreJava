package com.konwar.CoreJava;

import java.util.HashMap;
import java.util.Map;

public class SingletonObjectEngine {
	private static final SingletonObjectEngine aSingletonObjectEngine = new SingletonObjectEngine();
	@SuppressWarnings("rawtypes")
	private Map<Class, Object> mapholder = new HashMap<Class, Object>();

	private SingletonObjectEngine() {

	}

	public static <T> T getInstance(Class<T> classOf) throws InstantiationException, IllegalAccessException {
		synchronized (aSingletonObjectEngine) {
			if (!aSingletonObjectEngine.mapholder.containsKey(classOf)) {
				T obj = classOf.newInstance();
				aSingletonObjectEngine.mapholder.put(classOf, obj);
			}
			return (T) aSingletonObjectEngine.mapholder.get(classOf);
		}
	}

	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}

}


	

