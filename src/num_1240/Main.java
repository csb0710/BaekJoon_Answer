package num_1240;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

class Node {
	int next;
	int value;
	
	public Node(int next, int value) {
		this.next = next;
		this.value = value;
	}
}

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static ArrayList<Node>[] list;
	static boolean[] visit;
	static int node;
	
	public static void dfs(int root, int target) throws IOException {
		visit = new boolean[node+1];
		
		Stack<Node> stack = new Stack<>();
		
		stack.add(new Node(root, 0));
		visit[root] = true;
		
		while(!stack.isEmpty()) {
			Node temp = stack.pop();
			
			for(int i = 0; i < list[temp.next].size(); i++) {
				Node temp_node = list[temp.next].get(i);
				
				if(temp_node.next == target) {
					bw.append(temp.value+temp_node.value +"\n");
					return;
				}
				
				if(!visit[temp_node.next]) {
					stack.add(new Node(temp_node.next, temp.value+temp_node.value));
					visit[temp_node.next] = true;
				}
			}
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// Answer of BaekJoon no. 1240
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		
		node = Integer.parseInt(st.nextToken());
		int quest = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[node+1];
		visit = new boolean[node+1];
		
		for(int i = 1; i <= node; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < node-1; i++) {
			st = new StringTokenizer(br.readLine());
			int f = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			list[f].add(new Node(s, v));
			list[s].add(new Node(f, v));
		}
		
		for(int i = 0; i < quest; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int target = Integer.parseInt(st.nextToken());
			
			dfs(start, target);
		}
		
		
		bw.flush();
		bw.close();
		

	}

}
