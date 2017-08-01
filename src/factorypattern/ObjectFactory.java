package factorypattern;

public class ObjectFactory {
	public Shape getShape(String s) {
		if(s.equals("four")) return new Rectangle(); 
		else if(s.equals("three")) return new Triangle();
		else if(s.equals("five")) return new Pentagon();
		else return null;
	}
}
