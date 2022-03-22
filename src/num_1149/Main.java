package num_1149;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// Answer of BaekJoon no. 1149
		
		BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.parseInt(scan.readLine());
		int[][] check = new int[count][3];
		int[][] dp = new int[count][3];
		for(int i = 0; i < count; i++) {
			String[] input = scan.readLine().split(" ");
			check[i][0] = Integer.parseInt(input[0]);
			check[i][1] = Integer.parseInt(input[1]);
			check[i][2] = Integer.parseInt(input[2]);
		}
		
		dp[0][0] = check[0][0];
		dp[0][1] = check[0][1];
		dp[0][2] = check[0][2];
		
		for(int i = 1; i < count; i++) {
			dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + check[i][0];
			dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + check[i][1];
			dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + check[i][2];
		}
		
		int min = Math.min(dp[count-1][0], dp[count-1][1]);
		min = Math.min(dp[count-1][2], min);
		
		System.out.println(min);
	}

}
