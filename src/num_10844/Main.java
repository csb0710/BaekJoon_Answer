package num_10844;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// Answer of BaekJoon no. 10844
		
		BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(scan.readLine());
		
		int[][] count = new int[N][10];
		int sum = 0;
		
		for(int i = 1; i < 10; i++)
			count[0][i] = 1;
		
		for(int i = 1; i < N; i++) {
			for(int j = 0; j < 10; j++) {
				if(j == 0) {
					count[i][j] = count[i-1][j+1]%1000000000;
				} 
				else if(j == 9) {
					count[i][j] = count[i-1][j-1]%1000000000;
				}
				else {
					count[i][j] = count[i-1][j-1]%1000000000+count[i-1][j+1]%1000000000;
				}
			}
		}
		
		for(int i = 0; i<10; i++) {
			sum += count[N-1][i]%1000000000;
			sum = sum%1000000000;
		}
		System.out.println(sum);
	}

}
