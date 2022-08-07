package num_16946;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
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
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};

	public static void main(String[] args) throws IOException {
		// Answer of BaekJoon no. 16946
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int[][] main_graph = new int[r][c];
		int[][] area_size = new int[r][c];
		Node[][] area = new Node[r][c];
		boolean[][] visit = new boolean[r][c];
		
		Queue<Node> q_wall = new LinkedList<>();
		Queue<Node> q_road = new LinkedList<>();
		Queue<Node> q_same_area = new LinkedList<>();
		
		for(int i = 0; i < r; i++) {
			char[] temp = br.readLine().toCharArray();
			for(int j = 0; j < c; j++) {
				main_graph[i][j] = Character.getNumericValue(temp[j]);
				if(temp[j] == '1') {
					q_wall.add(new Node(i, j));
				}
				else {
					q_road.add(new Node(i, j));
					
				}
			}
		}
		
		while(!q_road.isEmpty()) {
			Node temp2 = q_road.poll();
			
			if(visit[temp2.x][temp2.y])
				continue;
			
			int start_x = temp2.x;
			int start_y = temp2.y;
			area[start_x][start_y] = temp2;
			area_size[start_x][start_y] = 1;
			visit[start_x][start_y]= true;
			
			q_same_area.add(temp2);
			
			while(!q_same_area.isEmpty()) {
				Node temp = q_same_area.poll();
				for (int i = 0; i < 4; i++) {
					int tempx = temp.x + dx[i];
					int tempy = temp.y + dy[i];
					if (tempx >= 0 && tempx < r && tempy >= 0 && tempy < c && !visit[tempx][tempy]) {
						if(main_graph[tempx][tempy] == 0) {
							area_size[start_x][start_y]++;
							area[tempx][tempy] = temp2;
							visit[tempx][tempy] = true;
							q_same_area.add(new Node(tempx, tempy));
						}
					}
				}
			}
		}
		
		while(!q_wall.isEmpty()) {
			Node temp = q_wall.poll();
			
			ArrayList<Node> temp_list = new ArrayList<>();
			
			for (int i = 0; i < 4; i++) {
				int tempx = temp.x + dx[i];
				int tempy = temp.y + dy[i];
				if (tempx >= 0 && tempx < r && tempy >= 0 && tempy < c) {
					if(main_graph[tempx][tempy] == 0 && !temp_list.contains(area[tempx][tempy])) {
						main_graph[temp.x][temp.y] += area_size[area[tempx][tempy].x][area[tempx][tempy].y];
						temp_list.add(area[tempx][tempy]);
					}
				}
			}
		}
		
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
				bw.append(main_graph[i][j]%10 + "");
			}
			bw.append("\n");
		}
		
		bw.flush();
		bw.close();

	}

}
