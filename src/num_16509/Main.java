package num_16509;

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
	static int[][] graph;
	static boolean[][] visit;
	static int x;
	static int y;
	static int kx;
	static int ky;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int[] dy1 = {1, -1, 2, -2};
	static int result = 0;
	
	public static void bfs() {
		Queue<Node> q = new LinkedList<>();
		
		q.add(new Node(x, y, 0));
		visit[x][y] = true;
		
		while(!q.isEmpty()) {
			Node temp = q.poll();
			
			if(temp.x == kx && temp.y == ky) {
				result = temp.d;
				return;
			}
			
			for(int i = 0; i < 4; i++) {
				int tempx = temp.x + dx[i];
				int tempy = temp.y + dy[i];
				
				if(tempx < 0 || tempx >= 10 || tempy < 0 || tempy >= 9) {
					continue;
				}
				if(tempx == kx && tempy == ky) {
					continue;
				}
				
				boolean left = false;
				boolean right = false;
				if(i == 0) {
					int tempx2 = tempx - 1;
					int tempy2 = tempy + dy1[0];
					
					left = true;
					
					if(tempx2 < 0 || tempx2 >= 10 || tempy2 < 0 || tempy2 >= 9) 
						left = false;
					if(tempx2 == kx && tempy2 == ky)
						left = false;
					
					tempx2 = tempx - 1;
					tempy2 = tempy + dy1[1];
					
					right = true;
					
					if(tempx2 < 0 || tempx2 >= 10 || tempy2 < 0 || tempy2 >= 9) 
						right = false;
					if(tempx2 == kx && tempy2 == ky)
						right = false;
					
					if(left) {
						tempx2 = tempx - 2;
						tempy2 = tempy + dy1[2];
						
						if(tempx2 >= 0 && tempx2 < 10 && tempy2 >= 0 && tempy2 < 9 && !visit[tempx2][tempy2]) {
							
							q.add(new Node(tempx2, tempy2, temp.d+1));
							visit[tempx2][tempy2] = true;
						}
					}
					
					if(right) {
						tempx2 = tempx - 2;
						tempy2 = tempy + dy1[3];
						
						if(tempx2 >= 0 && tempx2 < 10 && tempy2 >= 0 && tempy2 < 9 && !visit[tempx2][tempy2]) {
							
							q.add(new Node(tempx2, tempy2, temp.d+1));
							visit[tempx2][tempy2] = true;
						}
					}
				}
				else if(i == 1)	{
					int tempx2 = tempx +1;
					int tempy2 = tempy + dy1[0];
					
					left = true;
					
					if(tempx2 < 0 || tempx2 >= 10 || tempy2 < 0 || tempy2 >= 9) 
						left = false;
					if(tempx2 == kx && tempy2 == ky)
						left = false;
					
					tempx2 = tempx + 1;
					tempy2 = tempy + dy1[1];
					
					right = true;
					
					if(tempx2 < 0 || tempx2 >= 10 || tempy2 < 0 || tempy2 >= 9) 
						right = false;
					if(tempx2 == kx && tempy2 == ky)
						right = false;
					
					if(left) {
						tempx2 = tempx + 2;
						tempy2 = tempy + dy1[2];
						
						if(tempx2 >= 0 && tempx2 < 10 && tempy2 >= 0 && tempy2 < 9 && !visit[tempx2][tempy2]) {
							
							q.add(new Node(tempx2, tempy2, temp.d+1));
							visit[tempx2][tempy2] = true;
						}
					}
					
					if(right) {
						tempx2 = tempx + 2;
						tempy2 = tempy + dy1[3];
						
						if(tempx2 >= 0 && tempx2 < 10 && tempy2 >= 0 && tempy2 < 9 && !visit[tempx2][tempy2]) {
							
							q.add(new Node(tempx2, tempy2, temp.d+1));
							visit[tempx2][tempy2] = true;
						}
					}

				}
				else if(i == 2) {
					int tempy2 = tempy - 1;
					int tempx2 = tempx + dy1[0];
					
					left = true;
					
					if(tempx2 < 0 || tempx2 >= 10 || tempy2 < 0 || tempy2 >= 9) 
						left = false;
					if(tempx2 == kx && tempy2 == ky)
						left = false;
					
					tempx2 = tempx + dy1[1];
					tempy2 = tempy - 1;
					
					right = true;
					
					if(tempx2 < 0 || tempx2 >= 10 || tempy2 < 0 || tempy2 >= 9) 
						right = false;
					if(tempx2 == kx && tempy2 == ky)
						right = false;
					
					if(left) {
						tempx2 = tempx + dy1[2];
						tempy2 = tempy - 2;
						
						if(tempx2 >= 0 && tempx2 < 10 && tempy2 >= 0 && tempy2 < 9 && !visit[tempx2][tempy2]) {
							
							q.add(new Node(tempx2, tempy2, temp.d+1));
							visit[tempx2][tempy2] = true;
						}
					}
					
					if(right) {
						tempx2 = tempx + dy1[3];
						tempy2 = tempy - 2;
						
						if(tempx2 >= 0 && tempx2 < 10 && tempy2 >= 0 && tempy2 < 9 && !visit[tempx2][tempy2]) {
							
							q.add(new Node(tempx2, tempy2, temp.d+1));
							visit[tempx2][tempy2] = true;
						}
					}
				}
				else {
					int tempy2 = tempy + 1;
					int tempx2 = tempx + dy1[0];
					
					left = true;
					
					if(tempx2 < 0 || tempx2 >= 10 || tempy2 < 0 || tempy2 >= 9) 
						left = false;
					if(tempx2 == kx && tempy2 == ky)
						left = false;
					
					tempx2 = tempx + dy1[1];
					tempy2 = tempy + 1;
					
					right = true;
					
					if(tempx2 < 0 || tempx2 >= 10 || tempy2 < 0 || tempy2 >= 9) 
						right = false;
					if(tempx2 == kx && tempy2 == ky)
						right = false;
					
					if(left) {
						tempx2 = tempx + dy1[2];
						tempy2 = tempy + 2;
						if(tempx2 >= 0 && tempx2 < 10 && tempy2 >= 0 && tempy2 < 9 && !visit[tempx2][tempy2]) {
							
							q.add(new Node(tempx2, tempy2, temp.d+1));
							visit[tempx2][tempy2] = true;
						}
					}
					
					if(right) {
						tempx2 = tempx + dy1[3];
						tempy2 = tempy + 2;
						
						if(tempx2 >= 0 && tempx2 < 10 && tempy2 >= 0 && tempy2 < 9 && !visit[tempx2][tempy2]) {
							
							q.add(new Node(tempx2, tempy2, temp.d+1));
							visit[tempx2][tempy2] = true;
						}
					}
				}
			}
		}
		
		
	}
	
	public static void main(String[] args) throws IOException {
		// Answer of BaekJoon no. 16509
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		graph = new int[10][9];
		visit = new boolean[10][9];
		
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		kx = Integer.parseInt(st.nextToken());
		ky = Integer.parseInt(st.nextToken());
		
		bfs();
		
		System.out.println(result);

	}

}
