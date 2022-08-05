package num_1509;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// Answer of BaekJoon no. 1509
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] input = br.readLine().toCharArray();
		int size = input.length;
		int[][] dp = new int[size][size];
		
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				dp[i][j] = 0;
			}
			dp[i][i] = 1;
		}
		
		int max = 0;
		int temp_i = 0;
		int min_y = 0;		
		for(int i = 1; i < size; i++) {
			for(int j = 0; i+j < size; j++) {
				if(input[j] == input[i+j]) {
					if(i == 1) {
						dp[j][i+j] = 1;
					}
					else {
						if(dp[j+1][i+j-1] != 0) {
							dp[j][i+j] = 1;
						}
					}
				}
			}
		}
		
		int[] dp2 = new int[size+1];
		
		Arrays.fill(dp2, 2001);
		
		dp2[0] = 0;
		
		for(int i = 1; i < size+1; i++) {
			dp2[i] = dp2[i-1] + 1;
			for(int j = 1; j < i; j++) {
				if(dp[j-1][i-1] == 1) {
					dp2[i] = Math.min(dp2[i], dp2[j-1]+1);
				}
			}
			
		}
		
		System.out.println(dp2[size]);

	}

}
