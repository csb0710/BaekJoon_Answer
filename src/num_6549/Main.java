package num_6549;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static long[] input;
	static long[] tree;
	static long result = 0;
	
//	public static long make_tree(int start, int end, int index) {
//		if(start == end) {
//			return tree[index] = input[start];
//		}
//		int mid = (start+end)/2;
//		
//		return tree[index] = (make_tree(start, mid, index*2) + make_tree(mid+1, end, index*2+1));
//		
//	}
	
	public static long get_area(int start, int end, int index) {
		if(start == end) {
			if(result < input[start])
				result = input[start];
			return input[start];
		}
		
		int mid = (start+end)/2;
		
		long temp_height = Math.min(get_area(start, mid, index*2), get_area(mid+1, end, index*2+1));
		
		long area = temp_height * (end-start+1);
		
		if(result < area) {
			result = area;
		}
		
		return temp_height;
		
	}
	
	public static void main(String[] args) throws IOException {
		// Answer of BaekJoon no. 6549
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int check;
		StringTokenizer st;
		while(true) {
			st = new StringTokenizer(br.readLine());
			check = Integer.parseInt(st.nextToken());
			
			if(check == 0) {
				break;
			}
			
			input = new long[check+1];
			tree = new long[4*(check+1)];
			
			for(int i = 1; i < check+1; i++) {
				input[i] = Integer.parseInt(st.nextToken());
			}
			//make_tree(1, check, 1);
			get_area(1, check, 1);
			
			bw.append(result + "\n");
			result = 0;
		}
		
		bw.flush();
		bw.close();
		
	}

}
