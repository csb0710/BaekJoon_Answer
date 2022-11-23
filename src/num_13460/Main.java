package num_13460;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
	int rx;
	int ry;
	int bx;
	int by;
	int move;
	
	public Node(int rx, int ry, int bx, int by, int move) {
		this.rx = rx;
		this.ry = ry;
		this.bx = bx;
		this.by = by;
		this.move = move;
	}
}

public class Main {
	static char[][] graph;
	static Node[][] visit;
	static boolean goal = false;
	static boolean bgoal = false;
	static int result = -1;
	
	public static Node moving(Node curr, int i) {
		int temprx = curr.rx;
		int tempry = curr.ry;
		int tempbx = curr.bx;
		int tempby = curr.by;
		boolean rch = false;
		boolean bch = false;
		
		if(i == 0) {
			if(temprx < tempbx) {
				while(graph[temprx][tempry] == '.' || graph[temprx][tempry] == 'O') {
					if(graph[temprx][tempry] == 'O') {
						rch = true;
						break;
					}
					temprx--;
				}
				if(!rch) {
					temprx++;
					graph[temprx][tempry] = 'R';
				}
				while(graph[tempbx][tempby] == '.' || graph[tempbx][tempby] == 'O') {
					if(graph[tempbx][tempby] == 'O') {
						bch = true;
						break;
					}
					tempbx--;
				}
				if(!rch) {
					graph[temprx][tempry] = '.';
				}
				tempbx++;
			}
			else {
				while(graph[tempbx][tempby] == '.' || graph[tempbx][tempby] == 'O') {
					if(graph[tempbx][tempby] == 'O') {
						bch = true;
						break;
					}
					tempbx--;
				}
				if(!bch) {
					tempbx++;
					graph[tempbx][tempby] = 'B';
				}
				while(graph[temprx][tempry] == '.' || graph[temprx][tempry] == 'O') {
					if(graph[temprx][tempry] == 'O') {
						rch = true;
						break;
					}
					temprx--;
				}
				if(!bch) {
					graph[tempbx][tempby] = '.';
				}
				temprx++;
			}
		}
		else if(i == 1) {
			if(temprx < tempbx) {
				while(graph[tempbx][tempby] == '.' || graph[tempbx][tempby] == 'O') {
					if(graph[tempbx][tempby] == 'O') {
						bch = true;
						break;
					}
					tempbx++;
				}
				if(!bch) {
					tempbx--;
					graph[tempbx][tempby] = 'B';
				}
				while(graph[temprx][tempry] == '.' || graph[temprx][tempry] == 'O') {
					if(graph[temprx][tempry] == 'O') {
						rch = true;
						break;
					}
					temprx++;
				}
				if(!bch) {
					graph[tempbx][tempby] = '.';
				}
				temprx--;
			}
			else {
				while(graph[temprx][tempry] == '.' || graph[temprx][tempry] == 'O') {
					if(graph[temprx][tempry] == 'O') {
						rch = true;
						break;
					}
					temprx++;
				}
				if(!rch) {
					temprx--;
					graph[temprx][tempry] = 'R';
				}
				while(graph[tempbx][tempby] == '.' || graph[tempbx][tempby] == 'O') {
					if(graph[tempbx][tempby] == 'O') {
						bch = true;
						break;
					}
					tempbx++;
				}
				if(!rch) {
					graph[temprx][tempry] = '.';
				}
				tempbx--;
			}
		}
		else if(i == 2) {
			if(tempry < tempby) {
				while(graph[temprx][tempry] == '.' || graph[temprx][tempry] == 'O') {
					if(graph[temprx][tempry] == 'O') {
						rch = true;
						break;
					}
					tempry--;
				}
				if(!rch) {
					tempry++;
					graph[temprx][tempry] = 'R';
				}
				while(graph[tempbx][tempby] == '.' || graph[tempbx][tempby] == 'O') {
					if(graph[tempbx][tempby] == 'O') {
						bch = true;
						break;
					}
					tempby--;
				}
				if(!rch) {
					graph[temprx][tempry] = '.';
				}
				tempby++;
			}
			else {
				while(graph[tempbx][tempby] == '.' || graph[tempbx][tempby] == 'O') {
					if(graph[tempbx][tempby] == 'O') {
						bch = true;
						break;
					}
					tempby--;
				}
				if(!bch) {
					tempby++;
					graph[tempbx][tempby] = 'B';
				}
				while(graph[temprx][tempry] == '.' || graph[temprx][tempry] == 'O') {
					if(graph[temprx][tempry] == 'O') {
						rch = true;
						break;
					}
					tempry--;
				}
				if(!bch) {
					graph[tempbx][tempby] = '.';
				}
				tempry++;
			}
		}
		else {
			if(tempry < tempby) {
				while(graph[tempbx][tempby] == '.' || graph[tempbx][tempby] == 'O') {
					if(graph[tempbx][tempby] == 'O') {
						bch = true;
						break;
					}
					tempby++;
				}
				if(!bch) {
					tempby--;
					graph[tempbx][tempby] = 'B';
				}
				while(graph[temprx][tempry] == '.' || graph[temprx][tempry] == 'O') {
					if(graph[temprx][tempry] == 'O') {
						rch = true;
						break;
					}
					tempry++;
				}
				if(!bch) {
					graph[tempbx][tempby] = '.';
				}
				tempry--;
			}
			else {
				while(graph[temprx][tempry] == '.' || graph[temprx][tempry] == 'O') {
					if(graph[temprx][tempry] == 'O') {
						rch = true;
						break;
					}
					tempry++;
				}
				if(!rch) {
					tempry--;
					graph[temprx][tempry] = 'R';
				}
				while(graph[tempbx][tempby] == '.' || graph[tempbx][tempby] == 'O') {
					if(graph[tempbx][tempby] == 'O') {
						bch = true;
						break;
					}
					tempby++;
				}
				if(!rch) {
					graph[temprx][tempry] = '.';
				}
				tempby--;
			}
		}
		
		if(rch && !bch) {
			goal = true;
		}
		if(bch) {
			bgoal = true;
		}
		
		return new Node(temprx, tempry, tempbx, tempby, curr.move+1);
	}
	
	public static void bfs(int rx, int ry, int bx, int by) {
		Queue<Node> q = new LinkedList<>();
		
		q.add(new Node(rx, ry, bx, by, 0));
		
		while(!q.isEmpty()) {
			Node temp = q.poll();
			
			for(int i = 0; i < 4; i++) {
				goal = false;
				bgoal = false;
				Node temp_move = moving(temp, i);
				
				if(bgoal) {
					continue;
				}
				
				if(temp_move.move > 10) {
					result = -1;
					return ;
				}
				
				
				if(goal) {
					result = temp_move.move;
					return ;
				}
				
				if(visit[temp_move.rx][temp_move.ry] != null && (visit[temp_move.rx][temp_move.ry].bx == temp_move.bx && visit[temp_move.rx][temp_move.ry].by == temp_move.by)) {
					continue;
				}
				
				q.add(temp_move);
				visit[temp_move.rx][temp_move.ry] = temp_move; 
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		// Answer of BaekJoon no. 13460
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()); 

		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int findrx = 0;
		int findry = 0;
		int findbx = 0;
		int findby = 0;
		
		graph = new char[r][c];
		visit = new Node[r][c];
		
		for(int i = 0; i < r; i++) {
			char[] temp = br.readLine().toCharArray();
			for(int j = 0; j < c; j++) {
				graph[i][j] = temp[j];
				if(temp[j] == 'R') {
					graph[i][j] = '.';
					findrx = i;
					findry = j;
				}
				if(temp[j] == 'B') {
					graph[i][j] = '.';
					findbx = i;
					findby = j;
				}
			}
			
		}
		
		bfs(findrx, findry, findbx, findby);
		
		System.out.println(result);
		
	}

}
