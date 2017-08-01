package heaps;

public class DriverMain {
	public static void main(String[] args) {
		BinaryHeap heap = new BinaryHeap(9);
		int[] arr = {2,3,5,6,4,7,8,9,1};
		
		heap.insertArray(arr);
		heap.printHeap();
		System.out.println(String.valueOf(heap.deleteMin()));
		heap.printHeap();
	}
}
