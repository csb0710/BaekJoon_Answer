package num_1654;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
	static long check(long sticks[], long stick, long key) {
		
		long sum = 0;
		for(int i = sticks.length-1; i >= 0; i--) {
			sum += sticks[i] / stick;
		}
		
		return sum;
	}
	
	static long search_binary(long key, long low, long high, long sticks[]) {
		long middle;
		
		if(low <= high) {
			middle = (low + high) / 2;
			if(key == check(sticks, middle, key)) {
				return search_binary(key, middle+1, high, sticks);
			}
			else if(key > check(sticks, middle, key)) {
				return search_binary(key, low, middle-1, sticks);
			}
			else
				return search_binary(key, middle+1, high, sticks);
		}
		return low-1;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// Answer of BaekJoon no. 1654
		BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
		String[] input = scan.readLine().split(" ");
		int K = Integer.parseInt(input[0]);
		int N = Integer.parseInt(input[1]);
		long list[] = new long[K];
		
		for(int i = 0; i < K; i++) {
			list[i] = Integer.parseInt(scan.readLine());
		}
		
		Arrays.sort(list);
		
		
		System.out.println(search_binary(N, 1, list[list.length-1], list));

	}

}
