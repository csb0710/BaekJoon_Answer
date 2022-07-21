package num_1958;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Stack<Character> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		
		char[] input = br.readLine().toCharArray();
		char[] input2 = br.readLine().toCharArray();
		char[] input3 = br.readLine().toCharArray();
		
		int r = input.length;
		int c = input2.length;
		int z = input3.length;
		
		int[][][] dp = new int[r+1][c+1][z+1];
		
		for(int i = 0; i < r + 1; i++) {
			for(int j = 0; j < c+1; j++) {
				for(int k = 0; k < z+1; k++) {
					dp[i][j][k] = 0;
				}
			}
		}
		
		for(int i = 1; i < r + 1; i++) {
			for(int j = 1; j < c + 1; j++) {
				for(int k = 1; k < z + 1; k++) {
					if(input[i-1] == input2[j-1] && input[i-1] == input3[k-1]) {
						dp[i][j][k] = dp[i-1][j-1][k-1] + 1;
					}
					else {
						dp[i][j][k] = Math.max(Math.max(dp[i-1][j][k], dp[i][j-1][k]), dp[i][j][k-1]);
					}
				}
			}
		}
		
		System.out.println(dp[r][c][z]);

	}

}
