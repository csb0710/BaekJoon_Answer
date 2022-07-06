package num_1261;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
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
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int[][] graph;
	static int[][] dst;
	static boolean[][] check;
	static int n;
	static int m;
	
	public static void bfs() {
		Deque<Node> deq = new LinkedList<>();
		deq.add(new Node(0, 0));
		check[0][0] = true;
		
		while(!deq.isEmpty()) {
			Node temp = deq.pollFirst();
			
			for(int i = 0; i < 4; i++) {
				int tempx = temp.x + dx[i];
				int tempy = temp.y + dy[i];
				
				if(tempx >= 0 && tempx < n && tempy >= 0 && tempy < m && !check[tempx][tempy]) {
					
					if(graph[tempx][tempy] == 1) {
						dst[tempx][tempy] = dst[temp.x][temp.y] + 1;
						deq.addLast(new Node(tempx, tempy));
					}
					else {
						dst[tempx][tempy] = dst[temp.x][temp.y];
						deq.addFirst(new Node(tempx, tempy));
					}
					
					if(tempx == n-1 && tempy == m-1)
						return ;
					
					check[tempx][tempy] = true;
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		// Answer of BaekJoon no. 1261
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		graph = new int[n][m];
		dst = new int[n][m];
		check = new boolean[n][m];
		
		for(int i = 0; i < n; i++) {
			String[] temp = br.readLine().split("");
			for(int j = 0; j < m; j++) {
				graph[i][j] = Integer.parseInt(temp[j]);
			}
		}
		
		bfs();
		
		System.out.println(dst[n-1][m-1]);

	}

}
