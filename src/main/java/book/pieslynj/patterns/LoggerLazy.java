package book.pieslynj.patterns;

//Deferred initialization of logger.
public class LoggerLazy {

	// Inner class initializes instance on load, won't be loaded
	// until referenced by getInstance()
	private static class LoggerHolder {
		public static final LoggerLazy instance = new LoggerLazy();
	}
	
	// Create and store the singleton.
	private static LoggerLazy instance = null; // no longer final

	// Prevent anyone else from creating this class.
	private LoggerLazy() {
	}

	// Return the singleton instance.
	public static LoggerLazy getInstance() {
		return LoggerHolder.instance;
	}

	// Log a string to the console.
	public void log(String msg) {
		System.out.println(System.currentTimeMillis() + ": " + msg);
	}
}