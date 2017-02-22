/* Author: Krishna Madhur
Credits- Cracking the coding Interview*/

import java.util.*;

public class QuickSort {

	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++){
			arr[i] = scan.nextInt();
		}
		quicksort(arr, 0,arr.length-1);
		print(arr);
		scan.close();
	}
	public static void print(int[] arr){
		for(int i=0; i<arr.length; i++){
			System.out.print(arr[i] +" ");
		}
	}
	public static int pivot(int[] arr,int left,int right){
		int pivot = arr[(left+right)/2];
		return pivot;
	}
	public static void quicksort(int[] arr, int left, int right){
		if(left >= right){
			return;
		}	
		int pivot = pivot(arr,left,right);
		int index = partition(arr, left, right, pivot);
		quicksort(arr,left,index-1);
		quicksort(arr,index,right);
	}
	public static void swap(int[] arr, int left, int right){
		int temp = arr[left];
		arr[left] = arr[right];
		arr[right] = temp;
	}
	public static int partition(int[] arr, int left, int right, int pivot){
		while(left <= right){
			while(arr[left] <pivot){
				left++;
			}	
			while(arr[right]>pivot){
				right--;
			}
			if(left <= right){
				swap(arr,left,right);
				left++;
				right--;
			}
		}
		return left;
	}
}
