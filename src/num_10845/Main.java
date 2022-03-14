package num_10845;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Queue {
	private ArrayList<Integer> stack = new ArrayList<>();
	private int front = -1;
	private int rear = -1;
	
	public int empty() {
		if(rear == front) {
			return 1;
		}
		else {
			return 0;
		}
	}
	
	public int size() {
		return rear - front;
	}
	
	public void push(int x) {
		rear++;
		stack.add(x);
	}
	
	public int pop() {
		if(empty()==1) {
			return(-1);
		}
		front++;
		return stack.get(front);
	}
	
	public int front() {
		if(empty()==1)
			return -1;
		return stack.get((front+1));
	}
	
	public int back() {
		if(empty()==1)
			return -1;
		return stack.get(rear);
	}
	
	
}

public class Main {	
	public static void main(String[] args) throws NumberFormatException, IOException  {
		// Answer of BackJoon no. 10845
		
		BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.parseInt(scan.readLine());
		Queue queue = new Queue();
		StringTokenizer st;
		
		while(count > 0) {
			st = new StringTokenizer(scan.readLine());
			String input = st.nextToken();
			
			switch(input) {
				case "empty" :
					System.out.println(queue.empty());
					
					break;
					
				case "size" :
					System.out.println(queue.size());
					
					break;
					
				case "push" :
					queue.push(Integer.parseInt(st.nextToken()));
					
					break;
					
				case "pop" :
					System.out.println(queue.pop());
					
					break;
					
				case "front" :
					System.out.println(queue.front());
					
					break;
					
				case "back" :
					System.out.println(queue.back());
					
					break;
			}
			count--;
		}

	}

}
