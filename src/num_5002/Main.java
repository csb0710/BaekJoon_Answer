package num_5002;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// Answer of BaekJoon no. 5002
		
		BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
		int memory = Integer.parseInt(scan.readLine());
		char[] line = scan.readLine().toCharArray();
		Queue<Character> queue = new LinkedList<>();
		for(int i = 0; i < line.length; i++) {
			queue.add(line[i]);
		}
		
		Stack<Character> stack = new Stack<>();
		int count = 0;
		boolean check = true;
		
		
		stack.push(queue.remove());
		
		while(!queue.isEmpty()) {
			
			if(queue.peek() != stack.peek()) {
				queue.remove();
				stack.pop();
				count += 2;
			}
			else {
				stack.push(queue.remove());
			}
			
			if(memory < stack.size()) {
				if(!queue.isEmpty()) {
					if(queue.peek() != stack.peek()) {
						queue.remove();
						stack.pop();
						count += 2;
					}
					else {
						count += stack.size()-1;
						check = false;
						break;
					}
				}
				else {
					count += stack.size()-1;
					check = false;
					break;
				}
			}
			if(stack.empty() && !queue.isEmpty())
				stack.push(queue.remove());
			
		}
		if(check) {
			count += stack.size();
		}
		
		System.out.println(count);
		
	}

}
