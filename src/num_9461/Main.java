package num_9461;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// Answer of BaekJoon no. 9461
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int cases = Integer.parseInt(br.readLine());
		long[] dp;
		for(int i = 0; i < cases; i++) {
			int count = Integer.parseInt(br.readLine());
			dp = new long[count+1];
			dp[1] = 1;
			if(count > 1) {
				dp[2] = 1;
			}
			for(int j = 3; j <= count; j++) {
				dp[j] = dp[j-2] + dp[j-3];
			}
			bw.write(dp[count]+"\n");
		}
		bw.flush();
		bw.close();
		
	}

}
