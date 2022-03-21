package num_11726;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// Answer of BaekJoon no. 11726
		BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(scan.readLine());
		int result = 0;
		int[] dp = new int[N];
		dp[0] = 1;
		if(N >= 2)
			dp[1] = 2;
			
		
		for(int i = 2; i < N; i++) {
			dp[i] = dp[i-1]%10007 + dp[i-2]%10007;
			dp[i] = dp[i]%10007;
		}
		
		System.out.println(dp[N-1]);
	}

}
