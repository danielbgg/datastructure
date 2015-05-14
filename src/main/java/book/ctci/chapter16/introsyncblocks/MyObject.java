package book.ctci.chapter16.introsyncblocks;

public class MyObject {
	public void foo(String name) {
		synchronized(this) {
			try {
				System.out.println("Thread " + name + ".foo(): starting");
				Thread.sleep(3000);
				System.out.println("Thread " + name + ".foo(): ending");
			} catch (InterruptedException exc) {
				System.out.println("Thread " + name + ": interrupted.");
			}
		}
	} 	
}
