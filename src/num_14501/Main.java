package num_14501;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.parseInt(scan.readLine());
		int[][] check = new int[count+2][2];
		for(int i = 1; i <= count; i++) {
			String[] input = scan.readLine().split(" ");
			check[i][0] = Integer.parseInt(input[0]);
			check[i][1] = Integer.parseInt(input[1]);
		}
		int[] dp = new int[count+2];
		int max = 0;
		
		for(int i = count; i > 0; i--) {
			if(i + (check[i][0])-1 > count) {
				dp[i] = 0;
				dp[i] = max;
				continue;
			}
			else if(i != count) {
				dp[i] = dp[i + (check[i][0])] + check[i][1];
			}
			else if(i == count)
				dp[count] = check[count][1];
			if(max < dp[i]) {
				max = dp[i];
			}
			dp[i] = max;
		}
		System.out.println(max);
	}

}
