package num_12852;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int[][] dp;
	static boolean[] visit;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static int dfs(int x) throws IOException {
		visit[x] = true;
		
		if(x == 1) {
			return 0;
		}
		
		if(x % 3 == 0) {
			int temp = x/3;
			if(!visit[temp]) {
				dp[x][0] = dfs(temp) + 1;
			}
			else {
				dp[x][0] = dp[temp][3] + 1;
			}
		}
		
		if(x % 2 == 0) {
			int temp = x/2;
			if(!visit[temp]) {
				dp[x][1] = dfs(temp) + 1;
			}
			else {
				dp[x][1] = dp[temp][3] + 1;
			}
		}
		
		int temp = x-1;
		if(!visit[temp]) {
			dp[x][2] = dfs(temp) + 1;
		}
		else {
			dp[x][2] = dp[temp][3] + 1;
		}
		
		return dp[x][3] = Math.min(Math.min(dp[x][0], dp[x][1]), dp[x][2]);
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// Answer of BaekJoon no. 12852
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int target = Integer.parseInt(br.readLine());
		
		dp = new int[target+1][4];
		visit = new boolean[target+1];
		
		for(int i = 0; i < target+1; i++) {
			dp[i][0] = 1000007;
			dp[i][1] = 1000007;
			dp[i][2] = 1000007;
		}
		
		dp[1][0] = 0;
		dp[1][1] = 0;
		dp[1][2] = 0;
		dp[1][3] = 0;
		
		System.out.println(dfs(target));
		
		int temp = target;
		
		while(temp != 0) {
			bw.append(temp + " ");
			if(Math.min(Math.min(dp[temp][0], dp[temp][1]), dp[temp][2]) == dp[temp][0]) {
				temp = temp/3;
			}
			else if(Math.min(Math.min(dp[temp][0], dp[temp][1]), dp[temp][2]) == dp[temp][1]) {
				temp = temp/2;
			}
			else {
				temp = temp-1;
			}
		}
		bw.flush();
		bw.close();
	}

}
