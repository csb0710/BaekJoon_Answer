package num_2513;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node {
	int x;
	int p;
	
	public Node(int x, int p) {
		this.x = x;
		this.p = p;
	}
}

public class Main {

	public static void main(String[] args) throws IOException {
		// Answer of BaekJoon no. 2513
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int apart = Integer.parseInt(st.nextToken());
		int bus = Integer.parseInt(st.nextToken());
		int school = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Node> pql = new PriorityQueue<>((o1, o2) -> o2.x - o1.x);
		PriorityQueue<Node> pqr = new PriorityQueue<>((o1, o2) -> o2.x - o1.x);
		
		int figure = 0;
		
		for(int i = 0; i < apart; i++) {
			st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			
			figure += p;
			
			if(x < school) {
				pql.add(new Node(school - x, p));
			}
			if(x > school) {
				pqr.add(new Node(x - school, p));
			}
		}
		
		int temp = bus;
		int result = 0;
		
		while(!pql.isEmpty()) {
			result += pql.peek().x * 2;
			while(!pql.isEmpty() && pql.peek().p <= temp) {
				temp -= pql.peek().p;
				pql.poll();
			}
			
			if(!pql.isEmpty() && temp > 0) {
				pql.peek().p -= temp;
			}
			
			temp = bus;
			
		}
		
		temp = bus;
		
		while(!pqr.isEmpty()) {
			result += pqr.peek().x * 2;
			while(!pqr.isEmpty() && pqr.peek().p <= temp) {
				temp -= pqr.peek().p;
				pqr.poll();
			}
			
			if(!pqr.isEmpty() && temp > 0) {
				pqr.peek().p -= temp;
			}
			
			temp = bus;		
		}

		
		System.out.println(result);
		
	}

}
