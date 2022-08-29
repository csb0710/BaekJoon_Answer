package num_2195;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static char[] input1;
	static char[] input2;
	static boolean[] visit;
	
	public static int find(int index) {
		if(index >= input2.length) {
			return input2.length;
		}
		char temp = input2[index];
		
		visit = new boolean[input1.length];
		
		int max = 0;
		int max_index = 0;
		int temp_i = 0;
		
		if(input1[temp_i] == temp) {
			
		}
		
		for(int i = 0; i < input1.length; i++) {
//			if(visit[i]) {
//				continue;
//			}
			
			int input1_index = 0;
			int input2_index = 0;
			int same_length = 0;
			
			while(i + input1_index < input1.length && index+input2_index < input2.length && input1[i+input1_index] == input2[index+input2_index]) {
				visit[i] = true;
				same_length++;
				input1_index++;
				input2_index++;
			}
			
			if(input1_index != 0) {
				input1_index--;
			}
			if(input2_index != 0) {
				input2_index--;
			}
			
			i += input1_index;
			
			
			if(max < same_length) {
				max = same_length;
				max_index = index + input2_index;
			}
			
		}

		return max_index;
		
	}
	
	public static void main(String[] args) throws IOException {
		// Answer of BaekJoon no. 2195
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		input1 = br.readLine().toCharArray();
		input2 = br.readLine().toCharArray();
		
		int result = 0;
		
		for(int i = 0; i < input2.length; i++) {
			int index = 0;
			
			index = find(i);
			i = index;
			
			result++;
		}
		
		System.out.println(result);
	}

}
