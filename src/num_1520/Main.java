package num_1520;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int count = 0;
	static int[][] graph;
	static boolean[][] visit;
	static int[][] dp;
	static int x;
	static int y;
	public static int dfs(int tempx, int tempy) {
		if(tempx == x-1 && tempy == y-1) {
			return 1;
		}
		if(visit[tempx][tempy])
			return dp[tempx][tempy];
		
		for(int i = 0; i < 4; i++) {
			int curx = tempx + dx[i];
			int cury = tempy + dy[i];
			if(curx >= 0 && curx < x && cury >= 0 && cury < y) {
				if(graph[tempx][tempy] > graph[curx][cury]) {				
					dp[tempx][tempy] += dfs(curx,cury);
				}
			}
			
		}
		visit[tempx][tempy] = true;
		
		return dp[tempx][tempy];
	}

	public static void main(String[] args) throws IOException {
		// Answer of BaekJoon no. 1520
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		graph = new int[x][y];
		visit = new boolean[x][y];
		dp = new int[x][y];
		
		for(int i = 0; i < x; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < y; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0,0);
		
		System.out.println(dfs(0,0));

	}

}
