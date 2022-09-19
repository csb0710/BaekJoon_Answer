package num_17135;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
	int x;
	int y;
	int d;
	
	public Node(int x, int y, int d) {
		this.x = x;
		this.y = y;
		this.d = d;
	}
}

public class Main {
	static int[][] graph;
	static int[][] graph2;
	static boolean[] visit;
	static int r;
	static int c;
	static int range;
	static int[] units = new int[3];
	static int count;
	static Node[] re;
	static int[] dx = {0, 0, -1};
	static int[] dy = {-1, 1, 0};
	static int result = 0;
	
	public static void find(int depth, int prev) {
		if(depth == 3) {
			graph2 = new int[r][c];
			
			for(int i = 0; i < r; i++) {
				for(int j = 0; j < c; j++) {
					graph2[i][j] = graph[i][j];
				}
			}
			
			play();
			return;
		}
		
		for(int i = prev+1; i < c; i++) {
			if(!visit[i]) {
				visit[i] = true;
				units[depth] = i;
				find(depth+1, i);
				visit[i] = false;
			}
		}
		
		
	}
	
	public static void play() {
		int height = r;
		int count = 0;
		
		while(height > 0) {
			re = new Node[3];
			for(int i = 0; i < 3; i++) {
				re[i] = new Node(r, c, 0);
			}
			
			for(int i = 0; i < 3; i++) {
				shot(units[i], i, height);
			}
			
			for(int i = 0; i < 3; i++) {
				int tempx = re[i].x;
				int tempy = re[i].y;
				
				if(tempy == c)
					continue;
				if(graph2[tempx][tempy] == 1) {
					count++;
					graph2[tempx][tempy] = 0;
				}
			}
			
			height--;
		}
		
		result = Math.max(result, count);
	}
	
	public static void shot(int x, int index, int h) {
		Queue<Node> q = new LinkedList<>();
		boolean[][] area = new boolean[r+1][c];
		q.add(new Node(h, x, 0));
		area[h][x] = true;
		boolean flag = false;
		
		while(!q.isEmpty()) {
			
			int size = q.size();

			for(int j = 0; j < size; j++) {
				Node temp = q.poll();
				for(int i = 0; i < 3; i++) {
					int tempx = temp.x + dx[i];
					int tempy = temp.y + dy[i];
					if(tempx >=  h || tempx < 0 || tempy < 0 || tempy >= c) 
						continue;
					if(temp.d+1 > range) 
						continue;
					if(area[tempx][tempy])
						continue;

					q.add(new Node(tempx, tempy, temp.d+1));
					area[tempx][tempy] = true;
				
					if(graph2[tempx][tempy] == 1) {
						flag = true;
						if(re[index].y > tempy) {
							re[index].y = tempy;
							re[index].x = tempx;
						}
					}
				
				}
			}
			if(flag) {
				break;
			}
		}
	}
	
	public static void move(int count) {
		for(int i = r-1; i > count; i--) {
			for(int j = 0; j < c; j++) {
				if(graph[i][j] == 1) {
					graph[i][j] = 0;
					if(i < r-1) {
						graph[i+1][j] = 1;
					}
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		// Answer of BaekJoon no. 17135
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		range = Integer.parseInt(st.nextToken());
		
		visit = new boolean[c];
		graph = new int[r][c];
		
		for(int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < c; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		find(0, -1);
		
		System.out.println(result);

	}

}
