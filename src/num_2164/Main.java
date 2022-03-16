package num_2164;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

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
	
	
}

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// Answer of BaekJoon no. 2164
		ArrayList<Integer> list = new ArrayList<>();
		Queue queue = new Queue();
		BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
		
		int count = Integer.parseInt(scan.readLine());
		
		for(int i = 1; i <= count; i++) {
			queue.push(i);
		}
		
		while(queue.size() != 1) {
			queue.pop();
			queue.push(queue.pop());
			
		}
		System.out.println(queue.front());
	}

}
