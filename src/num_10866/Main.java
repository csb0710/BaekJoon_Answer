package num_10866;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Deque {
	private int[] deque = new int[10000];
	private int front = 0;
	private int back = 0;
	private int size;
	
	public int empty() {
		if(front == back)
			return 1;
		else
			return 0;
	}
	
	public int size() {
		return back - front;
	}
	
	public void push_front(int input) {
		front--;
		int result = front;
		if(result < 0)
			result = front+deque.length;
		deque[result] = input;
	}
	
	public void push_back(int input) {
		int result = back;
		if(result < 0)
			result = back+deque.length;
		deque[result] = input;
		back++;
	}
	
	public int pop_front() {
		if(empty() == 1)
			return -1;
		int result = front;
		if(result < 0)
			result = front+deque.length;
		front++;
		return deque[result];
	}
	
	public int pop_back() {
		if(empty() == 1) 
			return -1;
		back--;
		int result = back;
		if(result < 0)
			result = back+deque.length;
		return deque[result];
	}
	
	public int front() {
		if(empty() == 1)
			return -1;
		int result = front;
		if(result < 0)
			result = front+deque.length;
		return deque[result];
	}
	
	public int back() {
		if(empty() == 1)
			return -1;
		int result = back-1;
		if(result < 0)
			result = result+deque.length;
		return deque[result];
	}
}

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.parseInt(scan.readLine());
		Deque deque = new Deque();
		StringTokenizer st;
		
		while(count > 0) {
			st = new StringTokenizer(scan.readLine());
			String input = st.nextToken();
			
			switch(input) {
				case "empty" :
					System.out.println(deque.empty());
					
					break;
					
				case "size" :
					System.out.println(deque.size());
					
					break;
					
				case "push_front" :
					deque.push_front(Integer.parseInt(st.nextToken()));
					
					break;
					
				case "push_back" :
					deque.push_back(Integer.parseInt(st.nextToken()));
					
					break;
					
				case "pop_front" :
					System.out.println(deque.pop_front());
					
					break;
					
				case "pop_back" :
					System.out.println(deque.pop_back());
					
					break;
					
				case "front" :
					System.out.println(deque.front());
					
					break;
					
				case "back" :
					System.out.println(deque.back());
					
					break;
			}
			count--;
		}
		

	}

}
