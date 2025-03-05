package singletonPattern;

public class LazyInitializedSingleton {
	/*
	 * Lazy Initialized Singleton : Only instantiate the instance if the program needs it (ie. calling the getInstance()).
	 * - A preferred approach to better optimize the resources.
	 * */
	
	// private static instance (not initiated yet!!!)
	private static LazyInitializedSingleton instance;
	
	private LazyInitializedSingleton() {};
	
	// Only instantiate the instance if needed
	public static LazyInitializedSingleton getInstance() {
		if (instance == null) {
			instance = new LazyInitializedSingleton();
		}
		return instance;
	}
}
