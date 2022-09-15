package num_5721;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int[][] dp;
		
	public static void main(String[] args) throws IOException {
		// Answer of BaekJoon no. 5721
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			if(r == 0 && c == 0) {
				break;
			}
			
			int[][] input = new int[r+1][c+1];
			dp = new int[r+1][c+1];
			
			for(int i = 1; i < r+1; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 1; j < c+1; j++) {
					input[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i = 1; i < r+1; i++) {
				dp[i][1] = input[i][1];
			}
			
			for(int i = 1; i < r+1; i++) {
				for(int j = 2; j < c+1; j++) {
					dp[i][j] = Math.max(dp[i][j-2] + input[i][j], dp[i][j-1]);
				}
			}
			
			for(int i = 2; i < r+1; i++) {
				dp[i][c] = Math.max(dp[i-2][c] + dp[i][c], dp[i-1][c]);
			}
			bw.append(dp[r][c] + "\n");
		}
		
		bw.flush();
		bw.close();
		
	}

}
