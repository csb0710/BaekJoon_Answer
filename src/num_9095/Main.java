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
		int[] inputs = new int[count+3];
		
		
		for(int i = count; i > 0; i--)
			inputs[i] = Integer.parseInt(scan.readLine());
		
		int[] dp = new int[count+1];
		int[] check = new int[count+1];
		dp[1] = inputs[1];
		check[1] = 1;
		
		for(int i = 2; i <= count; i++) {
			if(check[i-1] != 2) {
				if(dp[i-1] > dp[i-2]) {
					dp[i] = dp[i-1] + inputs[i];
					check[i] = 2;
				}
				else if(dp[i-1] < dp[i-2]) {
					dp[i] = dp[i-2] + inputs[i];
					check[i] = 1;
				}
				else {
					dp[i] = dp[i-1] + inputs[i];
					check[i] = 1;
				}
			}
			else {
				dp[i] = dp[i-2] + inputs[i];
				check[i] = 1;
			}
		}
		
		for(int i = 1; i <= count; i++) {
			System.out.println(dp[i]);
		}
		Arrays.sort(dp);
		System.out.println(dp[count]);
	}

}
