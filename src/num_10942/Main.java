package num_10942;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// Answer of BaekJoon no. 10942
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int[][] dp = new int[n+1][n+1];
		int[] input = new int[n+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i < n+1; i++) {
			int temp = Integer.parseInt(st.nextToken());
			input[i] = temp;
			dp[i][i] = 1;
		}
		
		for(int i = 1; i < n+1; i++) {
			for(int j = 1; i+j < n+1; j++) {
				if(input[j] == input[i+j]) {
					if(i == 1) {
						dp[j][i+j] = 1;
					}
					else {
						if(dp[j+1][i+j-1] == 1) {
							dp[j][i+j] = 1;
						}
					}
				} 
			}
		}
		int count = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < count; i++) {
			st = new StringTokenizer(br.readLine());
			bw.append(dp[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] + "\n");
		}
		
		bw.flush();
		bw.close();
	}

}
