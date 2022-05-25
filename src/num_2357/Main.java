package num_2357;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static long[] input;
	static long[][] tree;
	static long min_ = Long.MAX_VALUE;
	static long max_ = 0;
	
	public static long[] make_tree(int start, int end, int index) {
		if(start == end) {
			tree[index][0] = input[start];
			tree[index][1] = input[start];
			return tree[index];
		}
		
		int mid = (start+end)/2;
		
		long[] temp1 = make_tree(start, mid, index*2);
		long[] temp2 = make_tree(mid+1, end, index*2+1);
		
		tree[index][0] = Math.min(temp1[0], temp2[0]);
		tree[index][1] = Math.max(temp1[1], temp2[1]);
		
		return tree[index];
	}
	
	public static long[] get_min_max(int start, int end, int min, int max, int index) {
		if(max < start || min > end) {
			return new long[]{min_, max_};
		}
		if(start >= min && end <= max) {
			return tree[index];
		}
		
		int mid = (start+end)/2;
		
		long[] a = get_min_max(start, mid, min, max, index*2);
		long[] b = get_min_max(mid+1, end, min, max, index*2+1);
		
		return new long[]{Math.min(a[0], b[0]), Math.max(a[1], b[1])};
		
	}
	
	public static void main(String[] args) throws IOException {
		// Answer of BaekJoon no. 2357
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		input = new long[n+1];
		tree = new long[4*(n+1)][2];
		
		for(int i = 1; i < n+1; i++) {
			input[i] = Long.parseLong(br.readLine());
		}
		
		make_tree(1, n, 1);
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			long[] temp_result = get_min_max(1, n, a, b, 1);
			
			bw.append(temp_result[0] + " " +temp_result[1]  + "\n");
		}
		
		bw.flush();
		bw.close();

	}

}
