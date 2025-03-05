package singletonPattern;

public class EagerInitializedSingleton {
	/*
	 * Eager Initialized Singleton - the instance is initialized during the class build phase.
	 * This approach is not very performant if the instance is hardly (or even never) used.
	 * */ 
	
	// private static instance (to ensure that there is only one instance of the class)
	private static final EagerInitializedSingleton instance = new EagerInitializedSingleton();
	
	// private constructor (to prevent instantiation of this class from outside)
	private EagerInitializedSingleton() {}
	
	// public global point of access throughout the program
	public static EagerInitializedSingleton getInstance() {
		return instance;
	}
}
