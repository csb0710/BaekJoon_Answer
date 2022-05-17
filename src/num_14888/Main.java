package num_14888;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int n;
	static int m;
	static boolean[] bit;
	static String wow;
	static String[] arr;
	static char[] sibal;
	static Queue<Long> queue;
	static long max = -1000000001;
	static long min = 1000000001;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void dfs(int n, long result, int depth) throws IOException {
		if(depth == n-1) {
			for(int i = 0; i < n-1; i++) {
				System.out.println(sibal[i]);
				if(sibal[i] == '+') {
					result += Long.parseLong(arr[i+1]);
				}
				if(sibal[i] == '-') {
					result -= Long.parseLong(arr[i+1]);
				}
				if(sibal[i] == '*') {
					result *= Long.parseLong(arr[i+1]);
				}
				if(sibal[i] == '/') {
					result /= Long.parseLong(arr[i+1]);
				}
			}
			if(result > max) {
				max = result;
			}
			if(result < min) {
				min = result;
			}
			return;
		}
		
		for(int i = 0; i < n-1; i++) {			
			if(!bit[i]) {
				bit[i] = true;
				sibal[depth] = wow.charAt(i);
				dfs(n, result, depth+1);
				bit[i] = false;
			}
		}
		
		
	}
	
	public static void main(String[] args) throws IOException {
		// Answer of BaekJoon no. 15651
		
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			queue = new LinkedList<>();
			
			n = Integer.parseInt(br.readLine());
			arr = br.readLine().split(" ");
			sibal = new char[n-1];
			
			String[] inputs2 = br.readLine().split(" ");
			
			wow = "";
			
			for(int i = 0; i < Integer.parseInt(inputs2[0]); i++) {
				wow += "+";
			}
			for(int i = 0; i < Integer.parseInt(inputs2[1]); i++) {
				wow += "-";
			}
			for(int i = 0; i < Integer.parseInt(inputs2[2]); i++) {
				wow += "*";
			}
			for(int i = 0; i < Integer.parseInt(inputs2[3]); i++) {
				wow += "/";
			}
			
			bit = new boolean[n-1];
			long result =  Long.parseLong(arr[0]);
			dfs(n, result, 0);
					
			System.out.println(max);
			System.out.println(min);

	}

}
