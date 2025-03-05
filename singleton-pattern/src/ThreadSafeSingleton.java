package singletonPattern;

public class ThreadSafeSingleton {
	/*
	 * Thread Safe Singleton : solves the problem posed by multi-threaded programs
	 * where multiple threads may call getInstance() for the first time at the exact
	 * same time (causing them to initialize multiple instances).
	 * */
	
	private static ThreadSafeSingleton instance;
	
	private ThreadSafeSingleton() {};
	
	/*
	 * This approach ensures that only one thread can access this method at 
	 *	any given point using the synchronized key word.
	 * */ 
	public static synchronized ThreadSafeSingleton getInstance() {
		if(instance == null) {
			instance = new ThreadSafeSingleton();
		}
		return instance;
	}

}
