package adapter;



interface Logger {
	void logMessage(String Message);
}
class ConsoleLogger implements Logger {
    @Override
    public void logMessage(String message) {
        System.out.println("[LOG] " + message);
    }
}

class ModernLogger {
    void writeLog(String msg, String level) {
        System.out.println("[" + level + "] " + msg);
    }
}

class LogAdapter implements Logger{
	private ModernLogger modLog;
	private String logLevel = "INFO"; // default

	public LogAdapter(ModernLogger modLog) {
		this.modLog = modLog;
	}
	
	public void setLogLevel(String logLevel) {
		if (logLevel == "INFO" || logLevel == "WARN" || logLevel == "ERROR") {			
			this.logLevel = logLevel;
		}else {
			System.out.println("Incorrect level! Level is either 'INFO','WARN', or 'ERROR'");
		}
	}
	@Override
	public void logMessage(String Message) {
		modLog.writeLog(Message, logLevel);
	}
	
	
}


public class MainLogging {
	public static void main(String[] args) {

		Logger oldLog = new ConsoleLogger();
		oldLog.logMessage("Success");
		
		ModernLogger modern = new ModernLogger();
		LogAdapter logAdapter = new LogAdapter(modern);
		logAdapter.setLogLevel("WARN");
		logAdapter.logMessage("Careful!");
	}
}
