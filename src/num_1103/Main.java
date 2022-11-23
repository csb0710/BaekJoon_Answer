package num_1103;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
	static int r;
	static int c;
	static char[][] graph;
	static boolean[][] visit;
	static boolean[][] visit2;
	static int[][] dp;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static boolean flag = false;
	
	public static int dfs(int x, int y) {	
		if(flag) {
			return 0;
		}
		
		for(int i = 0; i < 4; i++) {
			int tempx = x + dx[i] * Character.getNumericValue(graph[x][y]);
			int tempy = y + dy[i] * Character.getNumericValue(graph[x][y]);
	
			if(tempx >= 0 && tempx < r && tempy >= 0 && tempy < c) {
				if(graph[tempx][tempy] == 'H') {	// 구멍일때
					dp[x][y] = Math.max(dp[x][y], 1);
					continue;
				}
				
				if(graph[tempx][tempy] == graph[x][y]) {	// 이동한 곳의 숫자가 같아 사이클 형성
					flag = true;
					return 0;
				}
				
				if(visit2[tempx][tempy]) {	// 사이클 형성
					flag = true;
					return 0;
				}
				
				if(visit[tempx][tempy]) {	// 이미 방문한 곳이면 구해진 값을 그대로 가져옴
					dp[x][y] = Math.max(dp[x][y], dp[tempx][tempy]+1);
					continue;
				}
				
				visit[tempx][tempy] = true;
				visit2[tempx][tempy] = true;
				dp[x][y] = Math.max(dp[x][y], dfs(tempx, tempy)+1);
				visit2[tempx][tempy] = false;
			}
			else {
				dp[x][y] = Math.max(dp[x][y], 1);
			}
			
		}

		return dp[x][y];
	}
	
	
	public static void main(String[] args) throws IOException {
		// Answer of BaekJoon no. 1103
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		graph = new char[r][c];
		visit = new boolean[r][c];
		visit2 = new boolean[r][c];
		dp = new int[r][c];
		
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
				dp[i][j] = -1;
			}
		}
		
		for(int i = 0; i < r; i++) {
			char[] temp = br.readLine().toCharArray();
			for(int j = 0; j < c; j++) {
				graph[i][j] = temp[j];
			}
		}
		
		visit[0][0] = true;
		visit2[0][0] = true;
		dfs(0,0);
		
		if(flag) {
			System.out.println(-1);
		}
		else {
			System.out.println(dp[0][0]);
		}
	}

}
