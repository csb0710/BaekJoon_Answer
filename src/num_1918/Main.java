package num_1918;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static int check(char input) {
		if(input == '+' ||input == '-')
			return 1;
		else if(input == '*' ||input == '/')
			return 2;
		else if(input == '(') 
			return 5;
		else
			return -1;
	}

	public static void main(String[] args) throws IOException{
		// Answer of BaekJoon no. 1918
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		Stack<Character> stack = new Stack<>();
		char[] insert = br.readLine().toCharArray();

		String temp = "";
		for(int i = 0; i < insert.length; i++) {
			if(insert[i] == '+' || insert[i] == '-' || insert[i] == '*' || insert[i] == '/' || insert[i] == '(' || insert[i] == ')') {
				if(!stack.empty()) {
					if(check(insert[i]) == -1) {
						while(stack.peek() != '(') {
							temp += stack.pop();
						}
						stack.pop();
					}
					else if(stack.peek().equals("(")) {
						stack.push(insert[i]);
					}
					else if(check(insert[i]) <= check(stack.peek())) {
						while(check(insert[i]) <= check(stack.peek()) && check(stack.peek()) != 5) {
							temp += stack.pop();
							if(stack.empty()) {
								break;
							}
						}
						stack.push(insert[i]);
					}
					else {
						stack.push(insert[i]);
					}
					
				}
				else {
					stack.push(insert[i]);
				}
			}
			else
				temp += insert[i];
		}
		while(!stack.empty()) {
			temp += stack.pop();
		}
		
		bw.write(temp);
		bw.flush();
		bw.close();

	}

}
