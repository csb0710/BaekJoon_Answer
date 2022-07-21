package num_2206;

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
	int range;
	int wall;
	
	public Node(int x, int y, int range, int wall) {
		this.x = x;
		this.y = y;
		this.range = range;
		this.wall = wall;
	}
}

public class Main {
	static boolean[][] visit;
	static boolean[][] visit2;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};

	public static void main(String[] args) throws IOException {
		// Answer of BaekJoon no. 2206
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		StringBuilder sb = new StringBuilder();
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		Queue<Node> q = new LinkedList<>();
		
		int[][] graph = new int[x][y];
		visit = new boolean[x][y];
		visit2 = new boolean[x][y];
		
		for(int i = 0; i < x; i++) {
			//st = new StringTokenizer(br.readLine(), "");
			String[] str = br.readLine().split("");
			for(int j = 0; j < y; j++) {
				//graph[i][j] = Integer.parseInt(st.nextToken());
				graph[i][j] = Integer.parseInt(str[j]);
			}
		}
		
		q.add(new Node(0, 0, 1, 0));
		visit[0][0] = true;
		boolean check = false;
		int result = 1000002;
		
		while(!q.isEmpty()) {
			Node temp = q.poll();
			for(int i = 0; i < 4; i++) {
				int tempx = temp.x + dx[i];
				int tempy = temp.y + dy[i];
				
				if(tempx == x-1 && tempy == y-1) {
					if(result > temp.range+1) {
						result = temp.range+1;
					}
					break;
				}
				
				if(tempx >= 0 && tempx < x && tempy >= 0 && tempy < y) {
					if(graph[tempx][tempy] == 1) {
						if(temp.wall == 0 && !visit2[tempx][tempy]) {
							q.add(new Node(tempx, tempy, temp.range+1, temp.wall+1));
							visit2[tempx][tempy] = true;
						}
					}
					else {
						if(temp.wall == 0 && !visit[tempx][tempy]) {
							q.add(new Node(tempx, tempy, temp.range+1, temp.wall));
							visit[tempx][tempy] = true;
						}
						else if(temp.wall == 1 && !visit2[tempx][tempy]) {
							q.add(new Node(tempx, tempy, temp.range+1, temp.wall));
							visit2[tempx][tempy] = true;
						}
						
					}
					
				}
			}
			
		}
		
		if(x == 1 && y == 1) {
			System.out.println(1);
		}
		else if(result == 1000002) {
			System.out.println(-1);
		}
		else {
			System.out.println(result);
		}

	}

}
