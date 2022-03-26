package num_2193;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// Answer of BaeJoon no. 2193
		
		BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.parseInt(scan.readLine());
		long[] dp = new long[count+1];
		
		dp[1] = 1;
		for(int i = 2; i <= count; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		
		System.out.println(dp[count]);
		

	}

}
