package num_10775;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// Answer of BaekJoon no. 10775
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int ap_count = Integer.parseInt(br.readLine());
		int count = Integer.parseInt(br.readLine());
		
		int[] check = new int[ap_count+1];
		int[] ap = new int[count+1];
		
		for(int i = 1; i < count+1; i++) {
			 ap[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.fill(check, 0);
		
		boolean flag = false;
		int result = 0;
		
		for(int i = 1; i < count+1; i++) {
			int temp = ap[i];
			flag = false;
			
			for(int j = temp; j >= 1;) {
				if(check[j] == 0) {
					result++;
					check[temp] += 1;
					check[j] = 1;
					flag = true;
					break;
				}
				else {
					if(j != temp) {
						check[temp] += check[j];
					}
					j = j - check[j];
				}
			}
			
			if(!flag) {
				break;
			}
		}
		System.out.println(result);

	}

}
