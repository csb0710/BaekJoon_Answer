package num_10866;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Deque_2 {
	private LinkedList<Integer> deque = new LinkedList<>();
	
	public int empty() {
		if(deque.size() == 0)
			return 1;
		else
			return 0;
	}
	
	public int size() {
		return deque.size();
	}
	
	public void push_front(int input) {
		deque.addFirst(input);
	}
	
	public void push_back(int input) {
		deque.addLast(input);
	}
	
	public int pop_front() {
		if(empty() == 1)
			return -1;
		
		return deque.removeFirst();
	}
	
	public int pop_back() {
		if(empty() == 1) 
			return -1;
		
		return deque.removeLast();
	}
	
	public int front() {
		if(empty() == 1)
			return -1;
		
		return deque.getFirst();
	}
	
	public int back() {
		if(empty() == 1)
			return -1;
		
		return deque.getLast();
	}
}

public class ver_LinkedList {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.parseInt(scan.readLine());
		Deque_2 deque = new Deque_2();
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
