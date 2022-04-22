package num_2579;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// Answer of BaekJoon no. 9095
		
		BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.parseInt(scan.readLine());
		int[] inputs = new int[count+3];
		
		
		for(int i = 1; i <=count; i++)
			inputs[i] = Integer.parseInt(scan.readLine());
		
		int[] dp = new int[count+1];
		int[] check = new int[count+1];
		dp[1] = inputs[1];
		check[1] = 1;
		if(count > 1) {
			dp[2] = dp[1] + inputs[2];
		}
		if(count > 2) {
			dp[3] = Math.max(inputs[1], inputs[2]) + inputs[3];
		}
		for(int i = 4; i <= count; i++) {
			dp[i] = Math.max(dp[i-3] + inputs[i-1] + inputs[i], dp[i-2] + inputs[i]);
		}
		System.out.println(dp[count]);
	}

}
