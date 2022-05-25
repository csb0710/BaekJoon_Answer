package num_1916;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node {
	int next;
	int weight;
	
	public Node(int next, int weight) {
		this.next = next;
		this.weight = weight;
	}
}

public class Main {
	static int INF;
	
	public static void main(String[] args) throws IOException {
		// Answer of BaekJoon no. 1916
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		ArrayList<ArrayList<Node>> list = new ArrayList<>();
		boolean[] visit = new boolean[N+1]; 
		int[] distance = new int[N+1];
		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.weight-o2.weight);
		
		INF = (N-1)*(100000)+1;
		
		for(int i = 0; i < N+1; i++) {
			list.add(new ArrayList<Node>());
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int u = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			list.get(v).add(new Node(u, w));
			
		}
		
		st = new StringTokenizer(br.readLine());
		
		int start = Integer.parseInt(st.nextToken());
		int target = Integer.parseInt(st.nextToken());
		
		Arrays.fill(visit, false);
		Arrays.fill(distance, INF);
		
		distance[start] = 0;
		
		pq.offer(new Node(start, 0));
		
		while(!pq.isEmpty()) {
			int temp_node = pq.poll().next;
			
			if(visit[temp_node]) {
				continue;
			}
			visit[temp_node] = true;
			
			for(int i = 0; i < list.get(temp_node).size(); i++) {
				Node next_node = list.get(temp_node).get(i);
				
				if(distance[next_node.next] > distance[temp_node] + next_node.weight) {
					distance[next_node.next] = distance[temp_node] + next_node.weight;
					pq.add(new Node(next_node.next, distance[next_node.next]));
				}
			
			}
		}

		System.out.println(distance[target]);

	}

}
