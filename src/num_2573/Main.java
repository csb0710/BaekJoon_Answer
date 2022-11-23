package num_2573;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
	int x;
	int y;
	
	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {
	static int r;
	static int c;
	static int[][] graph;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static boolean[][] visit;
	
	public static Node find() {
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
				if(graph[i][j] != 0) {
					return new Node(i, j);
				}
			}
		}
		
		return new Node(-1, -1);
	}
	
	public static void main(String[] args) throws IOException {
		// Answer of BaekJoon no. 2573
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		graph = new int[r][c];
		int ice = 0;
		
		for(int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < c; j++) {
				int temp = Integer.parseInt(st.nextToken());
				graph[i][j] = temp;
				if(temp != 0)
					ice += temp;
			}
		}
		
		Queue<Node> q = new LinkedList<>();
		int result = 0;
		boolean flag = false;
		
		while (ice > 0) {
			Node first = find();
			q.add(first);
			visit = new boolean[r][c];
			visit[first.x][first.y] = true;
			int temp_ice = 0;
			result++;
			
			while (!q.isEmpty()) {
				Node temp = q.poll();
				for (int i = 0; i < 4; i++) {
					int tempx = temp.x + dx[i];
					int tempy = temp.y + dy[i];
					if (tempx >= 0 && tempx < r && tempy >= 0 && tempy < c && !visit[tempx][tempy]) {
						if(graph[tempx][tempy] == 0) {
							if(graph[temp.x][temp.y] > 0) {
								graph[temp.x][temp.y]--;
								ice--;
							}
						}
						else {
							q.add(new Node(tempx, tempy));
							visit[tempx][tempy] = true;
						}
						
					}
				}
				temp_ice += graph[temp.x][temp.y];
			}
			if(temp_ice != ice) {
				result--;
				flag = true;
				break;
			}
		}
		

		if(flag) {
			System.out.println(result);
		}
		else {
			System.out.println(0);
		}

	}

}
