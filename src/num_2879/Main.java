package num_2879;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// Answer of BaekJoon
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int count = Integer.parseInt(br.readLine());
		
		int[] cur = new int[count];
		int[] tar = new int[count];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < count; i++) {
			cur[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < count; i++) {
			tar[i] = Integer.parseInt(st.nextToken());
		}
		
		int sum = 0;
		
		for(int i = 0; i < count; i++) {
			cur[i] -= tar[i];
			sum += Math.abs(cur[i]);
		}
		
		int result = 0;
		int index = 10;
		int prev = cur[0];
		result += Math.abs(prev);
		
		for(int i = 1; i < count; i++) {
			if(prev * cur[i] < 0) {
				//result += Math.abs(prev);
				result += Math.abs(cur[i]);
			}
			else {
				if(Math.abs(prev) <= Math.abs(cur[i])) {
					result += Math.abs(cur[i]-prev);
				}
			}
			prev = cur[i];
			
		}
		
		System.out.println(result);
		

	}

}
