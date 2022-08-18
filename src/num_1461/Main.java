package num_1461;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// Answer of BaekJoon no. 1461
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int books = Integer.parseInt(st.nextToken());
		int carry = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer> right = new ArrayList<>();
		ArrayList<Integer> left = new ArrayList<>();
		
		st = new StringTokenizer(br.readLine());
		int max = 0;
		
		for(int i = 0; i < books; i++) {
			int temp = Integer.parseInt(st.nextToken());
			
			if(temp < 0) {
				left.add(Math.abs(temp));
			}
			else {
				right.add(temp);
			}
			
			max = Math.max(max, Math.abs(temp));
		}
		
		Collections.sort(right);
		Collections.sort(left);
		
		int right_index = right.size()-1;
		int left_index = left.size()-1;
		int result = 0;
		
		while(right_index >= 0) {
			result += right.get(right_index)*2;
			right_index -= carry;
		}
		
		while(left_index >= 0) {
			result += left.get(left_index)*2;
			left_index -= carry;
		}
		
		System.out.println(result-max);
	}

}
