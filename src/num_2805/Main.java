package num_2805;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static long[] trees;
	static long target;
	public static boolean check_tree(long cut_length) {
		long sum = 0;
		
		for(int i = 0; i < trees.length; i++) {
			if(trees[i] - cut_length > 0) {
				sum += trees[i] - cut_length;
			}
			
		}
		if(target <= sum)
			return true;	
		return false;
		
	}
	
	public static void main(String[] args) throws IOException {
		// Answer of BaekJoon no. 2805
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input);
		
		int count = Integer.parseInt(st.nextToken());
		target = Integer.parseInt(st.nextToken());
		
		input = br.readLine();
		st = new StringTokenizer(input);
		
		trees = new long[count];
		long tree_max = 0;
		for(int i = 0; i < count; i++) {
			trees[i] = Integer.parseInt(st.nextToken());
			if(tree_max < trees[i])
				tree_max = trees[i];
		}
		
		long low = 0;
		long high = tree_max;
		long max = 0;
		
		while(low <= high) {
			long mid = (low+high)/2;
			if(check_tree(mid)) {
				if(max < mid) {
					max = mid;
				}
				low = mid+1;
			}
			else {
				high = mid-1;
			}
		}
		
		bw.write(max+"");
		bw.flush();
		bw.close();
	}

}
