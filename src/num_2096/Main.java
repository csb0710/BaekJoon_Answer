package num_2096;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// Answer of BaekJoon no. 2096
		
		BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int count = Integer.parseInt(scan.readLine());
		int[][] dp_max = new int[count][3];
		int[][] dp_min = new int[count][3];
		int[][] dp = new int[count][3];
		String[] insert;
		
		insert = scan.readLine().split(" ");
		dp_max[0][0] = Integer.parseInt(insert[0]);
		dp_max[0][1] = Integer.parseInt(insert[1]);
		dp_max[0][2] = Integer.parseInt(insert[2]);
		dp_min[0][0] = Integer.parseInt(insert[0]);
		dp_min[0][1] = Integer.parseInt(insert[1]);
		dp_min[0][2] = Integer.parseInt(insert[2]);
	
		
		for(int i = 1; i < count; i++) {
			insert = scan.readLine().split(" ");
			dp_max[i][0] = Integer.parseInt(insert[0]) + Math.max(dp_max[i-1][0], dp_max[i-1][1]); 
			dp_max[i][1] = Integer.parseInt(insert[1]) + Math.max(dp_max[i-1][2], (Math.max(dp_max[i-1][0], dp_max[i-1][1])));
			dp_max[i][2] = Integer.parseInt(insert[2]) + Math.max(dp_max[i-1][1], dp_max[i-1][2]);
			dp_min[i][0] = Integer.parseInt(insert[0]) + Math.min(dp_min[i-1][0], dp_min[i-1][1]);
			dp_min[i][1] = Integer.parseInt(insert[1]) + Math.min(dp_min[i-1][2], (Math.min(dp_min[i-1][0], dp_min[i-1][1])));
			dp_min[i][2] = Integer.parseInt(insert[2]) + Math.min(dp_min[i-1][1], dp_min[i-1][2]);
			
		}
		
	
		
		int result_max = Math.max(dp_max[count-1][2], (Math.max(dp_max[count-1][0], dp_max[count-1][1])));
		int result_min = Math.min(dp_min[count-1][2], (Math.min(dp_min[count-1][0], dp_min[count-1][1])));
		
		bw.write(result_max+" "+ result_min);
		bw.flush();
		bw.close();
	}

}
