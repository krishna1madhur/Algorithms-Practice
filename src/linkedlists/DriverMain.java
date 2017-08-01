package linkedlists;

public class DriverMain {
	public static void main(String[] args) {
		LinkedList<Double> list1 = new LinkedList<Double>();
		list1.insertEnd(2.0);
		list1.insertEnd(3.2);
		list1.insertEnd(4.5);
		list1.insertEnd(5.4);
		list1.insertEnd(6.6);
		list1.insertEnd(7.6);
		list1.printList();
		list1.removeEnd();
		list1.removeEnd();
		list1.removeEnd();
		list1.removeEnd();
		list1.removeEnd();
		System.out.println("Removed Item: "+String.valueOf(list1.removeEnd()));
		list1.printList();
		
	}
}
