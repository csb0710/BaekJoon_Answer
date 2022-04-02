package num_17413;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
	static Stack<Character> stack = new Stack<>();
	static StringBuilder sb = new StringBuilder();
	
	public static void stack_clear() {
		while(!stack.empty()) {
			sb.append(stack.pop());
		}
	}

	public static void main(String[] args) throws IOException {
		// Answer of BaekJoon no. 17413
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		
		char[] input = br.readLine().toCharArray();
		
		for(int i = 0; i < input.length; i++) {
			if(input[i] == '<') {
				stack_clear();
				while(input[i] != '>') {
					sb.append(input[i]);
					i++;
				}
				sb.append('>');
			}
			else if(input[i] == ' ') {
				stack_clear();
				sb.append(' ');
			}
			else {
				stack.add(input[i]);
			}
		}
		if(!stack.empty()) {
			stack_clear();
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}

}
