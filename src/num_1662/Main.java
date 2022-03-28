package num_1662;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
	
	public static int decompression(Stack<Character> stack) {
		int length = 0;
		int count = 0;
		boolean check = true;
		
		while(check) {
			char temp = stack.pop();
			if(temp != '(') {
				if(temp == ')') {
					length += decompression(stack);
				}
				else {
					length++;
				}
			}
			else {
				count = Character.getNumericValue(stack.pop());
				check = false;
			}
		}
		return length*count;
	}

	public static void main(String[] args) throws IOException {
		// Answer of BaekJoon no. 1662
		
		BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		char[] input = scan.readLine().toCharArray();
		Stack<Character> stack = new Stack<>();
		int result = 0;
		
		for(int i = 0; i < input.length; i++) {
			stack.add(input[i]);
		}
		
		while(!stack.empty()) {
			char temp = stack.pop();
			if(temp == ')') {
				result += decompression(stack);
			}
			else {
				result++;
			}
		}
		bw.write(Integer.toString(result));
		bw.flush();
		bw.close();
	}

}
