package num_1463;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// Answer of BackJoon no. 1463
		
		BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
		int input = Integer.parseInt(scan.readLine());
		long[] dp = new long[input+1];
		
		dp[1] = 0;
		if(input >= 2)
			dp[2] = 1;
		for(int i = 3; i <= input; i++) {
			
			if(i % 3 == 1) {
				if(i % 2 == 0)
					dp[i] = 1 + Math.min(dp[(i-1)/3]+1, dp[i/2]);
				else
					dp[i] = 1 + Math.min(dp[(i-1)/3]+1, dp[(i-1)/2]+1);
			
			}
			else if(i % 3 == 2) {
				if(i % 2 == 0)
					dp[i] = 1 + Math.min(dp[(i-2)/3]+2, dp[i/2]);
				else
					dp[i] = 1 + Math.min(dp[(i-2)/3]+2, dp[(i-1)/2]+1);
			}
			else if(i % 3 == 0 && i % 2 == 0) {
				dp[i] = 1 + Math.min(dp[i/3], dp[i/2]);
			}
			else if(i % 3 == 0 && i % 2 != 0) {
				dp[i] = 1 + Math.min(dp[i/3], dp[(i-1)/2]+1);
			}
		}
		System.out.println(dp[input]);
	}

}
