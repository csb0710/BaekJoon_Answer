package num_1726;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
	int x;
	int y;
	int d;
	int c;
	
	public Node(int x, int y, int d, int c) {
		this.x = x;
		this.y = y;
		this.d = d;
		this.c = c;
	}
}

public class Main {
	static int r;
	static int c;
	static boolean[][][] visit;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static int result = 0;
	static int[][] graph;
	
	public static void bfs(int x, int y, int d, int x2, int y2, int d2) {
		Queue<Node> q = new LinkedList<>();
		
		q.add(new Node(x, y, d, 0));
		visit[x][y][d] = true;
		
		while(!q.isEmpty()) {
			Node temp = q.poll();
			
			if(temp.x == x2 && temp.y == y2 && temp.d == d2) {
				result = temp.c;
				return ;
			}
			
			for(int i = 1; i < 4; i++) {
				int tempx = temp.x;
				int tempy = temp.y;
				
				if(temp.d == 0) {
					tempy += i; 
				}
				else if(temp.d == 2) {
					tempy -= i;
				}
				else if(temp.d == 1) {
					tempx += i;
				}
				else {
					tempx -= i;
				}
				
				if(tempx < 0 || tempx >= r || tempy < 0 || tempy >= c) 
					break;
				
				if(visit[tempx][tempy][temp.d])
					continue;
				
				if(graph[tempx][tempy] == 1) {
					break;
				}
				
				q.add(new Node(tempx, tempy, temp.d, temp.c+1));
				visit[tempx][tempy][temp.d] = true;
			}
			
			if(!visit[temp.x][temp.y][(temp.d + 1 + 4) % 4]) {
				q.add(new Node(temp.x, temp.y, (temp.d + 1 + 4) % 4, temp.c+1));
				visit[temp.x][temp.y][(temp.d + 1 + 4) % 4] = true;
			}
			if(!visit[temp.x][temp.y][(temp.d - 1 + 4) % 4]) {
				q.add(new Node(temp.x, temp.y, (temp.d - 1 + 4) % 4, temp.c+1));
				visit[temp.x][temp.y][(temp.d - 1 + 4) % 4] = true;
			}
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		// Answer of BaekJoon no. 1726
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		visit = new boolean[r][c][4];
		graph = new int[r][c];
		
		for(int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < c; j++) {
				int temp = Integer.parseInt(st.nextToken());
				if(temp == 1) {
					graph[i][j] = 1;
				}
			}
		}
		
		st = new StringTokenizer(br.readLine());
		
		int robot_x = Integer.parseInt(st.nextToken())-1;
		int robot_y = Integer.parseInt(st.nextToken())-1;
		int robot_d = Integer.parseInt(st.nextToken())-1;
		
		if(robot_d == 1) {
			robot_d = 2;
		}
		else if(robot_d == 2) {
			robot_d = 1;
		}
		
		st = new StringTokenizer(br.readLine());
		
		int tx = Integer.parseInt(st.nextToken())-1;
		int ty = Integer.parseInt(st.nextToken())-1;
		int td = Integer.parseInt(st.nextToken())-1;
		
		if(td == 1) {
			td = 2;
		}
		else if(td == 2) {
			td = 1;
		}
		
		bfs(robot_x, robot_y, robot_d, tx, ty, td);
		
		System.out.println(result);

	}

}
