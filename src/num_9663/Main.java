package num_9663;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static int result = 0;
	static int count;
	static int[] arr;
	 
	public static boolean check(int i, int depth) {
		for(int k = 0; k < depth; k++) {
			if(arr[k] == i) {
				return false;
			}
			else if(Math.abs(arr[k]-i) == Math.abs(k-depth)) {
				return false;
			}
		}
		return true;
	}
	
	public static void dfs(int n, int depth) throws IOException {
		if(depth == count) {
			result++;
			return;
		}
		for(int i = 0; i < n; i++) {
			if(check(i, depth)) {
				arr[depth] = i;
				dfs(n, depth+1);
			}
			
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// Answer of BaekJoon no. 9663
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int input = Integer.parseInt(br.readLine());
		
		arr = new int[input];
		count = input;
		
		dfs(input, 0);
		
		
		System.out.println(result);
		
	}

}
