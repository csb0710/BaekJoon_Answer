package num_1904;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{
		// Answer of BaekJoon no.1904
		
		BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(scan.readLine());
		int[] input = new int[N];
		
		if(N == 1) {
			System.out.println("1");
			return;
		}
		input[0] = 1;
		input[1] = 2;
		
		for(int i = 2; i<N; i++) {
			input[i] = input[i-1]% 15746 + input[i-2]% 15746;
			input[i] = input[i]% 15746;
		}
		
		System.out.println(input[N-1]% 15746);
	}

}
