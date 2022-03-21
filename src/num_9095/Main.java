package num_9095;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// Answer of BaekJoon no. 9095
		
		BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.parseInt(scan.readLine());
		int[] inputs = new int[count+1];
		
		
		for(int i = 1; i <= count; i++)
			inputs[i] = Integer.parseInt(scan.readLine());
		
		Arrays.sort(inputs);
		int[] dp = new int[11];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		
		for(int i = 4; i < 11; i++) {
			dp[i] = dp[i-3] + dp[i-2] + dp[i-1];
		}
		
		for(int i = 1; i < inputs.length; i++) {
			System.out.println(dp[inputs[i]]);
		}

	}

}
