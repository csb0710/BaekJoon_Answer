package num_1937;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int count;
	static int[][] graph;
	static boolean[][] visit;
	static int[][] dp;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int max = 0;
	
	public static void dfs(int x, int y) {
		visit[x][y] = true;
		
		for(int i = 0; i < 4; i++) {
			int tempx = x + dx[i];
			int tempy = y + dy[i];
		
			if(tempx >= 0 && tempx < count && tempy >= 0 && tempy < count && (graph[x][y] < graph[tempx][tempy])) {
				if(visit[tempx][tempy]) {
					if(dp[tempx][tempy] + 1 > dp[x][y])
						dp[x][y] = dp[tempx][tempy] + 1;
				}
				else {
					dfs(tempx, tempy);
					if(dp[x][y] < dp[tempx][tempy]+1)
						dp[x][y] = dp[tempx][tempy]+1;
				}	
			}
		}
		
		if(max < dp[x][y]) {
			max = dp[x][y];
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// Answer of BaekJoon no. 1937
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		count = Integer.parseInt(br.readLine());
		
		graph = new int[count][count];
		visit = new boolean[count][count];
		dp = new int[count][count];
		
		for(int i = 0; i < count; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < count; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < count; i++) {
			for(int j = 0; j < count; j++) {
				if(!visit[i][j])
					dfs(i, j);
			}
		}
		
		System.out.println(max+1);

	}

}
