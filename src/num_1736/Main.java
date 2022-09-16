package num_1736;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// Answer of BaekJoon no. 1736
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int[][] graph = new int[r][c];
		
		int all = 0;
		
		for(int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < c; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
				if(graph[i][j] == 1) {
					all++;
				}
			}
		}
		
		int result = 0;
		
		while(all > 0) {
			int sx = 0;
			int sy = 0;
			result++;
			
			while(sx < r) {
				int ly = sy;
				for(int i = sy; i < c; i++) {
					if(graph[sx][i] == 1) {
						ly = i;
						graph[sx][i] = 0;
						all--;
					}
				}
				
				sy = ly;
				sx++;
			}
		}
		
		
		System.out.println(result);
		

	}

}
