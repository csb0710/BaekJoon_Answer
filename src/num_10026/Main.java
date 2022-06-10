package num_10026;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static String[][] graph;
	static boolean[][] visit;
	static Queue<Integer> queuex = new LinkedList<>();
	static Queue<Integer> queuey = new LinkedList<>();
	static int[] dy = {0, 0, -1, 1};
	static int[] dx = {-1, 1, 0, 0};
	static int result1 = 0;
	static int result2 = 0;
	static int N;
	public static void bfs(int a, int b, String color) {
		queuex.add(a);
		queuey.add(b);
		visit[a][b] = true;
		
		while(!queuex.isEmpty()) {
			int x = queuex.poll();
			int y = queuey.poll();
			
			for(int i = 0; i < 4; i++) {
				int tempx = x + dx[i];
				int tempy = y + dy[i];
				if(tempx >= 0 && tempy >= 0 && tempx < N && tempy < N && !visit[tempx][tempy] && graph[tempx][tempy].equals(color)) {
					queuex.add(tempx);
					queuey.add(tempy);
					visit[tempx][tempy] = true;
				}
			}
		}
	}
	
	public static void bfs2(int a, int b, String color) {
		queuex.add(a);
		queuey.add(b);
		visit[a][b] = true;
		
		while(!queuex.isEmpty()) {
			int x = queuex.poll();
			int y = queuey.poll();
			
			for(int i = 0; i < 4; i++) {
				int tempx = x + dx[i];
				int tempy = y + dy[i];
				if(tempx >= 0 && tempy >= 0 && tempx < N && tempy < N && !visit[tempx][tempy]) {
					if(color.equals("R") || color.equals("G")) {
						if(!graph[tempx][tempy].equals("B")) {
							queuex.add(tempx);
							queuey.add(tempy);
							visit[tempx][tempy] = true;
							continue;
						}
					}
					if(graph[tempx][tempy].equals(color)) {
						queuex.add(tempx);
						queuey.add(tempy);
						visit[tempx][tempy] = true;
					}
				}
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// Answer of BaekJoon no. 10026
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		graph = new String[N][N];
		visit = new boolean[N][N];
		
		for(int i = 0; i < N; i++) {
			String[] temp = br.readLine().split("");
			for(int j = 0; j < N; j++) {
				graph[i][j] = temp[j];
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(!visit[i][j]) {
					bfs(i, j, graph[i][j]);
					result1++;
				}
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				visit[i][j] = false;
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(!visit[i][j]) {
					bfs2(i, j, graph[i][j]);
					result2++;
				}
			}
		}
		
		System.out.println(result1 + " " + result2);

	}

}
