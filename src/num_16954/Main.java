package num_16954;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Node {
	int x;
	int y;
	
	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {
	static int[] dx = {-1,1,0,0,-1,1,-1,1,0};
	static int[] dy = {0,0,-1,1,-1,1,1,-1,0};
	static char[][] graph;
	static boolean[][] visit;
	static boolean[][] wall_visit;
	static Queue<Node> q = new LinkedList<>();
	static Queue<Node> wall = new LinkedList<>();
	static boolean flag = false;
	
	public static void bfs() {
		while(!q.isEmpty()) {
			int q_size = q.size();
			System.out.println(q_size);
			for(int j = 0; j < q_size; j++) {
				Node temp = q.poll();
				
				if(graph[temp.x][temp.y] == '#') {
					continue;
				}
				
				if(temp.x == 0 && temp.y == 7) {
					flag = true;
					return ;
				}
			
				System.out.println(temp.x + " " + temp.y);
				
				for(int i = 0; i < 9; i++) {
					int tempx = temp.x + dx[i];
					int tempy = temp.y + dy[i];
				
					if (tempx >= 0 && tempx < 8 && tempy >= 0 && tempy < 8 && !visit[tempx][tempy]) {
						if(graph[tempx][tempy] == '.') {
							q.add(new Node(tempx, tempy));
							visit[tempx][tempy] = true;
						}
					}
				}
			}
			
			int wall_size = wall.size();
			
			for(int i = 0; i < wall_size; i++) {
				Node temp = wall.poll();
				
				int tempx = temp.x+1;
				
				if(!wall_visit[temp.x][temp.y])
					graph[temp.x][temp.y] = '.';
				
				if(tempx <= 7) {
					graph[tempx][temp.y] = '#';
					wall.add(new Node(tempx, temp.y));
					wall_visit[tempx][temp.y] = true;
				}
			}
			
			for(int i = 0; i < 8; i++) {
				for(int j = 0; j < 8; j++) {
					visit[i][j] = false;
					wall_visit[i][j] = false;
				}
			}
			
			for(int i = 0; i < 8; i++) {
				for(int j = 0; j < 8; j++) {
					System.out.print(graph[i][j]);
				}
				System.out.println();
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) throws IOException {
		// Answer of BaekJoon no. 16954
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		graph = new char[8][8];
		visit = new boolean[8][8];
		wall_visit = new boolean[8][8];
		
		for(int i = 0; i < 8; i++) {
			char[] temp = br.readLine().toCharArray();
			for(int j = 0; j < 8; j++) {
				graph[i][j] = temp[j];
				if(temp[j] == '#') {
					wall.add(new Node(i, j));
				}
			}
		}
		
		q.add(new Node(7, 0));
		
		bfs();
		
		if(flag) {
			System.out.println(1);
		}
		else {
			System.out.println(0);
		}
		
	}

}
