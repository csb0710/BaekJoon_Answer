package num_11404;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int[][] graph;
	static int INF = 10000001;
	public static void Floyd_Warshall() {
		for(int i = 1; i < graph.length; i++) {
			for(int j = 1; j < graph.length; j++) {
				if(i == j) {
					graph[i][i] = 0;
					continue;
				}
				for(int k = 1; k < graph.length; k++) {
					if(graph[j][k] > graph[j][i] + graph[i][k]) {
						graph[j][k] = graph[j][i] + graph[i][k];
					}
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		// Answer of BaekJoon no. 11404
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int v = Integer.parseInt(br.readLine());
		int e = Integer.parseInt(br.readLine());
		graph = new int[v+1][v+1];
		
		for(int i = 1; i < v+1; i++) {
			for(int j = 1; j < v+1; j++) {
				graph[i][j] = INF;
			}
		}
		
		for(int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			if(graph[a][b] > c) {
				graph[a][b] = c;
			}
		}
		
		Floyd_Warshall();
		
		for(int i = 1; i < v+1; i++) {
			for(int j = 1; j < v+1; j++) {
				if(graph[i][j] == INF) {
					bw.append(0 + " ");
				}
				else {
					bw.append(graph[i][j] + " ");
				}
			}
			if(i != v) {
				bw.append("\n");
			}
		}
		bw.flush();
		bw.close();

	}

}
