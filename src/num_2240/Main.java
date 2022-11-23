package num_2240;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// Answer of BaekJoon no. 2240
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int t = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int[][] dp = new int[w+1][2];
		
		int result = 1;
		
		for(int i = 0; i < t; i++) {
			int temp = Integer.parseInt(br.readLine());
			if(temp == 1) {
				for(int j = 2; j < w+1; j+=2) {
					dp[j][0] = Math.max(dp[j][0]+1, dp[j-1][1]+1);
				}
				dp[0][0]++;
			}
			else {
				for(int j = 1; j < w+1; j+=2) {
					dp[j][1] = Math.max(dp[j][1]+1, dp[j-1][0]+1);
				}
			}
		}
		
		for(int i = 0; i < w+1; i++) {
			int temp = Math.max(dp[i][0], dp[i][1]);
			result = Math.max(result, temp);
		}
		
		System.out.println(result);
		
	}

}
