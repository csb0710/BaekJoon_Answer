package num_1600;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
	int x;
	int y;
	int r;
	int h;
	
	public Node(int x, int y, int r, int h) {
		this.x = x;
		this.y = y;
		this.r = r;
		this.h = h;
	}
}

public class Main {
	static int r;
	static int c;
	static int k;
	static int[][] graph;
	static boolean[][][] visit;
	static int result = 100000;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int[] dx_h = {-2,-2,2,2,-1,1,-1,1};
	static int[] dy_h = {-1,1,-1,1,-2,-2,2,2};
	
	public static void bfs() {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(0, 0, 0, 0));
		visit[0][0][0] = true;
		
		while(!q.isEmpty()) {
			Node temp = q.poll();
			for(int i = 0; i < 4; i++) {
				int tempx = temp.x + dx[i];
				int tempy = temp.y + dy[i];
				
				if(tempx == r-1 && tempy == c-1) {
					result = temp.r+1;
					return;
				}
				
				if(tempx >= 0 && tempx < r && tempy >= 0 && tempy < c) {
					if(graph[tempx][tempy] == 0) {
						if(!visit[tempx][tempy][temp.h]) {
							q.add(new Node(tempx, tempy, temp.r+1, temp.h));
							visit[tempx][tempy][temp.h] = true;
						}
					}
					
				}
				
			}
			if(temp.h < k) {
				for(int i = 0; i < 8; i++) {
					int tempx = temp.x + dx_h[i];
					int tempy = temp.y + dy_h[i];
				
					if(tempx == r-1 && tempy == c-1) {
						result = temp.r+1;
						return;
					}
				
					if(tempx >= 0 && tempx < r && tempy >= 0 && tempy < c) {
						if(graph[tempx][tempy] == 0 && !visit[tempx][tempy][temp.h+1]) {
							q.add(new Node(tempx, tempy, temp.r+1, temp.h+1));
							visit[tempx][tempy][temp.h+1] = true;
						}
					
					}
				
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		// Answer of BaekJoon no. 1600
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		k = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		c = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		
		graph = new int[r][c];
		visit = new boolean[r][c][k+1];
		
		for(int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < c; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		if(r*c == 1 && graph[r-1][c-1]==0) {
			System.out.println(0);
		}
		else {
			bfs();

			if(result == 100000) {
				System.out.println(-1);
			}
			else {
				System.out.println(result);
			}
		}
	}

}
