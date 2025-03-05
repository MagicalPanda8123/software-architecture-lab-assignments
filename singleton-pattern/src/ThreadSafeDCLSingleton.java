package singletonPattern;

public class ThreadSafeDCLSingleton {
	/*
	 * Just a more optimized version of the Thread Safe Singleton
	 * using the Double-Checked Locking mechanism.
	 * */
	
	/*
	 * Notice the "volatile" keyword is used to prevent "instruction reordering" of the JVM.
	 * This ensures that writes to a variable (instance in this case) happen in the correct order
	 * and immediately visible to all the threads.
	 * */ 
	private static volatile ThreadSafeDCLSingleton instance;
	
	private ThreadSafeDCLSingleton() {};
	
	// More performant (too lazy to explain here, check for the double-checked locking singleton explained explanation text file)
	public static ThreadSafeDCLSingleton getInstance() {
		if(instance == null) { // First check
			synchronized (ThreadSafeSingleton.class) {
				if(instance == null) { // Second check (so that the late-coming thread doesn't re-initiate the instance)
					instance = new ThreadSafeDCLSingleton();
				}
			}
		}
		return instance;
	}
	
}
