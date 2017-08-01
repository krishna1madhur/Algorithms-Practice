package practice;

import java.util.Scanner;

public class MergeSort {
		public static void main(String[] args) {
			Scanner scan = new Scanner(System.in);
			int n = scan.nextInt();
			int[] arr = new int[n];
			for(int i=0; i<n; i++) {
				arr[i] = scan.nextInt();
			}
			mergeSort(arr, 0, arr.length-1);
			for(int i=0; i<arr.length; i++) {
				System.out.print(arr[i] + " ");
			}
		}
		public static void mergeSort(int[] arr, int left, int right){
			if(left >= right){
				return ;
			}
			int mid = (left+right)/2;
			mergeSort(arr, left, mid);
			mergeSort(arr, mid+1, arr.length-1);
			merge(arr, left, mid, right);
		}
		public static void merge(int[] arr, int l, int m, int r) {
			int n1 = m - l + 1;
	        int n2 = r - m;
	        /* Create temp arrays */
	        int L[] = new int [n1];
	        int R[] = new int [n2];
	        /*Copy data to temp arrays*/
	        for (int i=0; i<n1; ++i)
	            L[i] = arr[l + i];
	        for (int j=0; j<n2; ++j)
	            R[j] = arr[m + 1+ j];
	        /* Merge the temp arrays */
	        // Initial indexes of first and second subarrays
	        int i = 0, j = 0;
	 
	        // Initial index of merged subarry array
	        int k = l;
	        while (i < n1 && j < n2)
	        {
	            if (L[i] <= R[j])
	            {
	                arr[k] = L[i];
	                i++;
	            }
	            else
	            {
	                arr[k] = R[j];
	                j++;
	            }
	            k++;
	        }
	 
	        /* Copy remaining elements of L[] if any */
	        while (i < n1)
	        {
	            arr[k] = L[i];
	            i++;
	            k++;
	        }
	 
	        /* Copy remaining elements of R[] if any */
	        while (j < n2)
	        {
	            arr[k] = R[j];
	            j++;
	            k++;
	        }
		}
}	
