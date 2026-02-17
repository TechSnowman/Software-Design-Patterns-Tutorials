package singleton;

public class DatabaseConnectionManager {
	
	// Step 1: create a private static (maybe final) instance
	private static volatile DatabaseConnectionManager INSTANCE;
	
	// private constructor
	private DatabaseConnectionManager() {
		System.out.println("Manager instance created");
	}
	
	public static DatabaseConnectionManager getInstance() {
		if (INSTANCE == null) {
			synchronized (DatabaseConnectionManager.class) {
				if (INSTANCE == null) {
					INSTANCE = new DatabaseConnectionManager();
				}
			}
		}
		
		
		return INSTANCE;
	}
	
	public void connect() {
		System.out.println("Connected to database.");
	}
	
	public void disconnect() {
		System.out.println("Disconnected from database.");
	}
	
	
	
}
