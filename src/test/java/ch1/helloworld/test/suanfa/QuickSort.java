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

	private static void quickSort(int[] arr, int low, int high) {
		// 循环结束条件
		if(low>high){
			return;
		}
		int i = low;
		int j = high;
		
		// 基准
		int key = arr[low]; 
		
		while(i<j){
			while(i<j && arr[j]>key){
				j--;
			}
			while(i<j && arr[i]<=key){
				i++;
			}
			if(i<j){
				int p = arr[i];
				arr[i] = arr[j];
				arr[j] = p;
			}
		}
		// 4.4，调整key的位置  
        int p = arr[i];  
        arr[i] = arr[low];  
        arr[low] = p;
        
        //5, 对key左边的数快排  
        quickSort(arr, low, i-1 );  
        //6, 对key右边的数快排  
        quickSort(arr, i+1, high);  
		
		
	}
}
