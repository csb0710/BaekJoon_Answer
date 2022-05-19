package num_2268;

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
		
		return tree[index] = (make_tree(start, mid, index*2) + make_tree(mid+1, end, index*2+1));
		
	}
	
	public static long get_sum(int start, int end, int min, int max, int index) {
		if(max < start || min > end) {
			return 0;
		}
		if(start >= min && end <= max) {
			return tree[index];
		}
		
		int mid = (start+end)/2;
		
		return get_sum(start, mid, min, max, index*2) + get_sum(mid+1, end, min, max, index*2+1);
		
	}
	
	public static void change_value(int start, int end, int index, int target, long diff) {
		if(target < start || target > end)
			return;
		if(target >= start && target <= end) {
			tree[index] += diff;
		}
		
		if(start == end)
			return;
		
		int mid = (start + end) /2 ;
		
		change_value(start, mid, index*2, target, diff);
		change_value(mid + 1, end, index*2+1, target, diff);
		
	}
	
	public static void main(String[] args) throws IOException {
		// Answer of BaekJoon no. 2268
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		input = new long[n+1];
		tree = new long[4*(n+1)];
		
		make_tree(1, n, 1);
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long c = Long.parseLong(st.nextToken());
			
			if(a == 1) {
				long diff = c - input[b];
				input[b] = c;
				change_value(1, n, 1, b, diff);
			}
			else {
				if(b < c)
					bw.append(get_sum(1, n, b, (int)c, 1) + "\n");
				else
					bw.append(get_sum(1, n, (int)c, b, 1) + "\n");
			}
		}
		
		bw.flush();
		bw.close();
		

	}

}
