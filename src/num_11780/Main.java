package num_11780;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int[][] graph;
	static int INF = 10000001;
	static int[][] dis;
	static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();
	public static void Floyd_Warshall() {
		int index = 0;
		for(int i = 1; i < graph.length; i++) {
			for(int j = 1; j < graph.length; j++) {
				if(i == j) {
					graph[i][i] = 0;
					continue;
				}
				for(int k = 1; k < graph.length; k++) {
					if(graph[j][k] > graph[j][i] + graph[i][k]) {
						graph[j][k] = graph[j][i] + graph[i][k];
						list.get(index).add(i);
						if(dis[j][i] != 0) {
							dis[j][k] = dis[j][i];
							continue;
						}
						dis[j][k] = i;
					}
				}
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// Answer of BaekJoon no. 11404
		
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			StringTokenizer st;
				
			int v = Integer.parseInt(br.readLine());
			int e = Integer.parseInt(br.readLine());
			graph = new int[v+1][v+1];
			dis = new int[v+1][v+1];
				
			for(int i = 0; i < v*v+1; i++) {
				list.add(new ArrayList<Integer>());
			}
				
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
				bw.append("\n");
			}
				
			for(int i = 1; i < v+1; i++) {
				for(int j = 1; j < v+1; j++) {
					int count = 0;
					int temp = i;
					sb = new StringBuilder();
					while(dis[temp][j] != 0) {
						temp = dis[temp][j];
						count++;
						sb.append(temp + " ");
					}
					if(i == j || graph[i][j] == INF) {
						bw.append("0\n");
						continue;
					}
					bw.append(count+2 + " " + i + " ");
					bw.append(sb.toString());
					bw.append(j+"");
					bw.append("\n");
				}
			}
		
			bw.flush();
			bw.close();

	}

}
