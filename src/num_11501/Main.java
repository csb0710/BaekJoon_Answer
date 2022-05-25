package num_11501;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// Answer of BaekJoon no. 11501
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int count = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < count; i++) {
			int fund = Integer.parseInt(br.readLine());
			int index = fund-1;
			long sum = 0;
			
			int[] inputs = new int[fund];
			int[] check = new int[10001];
			int[] temp = new int[fund];
			
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < fund; j++) {
				int temps = Integer.parseInt(st.nextToken());
				inputs[j] = temps;
				temp[j] = temps;
				
				check[temps]++;
			}
			
			Arrays.sort(temp);
			
			for(int j = 0; j < fund; j++) {
				if(inputs[j] < temp[index]) {
					check[inputs[j]]--;
					sum += temp[index]-inputs[j];
				}
				else {
					index--;
					while(index >= 0 && check[temp[index]] == 0) {
						index--;
					}
				}
			}
			
			bw.append(sum + "\n");
			
			
		}
		
		bw.flush();
		bw.close();

	}

}
