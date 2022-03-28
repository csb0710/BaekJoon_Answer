package num_9935;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		char[] input = scan.readLine().toCharArray();
		char[] bomb = scan.readLine().toCharArray();
		Stack<Character> stack = new Stack<>();
		Stack<Character> stack_input = new Stack<>();
		
		int index = 0;
		int index_bomb = 0;
		
		for(int i = 0; i < input.length; i++) {
			stack_input.add(input[i]);
		}
		
		while(!stack_input.empty()) {
			stack.add(stack_input.pop());
			if(stack.peek() == bomb[0] && stack.size() >= bomb.length) {
				for(int i = 0; i < bomb.length; i++) {
					if(stack.get(stack.size()-i-1) != bomb[i])
						break;
					if(i == bomb.length-1)
						for(int j = 0; j < bomb.length; j++)
							stack.pop();
				}
			}
		}
		if(stack.empty()) {
			bw.write("FRULA");
		}
		else {
			while(!stack.empty()) {
				bw.write(stack.pop());
			}
		}
		bw.flush();
		bw.close();
	}

}
