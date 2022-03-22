package num_1003;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
		int count = Integer.parseInt(scan.readLine());
		
		int[][] dp = new int[41][2];
		
		dp[0][0] = 1;
		if(count >= 1)
			dp[1][1] = 1;
		
		for(int i = 0; i < count; i++) {
			int input = Integer.parseInt(scan.readLine());
			for(int j = 2; j <= input; j++) {
				dp[j][0] = dp[j-1][0] + dp[j-2][0];
				dp[j][1] = dp[j-1][1] + dp[j-2][1];
			}
			bw.write(dp[input][0] + " " + dp[input][1] + "\n");
		}
		
		bw.flush();
		bw.close(); 
	}

}
