package num_1865;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;


class Node {
	int node;
	int weight;
	
	public Node(int node, int weight) {
		this.node = node;
		this.weight = weight;
	}
}

public class Main {
	static final int INF = 987654321;

	public static void main(String[] args) throws IOException {
		// Answer of BackJoon no. 1865
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int num = Integer.parseInt(br.readLine());
		for(int i = 0; i < num; i++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			int[][] edges = new int[N+1][N+1];
			int[] distance = new int[N+1];
			boolean check = false;
			
			Arrays.fill(distance, INF);
			
			for(int j = 0; j < N+1; j++) {
				for(int k = 0; k < N+1; k++) {
					edges[j][k] = INF;
				}
			}
			
			for(int j = 0; j < M; j++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int w = Integer.parseInt(st.nextToken());
				
				edges[a][b] = w;
				edges[b][a] = w;
			}
			
			for(int j = 0; j < W; j++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int w = Integer.parseInt(st.nextToken());
				
				edges[a][b] = -w;
			}
			
			//for(int z = 1; z < N+1; z++) {
				//Arrays.fill(distance, INF);
				distance[1] = 0;
				for(int j = 1; j < N+1; j++) {
					int temp_node = j;
					for(int k = 1; k < N+1; k++) {
						if(edges[j][k] != INF && distance[k] > distance[j] + edges[j][k]) {
							distance[k] = distance[j] + edges[j][k];
							if(j == N)
								check = true;
						}
					}
				}
//				if(distance[z] < 0) {
//					check = true;
//				}
//			}
			if(check) {
				bw.append("YES\n");
			}
			else {
				bw.append("NO\n");
			}
			
		}
		bw.flush();
		bw.close();
		

	}

}
