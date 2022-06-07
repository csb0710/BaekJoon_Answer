package num_1504;

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
	static PriorityQueue<Node> pq;
	static int[] distance;
	static int INF;
	static ArrayList<ArrayList<Node>> list;
	
	
	public static void Dijkstra(int start) {
		pq = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);
		Arrays.fill(distance, INF);

		distance[start] = 0;

		pq.offer(new Node(start, 0));

		while (!pq.isEmpty()) {
			int temp_node = pq.poll().next;
			
			for (int i = 0; i < list.get(temp_node).size(); i++) {
				Node next_node = list.get(temp_node).get(i);

				if (distance[next_node.next] > distance[temp_node] + next_node.weight) {
					distance[next_node.next] = distance[temp_node] + next_node.weight;
					pq.add(new Node(next_node.next, distance[next_node.next]));
				}

			}
		}
	}

	public static void main(String[] args) throws IOException {
		// Answer of BaekJoon no. 1504
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String[] inputs = br.readLine().split(" ");
		int V = Integer.parseInt(inputs[0]);
		int E = Integer.parseInt(inputs[1]);
		list = new ArrayList<>(); 
		distance = new int[V+1];

		//INF = 987654321;
		INF = 400000001;
		for(int i = 0; i < V+1; i++) {
			list.add(new ArrayList<Node>());
		}
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int u = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			list.get(v).add(new Node(u, w));
			list.get(u).add(new Node(v, w));
		}
		
		st = new StringTokenizer(br.readLine());
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());
		
		Dijkstra(v1);
		
		long temp1;
		long temp2;
		long temp3;
		long temp4;
		long temp5;
		
		temp1 = distance[v2];
		temp2 = distance[V];
		
		Dijkstra(v2);
		
		temp3 = distance[V];
		
		Dijkstra(1);
		
		temp4 = distance[v1];
		temp5 = distance[v2];
		
		long result = Math.min(temp4+temp1+temp3, temp5+temp1+temp2);
		
		if(result >= INF) {
			System.out.println(-1);
		}
		else {
			System.out.println(result);
		}
		
	}

}
