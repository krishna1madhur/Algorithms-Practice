package stack;

public class DriverMain {
	public static void main(String[] args) {
		Stack<Float> s = new Stack<Float>(3);
		s.push(Float.valueOf(1));
		s.push(Float.valueOf(2));
		s.push(Float.valueOf(3));
		s.printElements();
		s.pop();
		s.printElements();
		s.push(Float.valueOf(3));
		s.push(Float.valueOf(4));
		s.pop();
 	}
}
