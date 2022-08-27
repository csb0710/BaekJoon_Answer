package num_16947;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

class Node {
	int prev;
	int temp;
	
	public Node(int p, int t) {
		this.prev = p;
		this.temp = t;
	}
}

public class Main {
	static ArrayList<Integer>[] list;
	static boolean[] visit;
	static ArrayList<Integer> cycle;
	static int count;
	static boolean[] check;
	static boolean is_cycle;
	static int start_node = 0;
	
	public static boolean dfs(int prev, int temp) {
		visit[temp] = true;
		System.out.println(prev + " " + temp);
		
		for(int next : list[temp]) {
			if(visit[next] && next != prev) {
				check[next] = true;
				start_node = next;
				return true;
			}
			
			if(!visit[next]) {
				if(dfs(temp, next)) {
					if(start_node == temp) {
						check[next] = true;
						return false;
					}
					else {
						check[next] = true;
						return true;
					}
				}
			}
			
		}
		
		return false;
	}
	
	public static int get_result(int x) {
		visit = new boolean[count+1];
		
		Queue<Integer> q = new LinkedList<>();
		q.add(x);
		visit[x] = true;
		int index = 1;
		
		
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i = 0; i < size; i++) {
				int temp = q.poll();
			
				for(int var : list[temp]) {
					if(visit[var]) {
						continue;
					}
					if(check[var]) {
						return index;
					}
					q.add(var);
					visit[var] = true;
				}
			}
			index++;
			
		}
		
		return 0;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// Answer of BaekJoon no. 16947
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		count = Integer.parseInt(br.readLine());
		list = new ArrayList[count+1];
		visit = new boolean[count+1];
		cycle = new ArrayList<>();
		check = new boolean[count+1];
		
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
		for(int i = 1; i < count+1; i++) {
			if(check[i]) {
				bw.append(0 + " ");
			}
			else {
				bw.append(get_result(i) + " ");
			}
		}
		
		bw.flush();
		bw.close();

	}

}
