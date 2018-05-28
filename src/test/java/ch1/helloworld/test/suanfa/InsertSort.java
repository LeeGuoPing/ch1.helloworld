package ch1.helloworld.test.suanfa;

import java.util.Arrays;

/**
 * 
 * @author liguoping
 *
 *         2018年5月28日-上午10:36:31
 *
 * @function 插入排序 link http://www.cnblogs.com/eniac12/p/5329396.html
 * 
 *           https://blog.csdn.net/happy_wu/article/details/51841244
 *           
 * 			1.从第一个元素开始，该元素可以认为已经被排序
 *			2.取出下一个元素，在已经排序的元素序列中从后向前扫描
 *			3.如果该元素（已排序）大于新元素，将该元素移到下一位置
 *			4.重复步骤3，直到找到已排序的元素小于或者等于新元素的位置
 *			5.将新元素插入到该位置后
 *			6.重复步骤2~5
 */
public class InsertSort {

	public static void main(String[] args) {
		int[] arr = { 3, 1, 5, 7, 2, 4, 9, 6, 10, 8 };
		System.out.println("before: " + Arrays.toString(arr));
		insertSort(arr);
		System.out.println("after: " + Arrays.toString(arr));
	}

	private static void insertSort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int j;
			int target = arr[i];
			for (j = i; j > 0 && target < arr[j - 1]; j--) {
				arr[j] = arr[j - 1];
			}
			arr[j] = target;
		}
	}
}
