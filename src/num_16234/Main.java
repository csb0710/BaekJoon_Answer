package num_16234;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
	int x;
	int y;
	
	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {
	static int size;
	static int l;
	static int r;
	static int[][] graph;
	static boolean[][] visit;
	static boolean flag;
	static Queue<Node> q;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};

	public static void bfs(int x, int y) {
		q = new LinkedList<>();
		Queue<Node> temp_q = new LinkedList<>();
		
		q.add(new Node(x, y));
		temp_q.add(new Node(x, y));
		visit[x][y] = true;
		int sum = graph[x][y];
		int count = 1;
	 	
		while(!q.isEmpty()) {
			Node temp = q.poll();
			
			for(int i = 0; i < 4; i++) {
				int tempx = temp.x + dx[i];
				int tempy = temp.y + dy[i];
			
				if(tempx >= 0 && tempx < size && tempy >= 0 && tempy < size && !visit[tempx][tempy]) {
					int temp_c = Math.abs(graph[temp.x][temp.y]-graph[tempx][tempy]);
					if(temp_c >= l && temp_c <= r) {
						sum += graph[tempx][tempy];
						count++;
						q.add(new Node(tempx, tempy));
						temp_q.add(new Node(tempx, tempy));
						visit[tempx][tempy] = true;
							
					}
				}
			}
		}
		
		if(temp_q.size() != 1) {
			flag = true;
		}
		
		while(!temp_q.isEmpty()) {
			int cal = sum / count;
			Node temp = temp_q.poll();
			graph[temp.x][temp.y] = cal;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		// Answer of BaekJoon no. 16234
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		size = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		
		graph = new int[size][size];
		
		flag = true;
		int count_all = 0;
		
		for(int i = 0; i < size; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < size; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		while(flag) {
			flag = false;
			visit = new boolean[size][size];
			for(int i = 0; i < size; i++) {
				for(int j = 0; j < size; j++) {
					if(!visit[i][j]) {
						bfs(i, j);
					}
				}
			}
			count_all++;
		}
		
		System.out.println(count_all-1);
	}

}
