package singleton;

public class Singleton {
	// Step 1: Creating a private static instance(eagerly initialized)
	private static final Singleton INSTANCE = new Singleton();
	
	// Step 2: Private constructor to prevent instantiation
	private Singleton() {
		System.out.println("Singleton instance created!");
	}
	
	// Step 3: Public method to provide access to the instance
	public static Singleton getInstance() {
		return INSTANCE;
	}
	
}
