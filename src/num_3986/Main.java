package num_3986;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Stack {
	private ArrayList<Character> stack = new ArrayList<>();
	private int top = -1;
	
	public int empty() {
		if(top==-1)
			return 1;
		else
			return 0;
	}
	
	public int size() {
		return top+1;
	}
	
	public void push(char input) {
		stack.add(input);
		top++;
	}
	
	public int pop() {
		if(empty() == 1)
			return -1;
		int temp = top--;
		return(stack.remove(temp));
	}
	
	public int top() {
		if(empty() == 1)
			return -1;
		return(stack.get(top));
	}
}
public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// Answer of BaekJoon no. 10828
		
		BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.parseInt(scan.readLine());
		int total = 0;
		
		for(int i = 0; i < count; i++) {
			Stack stack = new Stack();
			char[] input = scan.readLine().toCharArray();
			
			for(int j = 0; j < input.length; j++) {
				if(stack.top() == input[j])
					stack.pop();
				else
					stack.push(input[j]);
				
			}
			
			if(stack.empty() == 1)
				total++;
			
		}
		
		System.out.println(total);
	}

}
