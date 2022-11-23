package num_17141;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
	static int[][] graph;
	static int[][] graph2;
	static boolean[][] visit;
	static boolean[] visit2;
	static int m;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int result = Integer.MAX_VALUE;
	static int all;
	static ArrayList<Node> virus = new ArrayList<>();
	
	public static void find(int mm, int depth, int check) {
		if(mm == depth) {
			graph2 = new int[r][r];
			
			for(int i = 0; i < r; i++) {
				for(int j = 0; j < r; j++) {
					graph2[i][j] = graph[i][j];
				}
			}
			bfs();
			return;
		}

		for(int i = check+1; i < virus.size(); i++) {
			Node temp = virus.get(i);
			if(graph[temp.x][temp.y] == 2) {
				graph[temp.x][temp.y] = 3;
				find(mm, depth+1, i);
				graph[temp.x][temp.y] = 2;
			}
		}
	}
	
	public static void bfs() {
		Queue<Node> q = new LinkedList<>();
		visit = new boolean[r][r];
		
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < r; j++) {
				if(graph2[i][j] == 3) {
					q.add(new Node(i, j));
					visit[i][j] = true;
				}
			}
		}
		
		int count = 0;
		int temp2 = 0;
		
		while(!q.isEmpty()) {
			int size = q.size();
			count++;
			temp2 += size;
			
			for(int i = 0; i < size; i++) {
				Node temp = q.poll();
				
				for(int j = 0; j < 4; j++) {
					int tempx = temp.x + dx[j];
					int tempy = temp.y + dy[j];
					
					if(tempx < 0 || tempx >= r || tempy < 0 || tempy >= r) 
						continue;
					
					if(graph[tempx][tempy] == 1)
						continue;
					
					if(visit[tempx][tempy])
						continue;
					
					q.add(new Node(tempx, tempy));
					visit[tempx][tempy] = true;
					
				}
				
				
			}
			
		}
		//System.out.println(temp2);
		if(all == temp2) {
			result = Math.min(count-1, result);
		}
	}
	
	
	
	public static void main(String[] args) throws IOException {
		// Answer of BaekJoon no. 17141
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		graph = new int[r][r];
		visit = new boolean[r][r];
		all = 0;
		
		for(int i = 0; i < r; i++) {
			st= new StringTokenizer(br.readLine());
			for(int j = 0; j < r; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
				if(graph[i][j] != 1) {
					all++;
				}
				if(graph[i][j] == 2) {
					virus.add(new Node(i, j));
				}
			}
		}
		
		for(int i = 1; i < m+1; i++) {
			find(i, 0, -1);
		}
		
		if(result == Integer.MAX_VALUE) {
			System.out.println(-1);
		}
		else {
			System.out.println(result);
		}

	}

}
