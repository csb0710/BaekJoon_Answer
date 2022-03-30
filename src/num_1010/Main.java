package num_1010;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		// Answer of BaeJoon no.1010

		BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int[][] dp = new int[31][31];
		
		int count = Integer.parseInt(scan.readLine());
		
		while(count > 0) {
			String[] input = scan.readLine().split(" ");
			
			int r = Integer.parseInt(input[0]);
			int n = Integer.parseInt(input[1]);
			
			for(int i = 1; i <= n; i++) {
				for(int j = 0; j <= i; j ++) {
					if(i == j || j == 0) {
						dp[i][j] = 1;
					}
					else {
						dp[i][j] = dp[i-1][j] + dp[i-1][j-1];
					}
					if(i == n && j == r) {
						break;
					}
				}
			}
			bw.write(Integer.toString(dp[n][r]) + "\n");
			count--;
		}
		
		
		
		bw.flush();
		bw.close();
		
		
	}

}
