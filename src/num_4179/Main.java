package num_4179;

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
		// Answer of BaekJoon no. 4179
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		boolean[][] visit = new boolean[r][c];
		Queue<Node> fire = new LinkedList<>();
		Queue<Node> sejun = new LinkedList<>();
		
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
				visit[i][j] = false;
			}
		}
		
		for(int i = 0; i < r; i++) {
			char[] temp = br.readLine().toCharArray();
			for(int j = 0; j < c; j++) {
				char temp_ch = temp[j];
				if(temp_ch == 'J') {
					sejun.add(new Node(i, j));
					visit[i][j] = true;
				}
				if(temp_ch == 'F') {
					fire.add(new Node(i, j));
					visit[i][j] = true;
				}
				if(temp_ch == '#') {
					visit[i][j] = true;
				}
			}
		}
		
		boolean end = false;
		int result = 0;
		
		while(!sejun.isEmpty()) {
			int sejun_size = sejun.size();
			int fire_size = fire.size();
			result++;
			
			for(int j = 0; j < fire_size; j++) {
				Node temp = fire.poll();
				
				for(int i = 0; i < 4; i++) {
					int tempx = temp.x + dx[i];
					int tempy = temp.y + dy[i];
					
					if(tempx >= 0 && tempx < r && tempy >= 0 && tempy < c) {
						if(!visit[tempx][tempy]) {
							fire.add(new Node(tempx, tempy));
							visit[tempx][tempy] = true;
						}
						
					}
					
				}
			}
			
			for(int j = 0; j < sejun_size; j++) {
				Node temp = sejun.poll();
				
				if(temp.x == r-1 || temp.x == 0 || temp.y == c-1 || temp.y == 0) {
					end = true;
					break;
				}
				
				for(int i = 0; i < 4; i++) {
					int tempx = temp.x + dx[i];
					int tempy = temp.y + dy[i];
					
					if(tempx >= 0 && tempx < r && tempy >= 0 && tempy < c) {
						if(!visit[tempx][tempy]) {
							sejun.add(new Node(tempx, tempy));
							visit[tempx][tempy] = true;
						}
						
					}
					
				}
			}
			
			if(end) {
				break;
			}
		}
		
		if(end) {
			System.out.println(result);
		}
		else {
			System.out.println("IMPOSSIBLE");
		}
		
		
		
		

	}

}
