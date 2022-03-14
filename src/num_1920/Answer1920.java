package num_1920;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Answer1920 {
	public static int merge_check(int[] ary, int target) {
		int low = 0;
		int high = ary.length-1;
		int mid;
		
		while(high >= low) {
			mid = (low + high)/2;
			if(ary[mid] == target)
				return 1;
			else if(ary[mid] > target) {
				high = mid-1;
			}
			else {
				low = mid+1;
			}
		}
		return 0;
	}

	static int partition(int list[], int left, int right) {
		int pivot, temp, low, high;
		
		pivot = list[left];
		low = left + 1;
		high = right;
		
		do {
			do
				low++;
			while(list[low] < pivot);
			do
				high--;
			while(list[high] > pivot);
			if(low < high) {
				temp = list[low];
				list[low] = list[high];
				list[high] = temp;
			}
		} while(low < high);
		temp = list[left];
		list[left] = list[high];
		list[high] = temp;
		
		return high;
		
	}
	
	static void quick_sort(int list[], int left, int right) {
		if(left < right) {
			int q = partition(list, left, right);
			quick_sort(list, left, q-1);
			quick_sort(list, q+1, right);
		}
	}
	
	public static void main(String[] args) {
		// Answer of BackJoon no.1920
		Scanner scan = new Scanner(System.in);
		int count = scan.nextInt();
		
		int[] ary = new int[count];
		
		for(int i = 0; i < count; i++) {
			int temp = scan.nextInt();
			ary[i] = temp;
		}
		//quick_sort(ary, 0, count-1);
		
		Arrays.sort(ary);
		
		int count2 = scan.nextInt();
		
		while(count2 > 0) {
			int temp = scan.nextInt();
			int result = merge_check(ary, temp);
			System.out.println(result);
			count2--;
		}
		
	}

}
