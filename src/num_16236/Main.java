package num_16236;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
	int x;
	int y;
	int time;
	
	public Node(int x, int y, int time) {
		this.x = x;
		this.y = y;
		this.time = time;
	}
}

public class Main {
	static int count;
	static int[][] graph;
	static boolean[][] visit;
	static int time = 0;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	public static void bfs(int x, int y) {
		Queue<Node> q = new LinkedList<>();
		int size = 2;
		int satiety = 0;
		
		q.add(new Node(x, y, 0));
		
		while(!q.isEmpty()) {
			int s_ize = q.size();
			PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
				public int compare(Node o1, Node o2) {
					if(o1.x == o2.x) {
						return o1.y - o2.y;
					}
					return o1.x - o2.x;
				}
			});
			for(int j = 0; j < s_ize; j++) {
				Node temp = q.poll();
				for(int i = 0; i < 4; i++) {
					int tempx = temp.x + dx[i];
					int tempy = temp.y + dy[i];
				
					if(tempx >= 0 && tempx < count && tempy >= 0 && tempy < count && !visit[tempx][tempy] && graph[tempx][tempy] <= size) {
						q.add(new Node(tempx, tempy, temp.time+1));
						visit[tempx][tempy] = true;
						if(graph[tempx][tempy] != 0 && graph[tempx][tempy] < size) {
							pq.add(new Node(tempx, tempy, temp.time+1));
						}
					}
				}
			}
			if(!pq.isEmpty()) {
				Node pqtemp = pq.poll();
				graph[pqtemp.x][pqtemp.y] = 0;
				q = new LinkedList<>();
				q.add(new Node(pqtemp.x, pqtemp.y, 0));
				satiety++;
				if(satiety == size) {
					satiety = 0;
					size++;
				}
				time += pqtemp.time;
				visit = new boolean[count][count];
				visit[pqtemp.x][pqtemp.y] = true;
			}
			
		}
		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// Answer of BaekJoon no. 16236
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		count = Integer.parseInt(br.readLine());
		graph = new int[count][count];
		visit = new boolean[count][count];
		
		int startx = 0;
		int starty = 0;
		
		for(int i = 0; i < count; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < count; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
				if(graph[i][j] == 9) {
					startx = i;
					starty = j;
					graph[i][j] = 0;
				}
			}
		}
		
		bfs(startx, starty);
		
		System.out.println(time);

	}

}
