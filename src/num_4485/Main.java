package num_4485;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node {
	int x;
	int y;
	int value;
	
	public Node(int x, int y, int v) {
		this.x = x;
		this.y = y;
		this.value = v;
	}
}

public class Main {
	static int[][] graph;
	static int[][] distance;
	static boolean[][] visit;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException {
		// Answer of BaekJoon no. 4485
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int index = 0;
		
		while(true) {
			int count = Integer.parseInt(br.readLine());
			index++;
			if(count == 0) {
				break;
			}
			PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.value - o2.value);
			
			distance = new int[count][count];
			graph = new int[count][count];
			visit = new boolean[count][count];
		
			for(int i = 0; i < count; i++) {
				for(int j = 0; j < count; j++) {
					distance[i][j] = 200000;
				}
			}
		
			for(int i = 0; i < count; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < count; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			pq.add(new Node(0, 0, graph[0][0]));
			distance[0][0] = graph[0][0];
			
			while(!pq.isEmpty()) {
				Node temp = pq.poll();
				
				for(int i = 0; i < 4; i++) {
					int tempx = temp.x + dx[i];
					int tempy = temp.y + dy[i];
					
					if(visit[temp.x][temp.y])
						continue;
					
					if(tempx < 0 || tempx >= count || tempy < 0 || tempy >= count)
						continue;
					
					if(distance[tempx][tempy] > distance[temp.x][temp.y] + graph[tempx][tempy]) {
						distance[tempx][tempy] = distance[temp.x][temp.y] + graph[tempx][tempy];
						pq.add(new Node(tempx, tempy, distance[tempx][tempy]));
					}
					
				}
				
				visit[temp.x][temp.y] = true;
				
			}
			bw.append("Problem " + index + ": " + distance[count-1][count-1] + "\n");
		}
		
		bw.flush();
		bw.close();
	}
		

}
