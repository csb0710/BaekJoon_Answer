package num_19238;

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
	int fuel;
	
	public Node(int x, int y, int time, int fuel) {
		this.x = x;
		this.y = y;
		this.time = time;
		this.fuel = fuel;
	}
}

public class Main {
	static int count_pass;
	static int fuel;
	static int count;
	static int[][] graph;
	static boolean[][] visit;
	static int time = 0;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static Node[] passen;
	static boolean in_pass = false;
	static int get_pas = 0;
	
	public static void bfs(int x, int y) {
		Queue<Node> q = new LinkedList<>();
		int desti_x = -1;
		int desti_y = -1;
		
		visit= new boolean[count][count];
		q.add(new Node(x, y, 0, fuel));
		visit[x][y] = true;
		
		while(!q.isEmpty()) {
			PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
				public int compare(Node o1, Node o2) {
					if(o1.x == o2.x) {
						return o1.y - o2.y;
					}
					return o1.x - o2.x;
				}
			});
			if(!in_pass) {
				int size = q.size();
				for(int j = 0; j < size; j++) {
					Node temp = q.poll();
					if(graph[temp.x][temp.y] > 1) {
						pq.add(new Node(temp.x, temp.y, 0, temp.fuel));
						break;
					}
					
					for(int i = 0; i < 4; i++) {
						int tempx = temp.x + dx[i];
						int tempy = temp.y + dy[i];
				
						if(tempx >= 0 && tempx < count && tempy >= 0 && tempy < count && !visit[tempx][tempy] && temp.fuel-1 > 0) {
							if(graph[tempx][tempy] != 1) {
								q.add(new Node(tempx, tempy, temp.time+1, temp.fuel-1));
								visit[tempx][tempy] = true;
							}
							if(graph[tempx][tempy] > 1) {
								pq.add(new Node(tempx, tempy, 0, temp.fuel-1));
							}
						}
					}
				}
				if(!pq.isEmpty()) {
					Node temp_ = pq.poll();
					q = new LinkedList<>();
					q.add(temp_);
					visit = new boolean[count][count];
					in_pass = true;
					desti_x = passen[graph[temp_.x][temp_.y]-1].x;
					desti_y = passen[graph[temp_.x][temp_.y]-1].y;
					graph[temp_.x][temp_.y] = 0;
					get_pas++;
				}
			}
			else {
				Node temp = q.poll();
				
				for(int i = 0; i < 4; i++) {
					int tempx = temp.x + dx[i];
					int tempy = temp.y + dy[i];
					if(tempx == desti_x && tempy == desti_y) {
						in_pass = false;
						visit = new boolean[count][count];
						q = new LinkedList<>();
						q.add(new Node(tempx, tempy, 0, (temp.fuel-1) + (temp.time+1)*2));
						fuel = (temp.fuel-1) + (temp.time+1)*2;
						break;
					}
					
					if(tempx >= 0 && tempx < count && tempy >= 0 && tempy < count && !visit[tempx][tempy]) {
						if(graph[tempx][tempy] != 1 && temp.fuel-1 > 0) {
							q.add(new Node(tempx, tempy, temp.time+1, temp.fuel-1));
							visit[tempx][tempy] = true;
						}
					}
				}
			}
			
			
		}
		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// Answer of BaekJoon no. 19238

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		count = Integer.parseInt(st.nextToken());
		count_pass = Integer.parseInt(st.nextToken());
		fuel = Integer.parseInt(st.nextToken());
		graph = new int[count][count];
		visit = new boolean[count][count];
		
		for(int i = 0; i < count; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < count; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
				
			}
		}
		
		st = new StringTokenizer(br.readLine());
		
		int startx = Integer.parseInt(st.nextToken()) -1;
		int starty = Integer.parseInt(st.nextToken()) -1;
		
		passen = new Node[count_pass+2];
		
		for(int i = 2; i < count_pass+2; i++) {
			st = new StringTokenizer(br.readLine());
			int tempx = Integer.parseInt(st.nextToken());
			int tempy = Integer.parseInt(st.nextToken());
			graph[tempx-1][tempy-1] = i;
			passen[i-1] = new Node(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1, 0, 0);
		}
		
		bfs(startx, starty);
	
		if(!in_pass && get_pas == count_pass) {
			System.out.println(fuel);
		}
		else {
			System.out.println(-1);
		}
	}

}
