package num_11505;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static long[] input;
	static long[] tree;
	
	public static long make_tree(int start, int end, int index) {
		if(start == end) {
			return tree[index] = input[start];
		}
		int mid = (start+end)/2;
		
		return tree[index] = (make_tree(start, mid, index*2) * make_tree(mid+1, end, index*2+1)) % 1000000007;
		
	}
	
	public static long get_mul(int start, int end, int min, int max, int index) {
		if(max < start || min > end) {
			return 1;
		}
		if(start >= min && end <= max) {
			return tree[index];
		}
		
		int mid = (start+end)/2;
		
		long a = get_mul(start, mid, min, max, index*2);
		long b = get_mul(mid+1, end, min, max, index*2+1);
		
		return  a*b % 1000000007;
		
	}
	
	public static long update_value(int start, int end, int index, int target) {
		if(target < start || target > end)
			return tree[index];
		
		if(start == end) {
			tree[index] = input[start];
			return input[start];
		}
		
		int mid = (start + end) /2 ;
		
		long a = update_value(start, mid, index*2, target); 
		long b = update_value(mid + 1, end, index*2+1, target);
		
		tree[index] = a * b % 1000000007;
		
		return  a * b % 1000000007; 
	}
	
	public static void main(String[] args) throws IOException {
		// Answer of BaekJoon no. 11505
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		input = new long[n+1];
		tree = new long[4*(n+1)];
		
		for(int i = 1; i < n+1; i++) {
			input[i] = Long.parseLong(br.readLine());
		}
		
		make_tree(1, n, 1);
		
		for(int i = 0; i < m+k; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long c = Long.parseLong(st.nextToken());
			
			if(a == 1) {
				input[b] = c;
				update_value(1, n, 1, b);
			}
			else {
				bw.append(get_mul(1, n, b, (int)c, 1)  + "\n");
			}
		}
		
		
		
		bw.flush();
		bw.close();

	}

}
