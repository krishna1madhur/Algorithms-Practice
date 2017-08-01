package heaps;

import java.util.Arrays;

public class BinaryHeap {
	public int heapSize;
	public int[] heap;
	public int position;
	
	public BinaryHeap(int size){
		this.heapSize = size;
		heap = new int[size];
		position = 0;
	}
	public int getParentIndex(int childIndex) {
		return (childIndex - 1)/2;
	}
	public int getLeftChildIndex(int parentIndex) {
		return (2*parentIndex)+1;
	}
	public int getRightChildIndex(int parentIndex) {
		return (2*parentIndex)+2;
	}
	public boolean isFull(){
		return (heapSize == 0);
	}
	public boolean isEmpty() {
		return heapSize == heap.length;
	}
	public void insertArray(int[] arr) {
		for(int i=0; i<arr.length; i++) {
			if(heap.length == i-1) break;
			if(arr[i] == -1) continue;
			insert(arr[i]);
		}
	}
	
	public void insert(int nodeValue) {
		heap[position] = nodeValue;
		heapifyUp(position++);
		
	}
	public void heapifyUp(int index) {
		while(index > 0) {
			int parentIndex  = getParentIndex(index);
			if(heap[parentIndex] > heap[index]) {
				swap(parentIndex, index);
				index = parentIndex;
			} else {
				break;
			}
		}
	}
	public void printHeap(){
		for(int i=0; i<heap.length; i++) {
			System.out.println(heap[i]);
		}
	}
	public int deleteMin(){
		int min = heap[0];
		heap[0] = Integer.MAX_VALUE;
		heapifyDown(0);
		return min;
	}
	public void heapifyDown(int index){
		
		while(index < heap.length-1) {
			int localMinIndex = heap[getLeftChildIndex(index)] < heap[getRightChildIndex(index)] ? getLeftChildIndex(index) : 
				getRightChildIndex(index);
			if(heap[localMinIndex] < heap[index]){
				swap(index,localMinIndex);
				index = localMinIndex;
			} else {
				break;
			}
		}
	}
	public void swap(int index1, int index2) {
		int temp = heap[index1];
		heap[index1] = heap[index2];
		heap[index2] = temp;
	}
}
