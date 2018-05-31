package ch1.helloworld.test.suanfa;

import java.util.Arrays;
/**
 * 
 * @author liguoping
 *
 * 2018年5月23日-下午6:20:16
 *
 * @function 快速排序
 * 			 
 */
public class QuickSort {
	
	public static void main(String[] args) {
		int[] arr = {1,5,2,10,8,7,11,6};
		quickSort(arr);
		System.out.println(Arrays.toString(arr));
	}

	private static void quickSort(int[] arr) {
		if(arr.length>0){
			quickSort(arr,0,arr.length-1);
		}
		
	}

	private static void quickSort(int[] arr, int i, int j) {
		if(i>j){
			return;
		}
		int low = i;
		int high = j;
		
		int key = arr[i];
		while(low<high){
			while(low<high && arr[low]>key){
				high--;
			}
			while(low<high && arr[low]<=key){
				low++;
			}
			
			if(low<high){
				swap(arr,low,high);				
			}
		}
		swap(arr, i, low);
		quickSort(arr,i,low-1);
		quickSort(arr,low+1,j);
		
		
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		
	}
}
