package num_16947;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
	int temp;
	int count;
	
	public Node(int t, int c) {
		this.temp = t;
		this.count = c;
	}
}

public class Main {
	static ArrayList<Integer>[] list;
	static boolean[] visit;
	static boolean[] visit2;
	static int count;
	static boolean[] check;
	static int start_node = 0;
	static int[] result;
	static Queue<Node> q = new LinkedList<>();
	
	public static boolean dfs(int prev, int temp) {
		visit[temp] = true;
		
		for(int next : list[temp]) {
			if(visit[next] && next != prev) {
				check[next] = true;
				start_node = next;
				result[next] = 0;
				q.add(new Node(next, 0));
				visit2[next] = true;
				return true;
			}
			
			if(!visit[next]) {
				if(dfs(temp, next)) {
					if(start_node == temp) {
						check[next] = true;
						result[next] = 0;
						q.add(new Node(next, 0));
						visit2[next] = true;
						return false;
					}
					else {
						check[next] = true;
						result[next] = 0;
						q.add(new Node(next, 0));
						visit2[next] = true;
						return true;
					}
				}
			}
			
		}
		
		return false;
	}
	
	
	public static void get_result() {
		visit = new boolean[count+1];
		//Queue<Node> q = new LinkedList<>();
		
//		for(int i = 1; i < count+1; i++) {
//			if(check[i]) {
//				q.add(new Node(i, 0));
//				visit[i] = true;
//				result[i] = 0;
//			}
//		}
		
		while(!q.isEmpty()) {
			Node temp = q.poll();
			
			for(int next : list[temp.temp]) {
				if(visit2[next])
					continue;
				
				result[next] = temp.count+1;
				q.add(new Node(next, temp.count+1));
				visit2[next] = true;
			}
		}
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// Answer of BaekJoon no. 16947
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		count = Integer.parseInt(br.readLine());
		list = new ArrayList[count+1];
		visit = new boolean[count+1];
		visit2 = new boolean[count+1];
		check = new boolean[count+1];
		result = new int[count+1];
		
		for(int i = 1; i < count+1; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < count; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			
			list[s].add(l);
			list[l].add(s);
		}
		
		dfs(0, 1);
		get_result();
		
		for(int i = 1; i < count+1; i++) {
			bw.append(result[i] + " ");
		}
		
		bw.flush();
		bw.close();

	}

}
