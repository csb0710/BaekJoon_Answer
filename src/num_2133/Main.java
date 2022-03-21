package num_2133;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// Answer of BaekJoon no. 2133
		BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(scan.readLine());
		int[] dp = new int[N+1];
		if(N%2 != 0) {
			System.out.println(0);
			return;
		}
			
		if(N >= 2)
			dp[2] = 3;
		if(N >= 4)
			dp[4] = 11;
		
		for(int i = 6; i <= N; i++) {
			dp[i] = dp[i-2] * 3;
			for(int j = 4; i-j > 0; j=j+2) {
				dp[i] += dp[i-j]*2;
			}
			dp[i] += 2;
		}
		
		System.out.println(dp[N]);
	}

}
