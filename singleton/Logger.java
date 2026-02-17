package singleton;

import java.time.LocalTime;

public class Logger {

	// Step 1: private static final(or volitile or no final)
	private static volatile Logger INSTANCE;
	
	// Step 2: private constructor to prevent object creation/ new instantiation
	private Logger() {
		System.out.println("Logger instance Created");
	}
	
	// step 3: public static getInstance method
	public static Logger getInstance() {
		
		if (INSTANCE == null) {
			synchronized (Logger.class) {
				if (INSTANCE == null) {
					INSTANCE = new Logger();
				}
			}
		}
		
		return INSTANCE;
	}
	
	public void log(String message) {
		System.out.println("log message @(" + LocalTime.now()+ "): " + message);
	}

	    public static void main(String[] args) {
	        Logger logger1 = Logger.getInstance();
	        Logger logger2 = Logger.getInstance();

	        System.out.println(logger1 == logger2); // ✅ Should print "true"

	        logger1.log("This is the first log message.");
	        logger2.log("This is the second log message.");
	    }
	
}


