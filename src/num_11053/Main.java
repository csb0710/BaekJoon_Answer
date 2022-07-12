package num_11053;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// Answer of BaekJoon no. 11053
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int count = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int[] input = new int[count];
		int[] dp = new int[count];
		
		
		for(int i = 0; i < count; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		
		
		for(int i = 0; i < count; i++) {
			dp[i] = 1;
		}
		
		int max = 1;
		
		for(int i = 0; i < count; i++) {
			for(int j = 0; j < i; j++) {
				if(input[i] > input[j] && dp[j] > dp[i] - 1) {
					dp[i] = dp[j]+1;
				}
			}
			if(max < dp[i]) {
				max = dp[i];
			}
		}
		
		bw.append(max+"");
		bw.flush();
		bw.close();
			
	}

}
