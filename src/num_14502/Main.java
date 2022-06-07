package num_14502;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int[][] graph;
	static int[][] temp_gr;
	static ArrayList<int[]> virusspot;
	static int n;
	static int m;
	static int max = 0;
	static int count = 0;
	
	public static void create_wall(int depth) {
		if(depth == 3) {
			temp_gr = new int[n+2][m+2];
			for(int i = 0; i < n+2; i++) {
				for(int j = 0; j < m+2; j++) {
					temp_gr[i][j] = graph[i][j];
				}
			}
			for(int[] var : virusspot) {
				spread_virus(var[0], var[1]);
			}
			get_max();
			return ;
		}
		
		for(int i = 1; i < n+1; i++) {
			for(int j = 1; j < m+1; j++) {
				if(graph[i][j] == 0) {
					graph[i][j] = 1;
					create_wall(depth+1);
					graph[i][j] = 0;
				}
			}
		}
	}
	
	public static void spread_virus(int q, int w) {
		for(int i = 0; i < 4; i++) {
			if(q > 0 && w > 0 && q < n+1 && w < m+1 && temp_gr[q+dx[i]][w+dy[i]] == 0) {
				temp_gr[q+dx[i]][w+dy[i]] = 2;
				spread_virus(q+dx[i], w+dy[i]);
			}
		}
		
	}
	
	public static void get_max() {
		count = 0;
		for(int i = 1; i < n+1; i++) {
			for(int j = 1; j < m+1; j++) {
				if(temp_gr[i][j] == 0) {
					count++;
				}
			}
		}
		if(count > max) {
			max = count;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		// Answer of BackJoon no. 14502
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		graph = new int[n+2][m+2];
		virusspot = new ArrayList<>();
		for(int i = 0; i < n+2; i++) {
			for(int j = 0; j < m+2; j++) {
				graph[i][j] = -1;
			}
		}
		int index = 0;
		for(int i = 1; i < n+1; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j < m+1; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
				if(graph[i][j] == 2) {
					virusspot.add(new int[]{i, j});
					index++;
				}
			}
		}
		
		create_wall(0);
		System.out.println(max);

	}

}