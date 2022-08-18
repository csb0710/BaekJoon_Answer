package num_10775;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	static int[] parents;
	
	public static int find(int x) {
		if(parents[x] == -1) {
			return -1;
		}
		
		if(x == parents[x]) {
			return x;
		}
		
		return parents[x] = find(parents[x]);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int ap_count = Integer.parseInt(br.readLine());
		int count = Integer.parseInt(br.readLine());
		
		int[] ap = new int[count+1];
		parents = new int[ap_count+1];
		
		for(int i = 1; i < count+1; i++) { 
			 ap[i] = Integer.parseInt(br.readLine());
		}
		
		//Arrays.fill(check, 0);
		
		for(int i = 1; i < ap_count+1; i++) {
			parents[i] = i;
		}
		
		int result = 0;
		parents[0] = -1;
		
		for(int i = 1; i < count+1; i++) {
			int temp = ap[i];
			
			int top = find(temp);
			
			if(top == -1) {
				break;
			}
			
			result++;
			//parents[top] = find(top-1);
			parents[top] = parents[top-1];
			
		}
		
		System.out.println(result);

	}

}
