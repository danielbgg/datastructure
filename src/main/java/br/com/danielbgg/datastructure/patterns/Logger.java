package br.com.danielbgg.datastructure.patterns;

//Implements a simple logging class using a singleton.
//If you’ve claimed deep expertise in Java, an interviewer might ask you how an application could create multiple instances of the Logger class despite the existence of the private constructor and how to prevent that from happening. (Hint: think about cloning and object serialization.)
public class Logger {

	// Create and store the singleton.
	private static final Logger instance = new Logger();

	// Prevent anyone else from creating this class.
	private Logger() {
	}

	// Return the singleton instance.
	public static Logger getInstance() {
		return instance;
	}

	// Log a string to the console.
	//
	// example: Logger.getInstance().log("this is a test");
	//
	public void log(String msg) {
		System.out.println(System.currentTimeMillis() + ": " + msg);
	}
}