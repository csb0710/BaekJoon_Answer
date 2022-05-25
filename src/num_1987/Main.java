package num_1987;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static boolean[] visit = new boolean[26];
	static char[][] graph;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int max = 0;
	
	public static void bfs(int i, int j, int count) {
		if(max < count) {
			max = count;
		}
		
		for(int k = 0; k < 4; k++) {
			if(graph[i + dx[k]][j + dy[k]] != '\u0000' && !visit[graph[i + dx[k]][j + dy[k]] - 65]) {
				visit[graph[i + dx[k]][j + dy[k]] - 65] = true;
				bfs(i + dx[k], j + dy[k] , count+1);
				visit[graph[i + dx[k]][j + dy[k]] - 65] = false;
			}
		}
		
		
	}

	public static void main(String[] args) throws IOException {
		// Answer of BaekJoon no. 1987

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		graph = new char[r+2][c+2];
		
		for(int i = 1; i < r+1; i++) {
			char[] temp = br.readLine().toCharArray();
			for(int j = 1; j < c+1; j++) {
				graph[i][j] = temp[j-1];
			}
		}
		
		visit[graph[1][1] - 65] = true;
		bfs(1, 1, 1);
		
		System.out.println(max);
		
		
	}

}
