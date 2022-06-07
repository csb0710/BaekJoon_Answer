package num_1707;

import java.awt.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
	int next;
	int color;
	
	public Node(int next, int color)  {
		this.next = next;
		this.color = color;
	}
}

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// Answer of BaekJoon no.1707
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int num = Integer.parseInt(br.readLine());
		for(int i = 0; i < num; i++) {
			st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			ArrayList<ArrayList<Integer>> list = new ArrayList<>();
			Queue<Integer> queue = new LinkedList<>();
			boolean[] visit = new boolean[v+1];
			int[] color = new int[v+1];
			boolean flag = false;
			
			Arrays.fill(color, -1);
			Arrays.fill(visit, false);
			for(int j = 0; j < v+1; j++) {
				list.add(new ArrayList<Integer>());
			}
			
			for(int j = 0; j < e; j++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				list.get(a).add(b);
				list.get(b).add(a);
			}
			
			for (int j = 1; j < v+1; j++) {
				int check = 0;
				if(visit[j]) {
					continue;
				}
				queue.add(j);
				Arrays.fill(color, -1);
				color[j] = 0;
				while(!queue.isEmpty()) {
					int temp = queue.poll();
				
					if(visit[temp]) {
						continue;
					}
				
					visit[temp] = true;
				
					for(int var : list.get(temp)) {
						if(color[temp] == color[var]) {
							flag = true;
							break;
						}
						if(color[temp] == 0) {
							color[var] = 1;
						}
						else {
							color[var] = 0;
						}
						
						queue.add(var);
					}
				}
				if(flag) {
					break;
				}
				queue.clear();
			}
			if(flag) {
				bw.append("NO\n");
			}
			else {
				bw.append("YES\n");
			}
			queue.clear();
			
			
		}
		
		
		bw.flush();
		bw.close();

	}

}
