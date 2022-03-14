package num_1300;

import java.util.Arrays;
import java.util.Scanner;

public class Answer1300 {

//	public static int BinarySearch(int[] list, int target) {
//		int low = 1;
//		int high = list.length;
//		int mid;
//		
//		while(high >= low) {
//			mid = (low + high)/2;
//			System.out.println(list[mid]);
//			if(list[mid] == target)
//				return list[mid];
//			else if(list[mid] > target) {
//				high = mid-1;
//			}
//			else {
//				low = mid+1;
//			}
//		}
//		return -1;
//	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int count = scan.nextInt();
		int size = count*count;
		int counter = 1;
		int target = scan.nextInt();
		
		int[] list = new int[size+1];
		
		while(counter <= size) {
			for(int i = 1; i <= count; i++) 
				for(int j = 1; j <= count; j++) {
					list[counter] = i * j;
					counter++;
				}
		}
		
		
		Arrays.sort(list);
		
		//System.out.println(BinarySearch(list, target));
		System.out.println(list[target]);
		
	}

}
