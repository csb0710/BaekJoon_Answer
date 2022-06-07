package num_1238;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node> {
	int next;
	int weight;
	
	public Node(int next, int weight)  {
		this.next = next;
		this.weight = weight;
	}
	
	public int compareTo(Node n) {
        return this.weight - n.weight;
    }
}

public class Main {
	static int INF;
	static int[] distance;
	static boolean[] visit;
	static int start;
	static ArrayList<ArrayList<Node>> list = new ArrayList<>();
	static ArrayList<ArrayList<Node>> reverse_list = new ArrayList<>();
	
	static void dijkstra(ArrayList<ArrayList<Node>> list) {
		Arrays.fill(visit, false);
		Arrays.fill(distance, INF);
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
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
	}

	public static void main(String[] args) throws IOException {
		// Answer of BackJoon no. 1238

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int target = Integer.parseInt(st.nextToken());
		visit = new boolean[V+1]; 
		distance = new int[V+1];
		start = target;
		
		INF = 1000000000;
		
		for(int i = 0; i < V+1; i++) {
			list.add(new ArrayList<Node>());
			reverse_list.add(new ArrayList<Node>());
		}
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int u = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			list.get(v).add(new Node(u, w));
			reverse_list.get(u).add(new Node(v, w));
		}
		
		dijkstra(list);
		int[] target_dis = new int[V+1];
		
		for(int i = 1; i < V+1; i++) {
			target_dis[i] = distance[i];
		}
		
		dijkstra(reverse_list);
		
		int max = 0;
		
		for(int i = 1; i < V+1; i++) {
			if(i != target) {
				if(max < distance[i] + target_dis[i]) 
					max = distance[i] + target_dis[i];
			}
		}
		
		System.out.println(max);
	}

}
