package num_10799;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		// Answer of BaekJoon no. 10799
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		Stack<Character> stack = new Stack<>();
		
		char[] input = br.readLine().toCharArray();
		int result = 0;
		
		for(int i = 0; i < input.length-1; i++) {
			if(input[i] == '(') {
				if(input[i+1] == ')') {
					result += stack.size();
					i++;
				}
				else
					stack.add(input[i]);
			}
			else {
				stack.pop();
				result++;
			}
		}
		if(!stack.empty()) {
			result++;
		}

		bw.write(result+"");
		bw.flush();
		bw.close();
	}

}
