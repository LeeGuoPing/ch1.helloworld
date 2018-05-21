package ch1.helloworld.test.suanfa;

import org.junit.Test;

public class BinerySearch {
	
	@Test
	public void test01(){
		int[] array = {1,3,4,5,6,8,10,23};
		int searchKey = 4;
		int result = binerySearch(array,searchKey);
		System.out.println(result);
	}

	private int binerySearch(int[] array,int searchKey) {
		int l = 0;
		int h = array.length-1;
		while(l<=h){
			int mid = l+(h-l)/2;
			if(array[mid]==searchKey){
				return mid;
			}else if(array[mid]>searchKey){
				h = mid-1;
			}else{
				l = mid+1;
			}
		}
		return -1;
		
	}
}
