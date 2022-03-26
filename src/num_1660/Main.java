package num_1660;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// Answer of BaekJoon no. 1660

		BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
		int input = Integer.parseInt(scan.readLine());
		int[] dp = new int[input+1];
		
		dp[1] = 1;
		
		for(int i = 2; i <= input; i++) {
			int min = 300000;
			int sum = 0;
			int sum2 = 0;
			for(int j = 1; sum2 <= i; j++) {
				sum += j;
				sum2 += sum;
				if(sum2 <= i) {
					if(min > dp[i-sum2]) {
						min = dp[i-sum2];
					}
				}
			}
			dp[i] = min + 1;
		}
		System.out.println(dp[input]);
	}

}
