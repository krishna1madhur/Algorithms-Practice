package factorypattern;

public class ClientProgram {
	public static void main(String[] args) {
		ObjectFactory test = new ObjectFactory();
		Shape shape = test.getShape("four");
		int i = shape.getSides();
		String result = shape.getName();
		System.out.println("Shape is: "+ result + ": " + i);
	}	
}
