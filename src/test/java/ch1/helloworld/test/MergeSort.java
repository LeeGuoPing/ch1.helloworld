package ch1.helloworld.test;

import java.util.Arrays;
/**
 * 归并算法排序,分而治之
 *
 */
public class MergeSort {
	private static void mergeSort(int[] arr,int[] temp,int left,int right){
		if(left<right){
			
			int center = (left+right)/2;
			
			mergeSort(arr, temp, left,center);
			
			mergeSort(arr, temp, center+1,right);
			
			merge(arr, temp, left, center, right);
		}
	}
	
	
	private static void merge(int[] arr,int[] temp,int left,int center,int right){
		int i = left,j=center+1;
		System.out.println(left+":"+center+":"+right);
		for(int k=left;k<=right;k++){
			if(i>center){
				temp[k] = arr[j++];
			}else if(j>right){
				temp[k] = arr[i++];
			}else if(arr[i]<=arr[j]){
				temp[k] = arr[i++];
			}else{
				temp[k] = arr[j++];
			}
			
		}
		
		// 复制到原数组中
		for(int k = left;k<=right;k++){
			arr[k] = temp[k];
		}
	}
	
	
	
	public static void main(String[] args) {
		int[] arr = {3,1,7,5,2,8,4};
		int[] temp = new int[10];
		mergeSort(arr,temp,0,arr.length-1);
		System.out.println(Arrays.toString(arr));
	}
}
