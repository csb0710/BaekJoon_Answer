package num_16724;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
	int x;
	int y;
	int m;
	
	public Node(int x, int y, int m) {
		this.x = x;
		this.y = y;
		this.m = m;
	}
}

public class Main {
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int[][] graph;
	static boolean[][] visit;
	static Queue<Node> q = new LinkedList<>();
	static int r;
	static int c;
	static int result = 0;
	static int check = 4;
	
	public static void bfs(int x, int y) {
		q.add(new Node(x, y, graph[x][y]));
		visit[x][y] = true;
		
		while(!q.isEmpty()) {
			Node temp = q.poll();
			
			int tempx = temp.x + dx[temp.m];
			int tempy = temp.y + dy[temp.m];
			graph[temp.x][temp.y] = check;
			
			if(tempx >= 0 && tempx < r && tempy >= 0 && tempy < c) {
				if(visit[tempx][tempy]) {
					if(graph[tempx][tempy] == check) {	
						result++;
					}
					check++;
					return;
				}
				
				
				q.add(new Node(tempx, tempy, graph[tempx][tempy]));
				visit[tempx][tempy] = true;
			}
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		// Answer of BaekJoon no. 16724

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		graph = new int[r][c];
		visit = new boolean[r][c];
		
		for(int i = 0; i < r; i++) {
			char[] temp = br.readLine().toCharArray();
			for(int j = 0; j < c; j++) {
				if(temp[j] == 'L') {
					graph[i][j] = 2;
				}
				else if(temp[j] == 'R') {
					graph[i][j] = 3;
				}
				else if(temp[j] == 'U') {
					graph[i][j] = 0;
				}
				else {
					graph[i][j] = 1;
				}
			}
		}
		
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
				if(!visit[i][j]) {
					bfs(i, j);
//					System.out.println(i + " " + j);
				}
			}
		}
		
		System.out.println(result);
	}

}
