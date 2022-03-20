package num_1915;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// Answer of BaekJoon no. 1915
		
		BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
		String[] input = scan.readLine().split(" ");
		int m = Integer.parseInt(input[0]);
		int n = Integer.parseInt(input[1]);
		HashSet<Integer> set = new HashSet<>();
		int sum = 0;
		
		int[][] dp = new int[n][m];
		
		for(int i = 0; i < n; i++) {
			String temp = scan.readLine();
			for(int j = 0; j < m; j++) {
				dp[i][j] = Character.getNumericValue(temp.charAt(j));
			}
		}
		
		int min = Math.min(m, n);
		int max = Math.max(m, n);
		
		
		
		ArrayList list = new ArrayList(set);
		Collections.sort(list, Collections.reverseOrder());
		
		System.out.println(list.get(0));
		
	}

}
