package num_11509;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
//		Answer of BaekJoon no. 11509
		
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st;
			
			int count = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			int[] array = new int[1000001];
			int result = 0;
			
			for(int i = 0; i < count; i++) {
				int temp = Integer.parseInt(st.nextToken());
				
				if(temp<1000000 && array[temp+1] > 0) {
					array[temp+1]--;
				}
				else {
					result++;
				}
				
				array[temp]++;
			}
			
			System.out.println(result);

	}

}
