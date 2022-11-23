package num_6593;

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
	int z;
	int time;
	
	public Node(int z, int x, int y, int time) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.time = time;
	}
}

public class Main {
	static int[] dx = {-1,1,0,0,0,0};
	static int[] dy = {0,0,-1,1,0,0};
	static int[] dz = {0,0,0,0,-1,1};

	public static void main(String[] args) throws IOException {
		// Answer of BaekJoon no. 6593
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			
			if(!st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
			
			int floor = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			
			if(floor == 0 && r == 0 && c == 0) {
				break;
			}
			
			boolean[][][] visit = new boolean[floor][r][c];
			Queue<Node> q = new LinkedList<>();
			int z = -1;
			int x = -1;
			int y = -1;
			int result = 0;
			boolean flag = false;
			
			for(int i = 0; i < floor; i++) {
				for(int j = 0; j < r; j++) {
					String input = br.readLine();
					
					if(input.equals("")) 
                        input = br.readLine();
					
					char[] temp = input.toCharArray();
					for(int k = 0; k < c; k++) {
						if(temp[k] == 'S') {
							q.add(new Node(i, j, k, 0));
							visit[i][j][k] = true;
						}
						else if(temp[k] == '#') {
							visit[i][j][k] = true;
						}
						else if(temp[k] == 'E') {
							z = i;
							x = j;
							y = k;
						}
					}
				}
			}
			while(!q.isEmpty()) {
				Node temp = q.poll();
				
				for(int i = 0; i < 6; i++) {
					int tempz = temp.z + dz[i];
					int tempx = temp.x + dx[i];
					int tempy = temp.y + dy[i];
					
					if(tempz == z && tempx == x && tempy == y) {
						result = temp.time+1;
						flag = true;
						break;
					}
					
					if(tempx >= 0 && tempx < r && tempy >= 0 && tempy < c && tempz >= 0 && tempz < floor) {
						if(!visit[tempz][tempx][tempy]) {
							q.add(new Node(tempz, tempx, tempy, temp.time+1));
							visit[tempz][tempx][tempy] = true;
						}
						
					}
				}
			}
			if(flag) {
				bw.append("Escaped in " + result + " minute(s)." + "\n");
			}
			else {
				bw.append("Trapped!\n");
			}
		}
		
		bw.flush();
		bw.close();
	}

}
