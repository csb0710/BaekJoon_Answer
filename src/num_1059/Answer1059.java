package num_1059;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Answer1059 {
	public static int get_min(ArrayList<Integer> ar, int n) {
		int min = 0;
		for(int i = 0; i < ar.size(); i++) {
			if(ar.get(i) < n && ar.get(i) > min)
				min = ar.get(i);
			else if(ar.get(i) == n)
				return 0;
		}
		return min+1;
	}
	
	public static int get_max(ArrayList<Integer> ar, int n) {
		int max = 1001;
		for(int i = ar.size()-1; i >= 0; i--) {
			if(ar.get(i) > n && ar.get(i) < max)
				max = ar.get(i);
			else if(ar.get(i) == n)
				return 0;
		}
		return max-1;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int all = scan.nextInt();
		ArrayList<Integer> ar = new ArrayList<>();
		
		for (int i = 0; i < all; i++)   {  
			ar.add(scan.nextInt());
		}
		
		Collections.sort(ar);
		
		int n = scan.nextInt();
		  
		int max, min;
		
		min = get_min(ar, n);
		max = get_max(ar, n);
		
		if(min <= 0 || max <= 0) {
			System.out.println("0");
			return;
		}
		
		int roop = max - n + 1;
		int count = 0;
		int i = 0;
		for(i = min; i < n; i++)
			count += roop;
		if(i == n && i != max)
			count += roop-1;
		
		System.out.println(count);
	}

}
