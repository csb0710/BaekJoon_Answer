package num_10828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


class Stack {
	private ArrayList<Integer> stack = new ArrayList<>();
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
	
	public void push(int input) {
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
		// Answer of BackJoon no. 10828
		
		BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.parseInt(scan.readLine());
		Stack stack = new Stack();
		StringTokenizer st;
		
		while(count > 0) {
			st = new StringTokenizer(scan.readLine());
			String input = st.nextToken();
			
			switch(input) {
				case "empty" :
					System.out.println(stack.empty());
					
					break;
					
				case "size" :
					System.out.println(stack.size());
					
					break;
					
				case "push" :
					stack.push(Integer.parseInt(st.nextToken()));
					
					break;
					
				case "pop" :
					System.out.println(stack.pop());
					
					break;
					
				case "top" :
					System.out.println(stack.top());
					
					break;
					
			}
			count--;
		}

	}

}
