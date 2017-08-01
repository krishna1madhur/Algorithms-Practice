package singletonpattern;

public class Singleton {
	private static Singleton onlyInstance = new Singleton();
	private Singleton(){
		System.out.println("Instance Created!");
	}
	public static Singleton getInstance(){
		return onlyInstance;
	}
}
