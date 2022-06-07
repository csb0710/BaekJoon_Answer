package num_1395;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static long[] input;
	static long[] tree;
	static boolean[] lazy;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void lazy_update(int start, int end, int min, int max, int index) {
		propagation(start, end, index);
		
		if(start > max || end < min) {
			return ;
		}
		
		if(start >= min && end <= max) {
			tree[index] = (end-start+1) - tree[index];
			if(end != start) {  
				lazy[index*2] = !lazy[index*2];
				lazy[index*2+1] = !lazy[index*2+1];
			}
			return ;
		}
		
		int mid = (start + end) / 2 ;
		
		lazy_update(start, mid, min, max, index*2);
		lazy_update(mid+1, end, min, max, index*2+1);
		
		tree[index] = tree[index*2] + tree[index*2+1];
		
	}
	
	public static void propagation(int start, int end, int index) {
		if(lazy[index]) {
			tree[index] = (end-start+1) - tree[index];
			if(end != start) {  
				lazy[index*2] = !lazy[index*2];
				lazy[index*2+1] = !lazy[index*2+1];
			}
			lazy[index] = false;
		}	
	}
	
	public static long get_switch(int start, int end, int min, int max, int index) throws IOException {
		propagation(start, end, index);
		
		if(start > max || end < min) {
			return 0;
		}
		
		if(start >= min && end <= max) {
			return tree[index];
		}
		
		int mid = (start + end) / 2;
		
		
				
		return get_switch(start, mid, min, max, index*2) + get_switch(mid + 1, end, min, max, index*2+1);

		
	}

	public static void main(String[] args) throws IOException {
		// Answer of BaekJoon no. 1395
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int count = Integer.parseInt(st.nextToken());
		
		input = new long[n+1];
		tree = new long[4*(n+1)];
		lazy = new boolean[4*(n+1)];
		
		
		for(int i = 0; i < count; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			if(a == 0) {
				lazy_update(1, n, b, c, 1);
			}
			else {
				bw.append(get_switch(1, n, b, c, 1) + "\n");
			}
			
		}
		
		
		
		bw.flush();
		bw.close();

	}

}
