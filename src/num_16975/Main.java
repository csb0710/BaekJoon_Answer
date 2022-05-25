package num_16975;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static long[] input;
	static long[] tree;
	static long[] lazy;
	static long min_ = Long.MAX_VALUE;
	static long max_ = 0;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void make_tree(int start, int end, int index) {
		if(start == end) {
			tree[index] = input[start];
			return ;
		}
		
		int mid = (start + end) / 2;
		
		make_tree(start, mid, index*2);
		make_tree(mid+1, end, index*2+1);
		
	}
	
	public static void lazy_update(int start, int end, int min, int max, int index, long dif) {
		propagation(start, end, index);
		
		if(start > max || end < min) {
			return ;
		}
		
		if(start >= min && end <= max) {
			lazy[index] += dif;
			return ;
		}
		
		int mid = (start + end) / 2 ;
		
		lazy_update(start, mid, min, max, index*2, dif);
		lazy_update(mid+1, end, min, max, index*2+1, dif);
		
	}
	
	public static void propagation(int start, int end, int index) {
		if(lazy[index] != 0) {
			if(end != start) {
				lazy[index*2] += lazy[index];
				lazy[index*2+1] += lazy[index];
				lazy[index] = 0;
			}
		}	
	}
	
	public static void get_target(int start, int end, int target, int index) throws IOException {
		propagation(start, end, index);
		
		if(start > target || end < target) {
			return ;
		}
		
		if(start == end) {
			tree[index] += lazy[index];
			lazy[index] = 0;
			bw.append(tree[index] + "\n");
			return ;
		}
		
		int mid = (start + end) / 2;
		
		get_target(start, mid, target, index*2);
		get_target(mid + 1, end, target, index*2+1);
		
	}
	
	public static void main(String[] args) throws IOException {
		// Answer of BackJoon no. 16975
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		input = new long[n+1];
		tree = new long[4*(n+1)];
		lazy = new long[4*(n+1)];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 1; i < n+1; i++) {
			input[i] = Long.parseLong(st.nextToken());
		}
		
		make_tree(1, n, 1);
		
		int m = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(a == 1) {
				int c = Integer.parseInt(st.nextToken());
				long d = Long.parseLong(st.nextToken());
				lazy_update(1, n, b, c, 1, d);
			}
			else {
				get_target(1, n, b, 1);
			}
		}
		
		bw.flush();
		bw.close();

		

	}

}
