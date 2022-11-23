package num_20040;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] parents;
	static int[] rank;
	
	public static int find(int x) {
		if(x == parents[x]) {
			return x;
		}
		else {
			return parents[x] = find(parents[x]);
		}
	}
	
	public static boolean union(int x, int y) {
		int px = find(x);
		int py = find(y);
		
		if(px == py) {
			return true;
		}
		
		if(rank[px] <= rank[py]) {
			parents[py] = parents[px];
			rank[px] += rank[py];
		}
		else {
			parents[px] = parents[py];
			rank[py] += rank[px];
		}
		
		return false;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		
		int dot = Integer.parseInt(st.nextToken());
		int count = Integer.parseInt(st.nextToken());
		
		parents = new int[dot];
		rank = new int[dot];
		
		for(int i = 0; i < dot; i++) {
			parents[i] = i;
		}
		Arrays.fill(rank, -1);
		
		int result = 0;
		
		for(int i = 0; i < count; i++) {
			st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			if(union(x, y)) {
				result = i+1;
				break;
			}
		} 
		
//		for(int i = 0; i < dot; i++) {
//			System.out.print(parents[i] + " ");
//		}
//		System.out.println();
		
		System.out.println(result);

	}

}
