package num_1072;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException{
		// Answer of BaekJoon no. 1072
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] input = br.readLine().split(" ");
		
		long all = Integer.parseInt(input[0]);
		long ago = Integer.parseInt(input[1]);
		long max = 1000000000;
		long min = 0;
		
		long first = ago*100/all;

		long result = 0;
		long temp = 0;
		
		if(first < 99) {
			while(min <= max) {
				long mid = (min + max)/2;
			
				temp = 100*(ago+mid)/(all+mid);
				if(first < temp) {
					max = mid-1;
					result = mid;
				}
				else {
					min = mid+1;
				}
			}
		}
		
		
		if(first >= 99) 
			result = -1;

		bw.write(result+"");
		bw.flush();
		bw.close();

	}

}
