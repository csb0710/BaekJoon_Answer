package num_1202;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node {
	 int m;
	 int v;
	 
	 public Node(int m, int v) {
		 this.m = m;
		 this.v = v;
	 }
 }

public class Main {
	public static ArrayList<Long> size = new ArrayList<>();
	
	public static int search(int target) {
		int min = 0;
		int max = size.size();
		
		while(max > min)	{
			int mid = (min + max) / 2;
			if(size.get(mid) < target) 
				min = mid+1;
			else {
				max = mid;
			}
				
		}
		
		if(max < size.size()) {
			size.remove(max);
		}
		
		return max;
	}

	public static void main(String[] args) throws IOException {
		// Answer of BaekJoon no. 1202
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		ArrayList<Node> vosuck = new ArrayList<>();
		ArrayList<Integer> bag = new ArrayList<>();
		PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
			public int compare(Node o1, Node o2) {
				if(o2.v == o1.v)
					return o1.m - o2.m;
				return o2.v - o1.v;
			}
		});
		PriorityQueue<Node> pq2 = new PriorityQueue<>(new Comparator<Node>() {
			public int compare(Node o1, Node o2) {
				if(o1.m == o2.m)
					return o2.v - o1.v;
				return o1.m - o2.m;
			}
		});
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		long price = 0;
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			pq2.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			//vosuck.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		for(int i = 0; i < k; i++) {
			bag.add(Integer.parseInt(br.readLine()));
		}
		
		Collections.sort(bag);
		
		for(int var : bag) {
			while(!pq2.isEmpty() && pq2.peek().m <= var) {
				pq.add(pq2.poll());
			}
			
			if(!pq.isEmpty()) {
				price += pq.poll().v;
			}
		}
		
		System.out.println(price);
	}

}
