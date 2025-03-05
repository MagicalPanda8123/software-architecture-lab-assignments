package singletonPattern;

public class Demo {
	
	// these properties is used for testing purpose.
	private static final int THREAD_QUANTITY = 100;

	public static void main(String[] args) throws InterruptedException {
		System.out.println("1/ Eager Initialized Singleton (instance's hashcode) : " + EagerInitializedSingleton.getInstance().hashCode());
		System.out.println("\n2/ Lazy Initialized Singleton : " + LazyInitializedSingleton.getInstance().hashCode());
		
		// Thread-Safe Singleton
		System.out.println("\n3/ Thread-safe Singleton : ");
		Runnable task = () -> System.out.println("\t- " + Thread.currentThread().getName() + " with instance-" + ThreadSafeSingleton.getInstance().hashCode());
		Thread t1 = new Thread(task);
		Thread t2 = new Thread(task);
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		
		// Thread-Safe DCL Singleton
		System.out.println("\n4/ Thread-safe Double-Checked Locking (LCD) Singleton : ");
		task = () -> System.out.println("\t- " + Thread.currentThread().getName() + " with instance-" + ThreadSafeDCLSingleton.getInstance().hashCode());
		t1 = new Thread(task);
		t2 = new Thread(task);
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		
		// Normal Vs DCL (efficiency)
		System.out.println("\n5/ Comparison in runtime between Normal Thread-Safe Singleton and Thread-Safe DCL Singleton :");
		long startTime1 = System.nanoTime();
		runTest(ThreadSafeSingleton::getInstance);
		long endTime1 = System.nanoTime();
		 System.out.println("\t- Normal Singleton Execution Time: " + (endTime1 - startTime1) / 1_000_000 + " ms");
		 
		long startTime2 = System.nanoTime();
		runTest(ThreadSafeDCLSingleton::getInstance);
		long endTime2 = System.nanoTime();
		 System.out.println("\t- DCL Singleton Execution Time: " + (endTime2 - startTime2) / 1_000_000 + " ms");
		 
		 // Bill Pugh Singleton
		 System.out.println("\n6/ Bill Pugh Singleton : ");
			task = () -> System.out.println("\t- " + Thread.currentThread().getName() + " with instance-" + BillPughSingleton.getInstance().hashCode());
			t1 = new Thread(task);
			t2 = new Thread(task);
			t1.start();
			t2.start();
			t1.join();
			t2.join();
			
		
		
	}
	
	public static void runTest(Runnable task) throws InterruptedException {
		Thread[] threads = new Thread[THREAD_QUANTITY];
		
		for(int i = 0; i < THREAD_QUANTITY; i++) {
			threads[i] = new Thread(task);
		}
		
		for (Thread thread : threads) {
			thread.start();
		}
		
		for (Thread thread : threads) {
			thread.join(); // Wait for all threads to complete
		}
	}

}
