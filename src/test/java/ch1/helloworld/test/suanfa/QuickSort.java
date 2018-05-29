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
		int[] arr = {3,5,2,10,8,7,11,6};
		quickSort(arr);
		System.out.println(Arrays.toString(arr));
	}

	private static void quickSort(int[] arr) {
		if(arr.length>0){
			quickSort(arr,0,arr.length-1);
		}
		
	}

	private static void quickSort(int[] arr, int low, int high) {
		if(low>high){  // 边界条件
			return;
		}
		int i = low;
		int j = high;
		int key = arr[i];  // 基准值
		
		while(i<j){
			while(i<j && key<arr[j]){
				j--;
			}
			while(i<j && key>=arr[i]){
				i++;
			}
			if(i<j){
				swap(arr,i,j);
			}
		}
		
		swap(arr,i,low);  // 基准值交换 
		quickSort(arr,low,i-1);
		quickSort(arr,i+1,high);
	}

	private static void swap(int[] arr, int i, int j) {
		if(i!=j){
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;			
		}
		
	}
}
