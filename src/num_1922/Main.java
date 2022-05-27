package num_1922;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node> {
	int start;
	int end;
	int weight;
	
	public Node(int start, int end, int weight) {
		this.start = start;
		this.end = end;
		this.weight = weight;
	}

	@Override
	public int compareTo(Node o) {
		return this.weight >= o.weight ? 1:-1;
	}
}

public class Main {
	static boolean[] visit;

	public static void main(String[] args) throws IOException {
		// Answer of BaekJoon no. 1922
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		PriorityQueue<Node> pq = new PriorityQueue<>();
		ArrayList<ArrayList<Node>> list = new ArrayList<>();
		
		int result = 0;
		int v = Integer.parseInt(br.readLine());
		int e = Integer.parseInt(br.readLine());
		
		visit = new boolean[v+1];

		for(int i = 0; i < v+1; i++) {
			list.add(new ArrayList<Node>());
		}
		
		st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int start = a;
		
		list.get(a).add(new Node(a, b, c));
		list.get(b).add(new Node(b, a, c));
		
		for(int i = 1; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			
			list.get(a).add(new Node(a, b, c));
			list.get(b).add(new Node(b, a, c));
		}
		
		for(int i = 0; i < list.get(start).size(); i++) {
			pq.add(list.get(start).get(i));
		}
		visit[start] = true;
		
		while(!pq.isEmpty()) {
			Node temp = pq.poll();
			
			if(visit[temp.end]) {
				continue;
			}
			
			visit[temp.end] = true;
			result += temp.weight;
			
			for(int i = 0; i < list.get(temp.end).size(); i++) {
				pq.add(list.get(temp.end).get(i));
			}
			
		}
		
		System.out.println(result);

	}

}
