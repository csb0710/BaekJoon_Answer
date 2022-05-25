package num_10999;

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
	
	public static long make_tree(int start, int end, int index) {
		if(start == end) {
			return tree[index] = input[start];
		}
		
		int mid = (start+end)/2;

		return tree[index] = make_tree(start, mid, index*2) + make_tree(mid+1, end, index*2+1);
	}
	
	public static void lazy_update(int start, int end, int min, int max, int index, long dif) {
		if(lazy[index] != 0) {
			tree[index] += (lazy[index])*(end-start+1);
			if(end != start) {  
				lazy[index*2] += lazy[index];
				lazy[index*2+1] += lazy[index];
			}
			lazy[index] = 0;
		}
		
		if(max < start || min > end) {
			return;
		}

		if(start >= min && end <= max) {
			tree[index] += dif * (end-start+1);
			if(end != start) {  
				lazy[index*2] += dif;
				lazy[index*2+1] += dif;
			}
			return;
		}
		
		int mid = (start+end)/2;
		
		lazy_update(start, mid, min, max, index*2, dif);
		lazy_update(mid + 1, end, min, max, index*2+1, dif);
		
		tree[index] = tree[index*2] + tree[index*2+1];
	}
	
	public static long get_sum(int start, int end, int min, int max, int index) {
		if(lazy[index] != 0) {
			tree[index] = tree[index] + (lazy[index])*(end-start+1);
			if(end-start != 0) {  
				lazy[index*2] += lazy[index];
				lazy[index*2+1] += lazy[index];
			}
			lazy[index] = 0;
		}
		
		if(max < start || min > end) {
			return 0;
		}

		if(start >= min && end <= max) {
			return tree[index];
		}
		
		int mid = (start+end)/2;
		
		
		return get_sum(start, mid, min, max, index*2) + get_sum(mid+1, end, min, max, index*2+1);
	}

	public static void main(String[] args) throws IOException {
		// Answer of BaekJoon no. 10999
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		input = new long[n+1];
		tree = new long[4*(n+1)];
		lazy = new long[4*(n+1)];
		
		for(int i = 1; i < n+1; i++) {
			input[i] = Long.parseLong(br.readLine());
		}
		
		make_tree(1, n, 1);
		
		for(int i = 0; i < m+k; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			if(a == 1) {
				long d = Long.parseLong(st.nextToken());
				lazy_update(1, n, b, c, 1, d);
			}
			else {
				bw.append(get_sum(1, n, b, c, 1) + "\n");
			}
		}
		
		bw.flush();
		bw.close();

	}

}
