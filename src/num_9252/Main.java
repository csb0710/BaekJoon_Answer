package num_9252;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		// Answer of BaekJoon no. 9252
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Stack<Character> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		
		char[] input = br.readLine().toCharArray();
		char[] input2 = br.readLine().toCharArray();
		
		int r = input.length;
		int c = input2.length;
		
		int[][] dp = new int[r+1][c+1]; 
		
		for(int i = 0; i < r + 1; i++) {
			for(int j = 0; j < c+1; j++) {
				dp[i][j] = 0;
			}
		}
		
		for(int i = 1; i < r + 1; i++) {
			char temp = input[i-1];
			for(int j = 1; j < c + 1; j++) {
				if(temp == input2[j-1]) {
					dp[i][j] = dp[i-1][j-1] + 1;
				}
				else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		
		System.out.println(dp[r][c]);
		
		int i = r;
		int j = c;
		
		while(dp[i][j] != 0) {
			if(dp[i][j] == dp[i-1][j]) {
				i--;
			}
			else if(dp[i][j] == dp[i][j-1]) {
				j--;
			}
			else {
				stack.add(input[i-1]);
				i--;
				j--;
			}
		}
		
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		
		System.out.println(sb);

	}

}
