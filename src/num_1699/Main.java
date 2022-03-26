package num_1699;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// Answer of BaekJoon no. 1699
		
		BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
		int input = Integer.parseInt(scan.readLine());
		int[] dp = new int[input+1];
		int min = 0;
		for(int i = 1; i <= input; i++) {
			min = 100000;
			for(int j = 1; j*j <= i; j++) {
				if(j*j == i) {
					min = 0;
					break;
				}
				if(min > dp[i-j*j]) {
					min = dp[i-j*j];
				}
			}
			dp[i] = min+1;
		}
		System.out.println(dp[input]);
	}

}
