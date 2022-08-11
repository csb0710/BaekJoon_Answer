package num_16933;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
	int x;
	int y;
	int range;
	int wall;
	boolean day;
	
	public Node(int x, int y, int range, int wall, boolean day) {
		this.x = x;
		this.y = y;
		this.range = range;
		this.wall = wall;
		this.day = day;
	}
}

public class Main {
	static boolean[][][] visit;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};

	public static void main(String[] args) throws IOException {
		// Answer of BaekJoon no. 14442
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		StringBuilder sb = new StringBuilder();
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		Queue<Node> q = new ArrayDeque<>();
		
		int[][] graph = new int[x][y];
		visit = new boolean[x][y][k+1];
		
		for(int i = 0; i < x; i++) {
			String[] str = br.readLine().split("");
			for(int j = 0; j < y; j++) {
				graph[i][j] = Integer.parseInt(str[j]);
			}
		}
		
		q.add(new Node(0, 0, 1, 0, true));
		visit[0][0][0] = true;
		int result = 1000002;
		
		while(!q.isEmpty()) {
			Node temp = q.poll();

			if(temp.x == x-1 && temp.y == y-1) {
				result = temp.range;
				break;
			}
			
			for(int i = 0; i < 4; i++) {
				int tempx = temp.x + dx[i];
				int tempy = temp.y + dy[i];
				
				if(tempx < 0 || tempx >= x || tempy < 0 || tempy >= y) {
					continue;
				}
				
				if(graph[tempx][tempy] > 0) {
					if(temp.wall < k && !visit[tempx][tempy][temp.wall+1]) {
						if(temp.day) {
							q.add(new Node(tempx, tempy, temp.range+1, temp.wall+1, !temp.day));
							visit[tempx][tempy][temp.wall+1] = true;
						}
						else {
							q.add(new Node(temp.x, temp.y, temp.range+1, temp.wall, !temp.day));
						}
					}
				}
				else {
					if(!visit[tempx][tempy][temp.wall]) {
						q.add(new Node(tempx, tempy, temp.range+1, temp.wall, !temp.day));
						visit[tempx][tempy][temp.wall] = true;
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