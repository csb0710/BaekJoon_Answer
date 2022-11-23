package num_10282;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node {
	int next;
	int v;
	
	public Node(int n, int v) {
		this.next = n;
		this.v = v;
	}
}

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int count = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < count; i++) {
			st = new StringTokenizer(br.readLine());
			
			int node = Integer.parseInt(st.nextToken());
			int vertex = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			int result = 0;
			
			ArrayList<Node>[] list = new ArrayList[node+1];
			PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.v - o2.v);
			boolean[] visit = new boolean[node+1];
			int[] distance = new int[node+1];
			
			for(int j = 1; j < node+1; j++) {
				list[j] = new ArrayList<>();
				distance[j] = -1;
			}
			
			for(int j = 0; j < vertex; j++) {
				st = new StringTokenizer(br.readLine());
				
				int s = Integer.parseInt(st.nextToken());
				int l = Integer.parseInt(st.nextToken());
				int t = Integer.parseInt(st.nextToken());
				
				list[l].add(new Node(s, t));
			}
			
			pq.add(new Node(start, 0));
			distance[start] = 0;
			
			
			while(!pq.isEmpty()) {
				Node cur = pq.poll();
				
				if(visit[cur.next]) {
					continue;
				}
				
				visit[cur.next] = true;
				result++;
				
				for(Node next : list[cur.next]) {
					if(distance[next.next] == -1 || distance[next.next] > distance[cur.next] + next.v) {
						distance[next.next] = distance[cur.next] + next.v;
						pq.add(new Node(next.next, distance[next.next]));
					}
				}
			}
			
			int max = 0;
			
			for(int j = 1; j < node+1; j++) {
				max = Math.max(max, distance[j]);
			}
			
			bw.append(result + " " + max + "\n");
		}
		
		
		bw.flush();
		bw.close();
	}

}
