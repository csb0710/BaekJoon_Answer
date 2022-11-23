package num_2467;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int count = Integer.parseInt(br.readLine());
		
		long[] input = new long[count];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < count; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		int left = 0;
		int right = count -1;
		
		int resultl = left;
		int resultr = right;
		
		long temp = 2000000001;
		int templ = left;
		int tempr = right;
		long result = 0;
		
		while(left < right) {
			result = input[left] + input[right];
			
			if(Math.abs(temp) > Math.abs(result)) {
				templ = left;
				tempr = right;
				temp = result;
			}

			
			if(result < 0) {
				left++;
			}
			else if(result == 0) {
				break;
			}
			else {
				right--;
			}
			
			
		}
		
		System.out.println(input[templ] + " " + input[tempr]);
	}

}
