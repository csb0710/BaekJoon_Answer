package num_3055;

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
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};

	public static void main(String[] args) throws IOException {
		// Answer of BaekJoon no. 3055
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		Queue<Node> water = new LinkedList<>();
		Queue<Node> me = new LinkedList<>();
		boolean[][] visit = new boolean[r][c];
		int desti_x = 0;
		int desti_y = 0;
		
		for(int i = 0; i < r; i++) {
			char[] temp = br.readLine().toCharArray();
			for(int j = 0; j < c; j++) {
				if(temp[j] == '*') {
					water.add(new Node(i, j));
					visit[i][j] = true;
				}
				else if(temp[j] == 'S') {
					me.add(new Node(i, j));
					visit[i][j] = true;
				}
				else if(temp[j] == 'D') {
					desti_x = i;
					desti_y = j;
				}
				else if(temp[j] == 'X') {
					visit[i][j] = true;
				}
			}
			
		}
		boolean end = false;
		int result = 0;
		
		while(!me.isEmpty()) {
			int me_size = me.size();
			int water_size = water.size();
			result++;
			
			for(int j = 0; j < water_size; j++) {
				Node temp = water.poll();
				
				for(int i = 0; i < 4; i++) {
					int tempx = temp.x + dx[i];
					int tempy = temp.y + dy[i];
					
					if(tempx >= 0 && tempx < r && tempy >= 0 && tempy < c) {
						if(!visit[tempx][tempy] && !(tempx == desti_x && tempy == desti_y)) {
							water.add(new Node(tempx, tempy));
							visit[tempx][tempy] = true;
						}
						
					}
					
				}
			}
			
			for(int j = 0; j < me_size; j++) {
				Node temp = me.poll();
				
				for(int i = 0; i < 4; i++) {
					int tempx = temp.x + dx[i];
					int tempy = temp.y + dy[i];
					
					if(tempx >= 0 && tempx < r && tempy >= 0 && tempy < c) {
						if(tempx == desti_x && tempy == desti_y) {
							System.out.println(result);
							return;
						}
						
						if(!visit[tempx][tempy]) {
							me.add(new Node(tempx, tempy));
							visit[tempx][tempy] = true;
						}
						
					}
					
				}
			}
		}

		System.out.println("KAKTUS");

	}

}
