package num_11000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node {
	int start;
	int end;
	
	public Node(int start, int end) {
		this.start = start;
		this.end = end;
	}

}

public class Main {

	public static void main(String[] args) throws IOException {
		// Answer of BaekJoon no. 11000
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		ArrayList<Integer> check_room = new ArrayList<>();
		PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
			public int compare(Node o1, Node o2) {
				if(o1.start == o2.start)
					return o1.end - o2.end;
				return o1.start - o2.start;
			}
		});
		PriorityQueue<Node> pq2 = new PriorityQueue<>(new Comparator<Node>() {
			public int compare(Node o1, Node o2) {
				return o1.end - o2.end;
			}
		});
		int count = 1;
		
		int num = Integer.parseInt(br.readLine());
		for(int i = 0; i < num; i++) {
			st = new StringTokenizer(br.readLine());
			pq.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		pq2.add(pq.poll());
		
		while(!pq.isEmpty()) {
			Node temp_class = pq.poll();
			if(pq2.peek().end > temp_class.start) {
				pq2.add(temp_class);
			}
			else {
				pq2.poll();
				pq2.add(temp_class);
			}
		}
		
		
		System.out.println(pq2.size());
		
		
	}

}
