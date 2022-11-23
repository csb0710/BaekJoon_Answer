package num_14503;

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
	
	public Node(int x, int y, int d) {
		this.x = x;
		this.y = y;
		this.d = d;
	}
}

public class Main {
	static boolean[][] visit;
	static int[][] graph;
	static int r;
	static int c;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int result;
	
	public static void bfs(int x, int y, int d) {
		Node muchine = new Node(x, y, d);
		Queue<Node> q = new LinkedList<>();
		
		q.add(muchine);
		visit[x][y] = true;
		result = 0;
		
		while(!q.isEmpty()) {
			Node temp = q.poll();
			result++;
			
			for(int i = 1; i < 5; i++) {
				int tempx = temp.x + dx[(temp.d - i + 4) % 4];
				int tempy = temp.y + dy[(temp.d - i + 4) % 4];
				
				if(tempx < 0 || tempx >= r || tempy < 0 || tempy >= c) {
					continue;
				}
				
				if(visit[tempx][tempy] || graph[tempx][tempy] == 1) {
					continue;
				}
				
				q.add(new Node(tempx, tempy, (temp.d - i + 4)%4));
				visit[tempx][tempy] = true;
				break;
			}
			
			if(q.isEmpty()) {
				int tempx = temp.x + dx[(temp.d - 2 + 4)%4];
				int tempy = temp.y + dy[(temp.d - 2 + 4)%4];
				
				if(tempx < 0 || tempx >= r || tempy < 0 || tempy >= c) {
					continue;
				}
				
				if(graph[tempx][tempy] == 1) {
					continue;
				}
				
				result--;
				q.add(new Node(tempx, tempy, temp.d));
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		// Answer of BaekJoon no. 14503
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		visit = new boolean[r][c];
		graph = new int[r][c];
		
		st = new StringTokenizer(br.readLine());
		
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < c; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		bfs(x, y, d);
		
		System.out.println(result);

	}

}
