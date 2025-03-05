package singletonPattern;

public class BillPughSingleton {
	private BillPughSingleton() {};
	
	// static inner classes are thread-safe in default. Plus, this inner class is only loaded when it's accessed
	private static class SingletonHelper {
		private static final BillPughSingleton INSTANCE  = new BillPughSingleton();
	}
	
	public static BillPughSingleton getInstance() {
		return SingletonHelper.INSTANCE;
	}
}
