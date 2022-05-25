package num_12844;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
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

		return tree[index] = make_tree(start, mid, index*2) ^ make_tree(mid+1, end, index*2+1);
	}
	
	public static void lazy_update(int start, int end, int min, int max, int index, long dif) {
		if(lazy[index] != 0) {
			if((end-start+1)%2 == 0) {
				tree[index] = tree[index] ^ 0;
			}
			else {
				tree[index] = tree[index] ^ lazy[index];
			}
			if(end != start) {  
				lazy[index*2] ^= lazy[index];
				lazy[index*2+1] ^= lazy[index];
			}
			lazy[index] = 0;
		}
		
		if(max < start || min > end) {
			return;
		}

		if(start >= min && end <= max) {
			if((end-start+1)%2 == 0) {
				tree[index] = tree[index] ^ 0;
			}
			else {
				tree[index] = tree[index] ^ dif;
			}
			if(end != start) {  
				lazy[index*2] ^= dif;
				lazy[index*2+1] ^= dif;
			}
			return;
		}
		
		int mid = (start+end)/2;
		
		lazy_update(start, mid, min, max, index*2, dif);
		lazy_update(mid + 1, end, min, max, index*2+1, dif);
		
		tree[index] = tree[index*2] ^ tree[index*2+1];
	}
	
	public static long get_xor(int start, int end, int min, int max, int index) {
		if(lazy[index] != 0) {
			if((end-start+1)%2 == 0) {
				tree[index] ^= 0;
			}
			else {
				tree[index] ^= lazy[index];
			}
			if(end != start) {  
				lazy[index*2] ^= lazy[index];
				lazy[index*2+1] ^= lazy[index];
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
		
		
		return get_xor(start, mid, min, max, index*2) ^ get_xor(mid+1, end, min, max, index*2+1);
	}

	public static void main(String[] args) throws IOException {
		// Answer of BackJoon no. 12844
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		
		input = new long[n+1];
		tree = new long[4*(n+1)];
		lazy = new long[4*(n+1)];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 1; i < n+1; i++) {
			input[i] = Long.parseLong(st.nextToken());
		}
		
		make_tree(1, n, 1);
		
		int count = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < count; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken()) + 1;
			int c = Integer.parseInt(st.nextToken()) + 1;
			
			if(a == 1) {
				long d = Long.parseLong(st.nextToken());
				lazy_update(1, n, b, c, 1, d);
			}
			else {
				bw.append(get_xor(1, n, b, c, 1) + "\n");
			}
		}
		
		
		
		bw.flush();
		bw.close();
		

	}

}
