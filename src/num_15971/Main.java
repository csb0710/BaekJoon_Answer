package num_15971;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
	int next;
	int v;
	int max;
	
	public Node(int n, int v, int m) {
		this.next = n;
		this.v = v;
		this.max = m;
	}
}

public class Main {

	public static void main(String[] args) throws IOException {
		// Answer of BaekJoon no. 15971
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int node = Integer.parseInt(st.nextToken());
		int f = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		
		ArrayList<Node>[] list = new ArrayList[node+1];
		boolean[] visit = new boolean[node+1];
		
		for(int i = 1; i < node+1; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < node-1; i++) {
			st = new StringTokenizer(br.readLine());
			
			int l = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			list[l].add(new Node(r, v, 0));
			list[r].add(new Node(l, v, 0));
		}
		
		Queue<Node> q = new LinkedList<>();
		Queue<Node> q2 = new LinkedList<>();
		
		q.add(new Node(f, 0, 0));
		visit[f] = true;
		
		int result = 0;
		boolean flag = false;
		
		while(!q.isEmpty()) {
			Node temp = q.poll();
			
			if(temp.next == s) {
				result = temp.v - temp.max;
				flag = true;
				break;
			}
			
			for(Node var : list[temp.next]) {
				if(visit[var.next])
					continue;
				
				int max = var.v;
				
				max = Math.max(temp.max, max);
				
				q.add(new Node(var.next, temp.v + var.v, max));
				visit[var.next] = true;
			}
		}
		
		System.out.println(result);

	}

}
