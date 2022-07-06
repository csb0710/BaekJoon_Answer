package num_1374;

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
	 int num;
	 
	 public Node(int start, int end) {
		 this.start = start;
		 this.end = end;
	 }
}

public class Main {

	public static void main(String[] args) throws IOException {
		// Answer of BaekJoon no. 1374
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
			public int compare(Node o1, Node o2) {
				return o1.start - o2.start;
			}
		});
		PriorityQueue<Node> pq2 = new PriorityQueue<>(new Comparator<Node>() {
			public int compare(Node o1, Node o2) {
				if(o1.end == o2.end) {
					return o1.start - o2.start;
				}
				return o1.end - o2.end;
			}
		});
		
		int count = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < count; i++) {
			st = new StringTokenizer(br.readLine());
			st.nextToken();
			pq.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		pq2.add(pq.poll());
		
		while(!pq.isEmpty()) {
			Node temp = pq.poll();
			if(pq2.peek().end > temp.start) {
				pq2.add(temp);
			}
			else {
				pq2.poll();
				pq2.add(temp);
			}
		}
		
		System.out.println(pq2.size());

	}

}
