package num_3190;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		// Answer of BaekJoon no. 3190
		
		BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = scan.readLine().split(" ");
		int count = Integer.parseInt(input[0]);
		int wifi = Integer.parseInt(input[1]);
		int[] house = new int[count];
		int min = 1000000000;
		int max = 0;
		
		for(int i = 0; i < count; i++) {
			int temp = Integer.parseInt(scan.readLine());
			house[i] = temp;
		}
		
		Arrays.sort(house);
		
		int left = 1;
		int right = house[0] + house[count-1];
		int result = 0;
		
		while(left <= right) {
			int mid = (left+right)/2;
			int counting = 1;
			int check = house[0];
			
			for(int i = 0; i < count; i++) {
				
				if(house[i] - check >= mid) {
					counting++;
					check= house[i];
				}
			}
			
			if(counting >= wifi) {
				result = mid;
				left = mid + 1;
			}
			else {
				right = mid - 1;
			}
		}
		
		bw.write(result+"");
		bw.flush();
		bw.close();
		
	}

}
