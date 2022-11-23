package num_9328;

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
	static int r;
	static int c;
	static char[][] graph;
	static boolean[] key;
	static boolean[][] visit;
	static ArrayList<Node>[] list;
	static StringTokenizer st;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int result;
	static Queue<Node> q; 
	
	public static void check_door(char door, int x, int y) {
		if(key[door-65]) {
			q.add(new Node(x, y));
			visit[x][y] = true;
		}
		else {
			list[door-65].add(new Node(x, y));
			visit[x][y] = true;
		}
	}
	
	public static void check_key(char key_) {
		if(!key[key_-97]) {
			key[key_-97] = true;
			
			for(int k = 0; k < list[key_-97].size(); k++) {
				q.add(list[key_-97].get(k));
			}
		}
	}
	
	
	public static void bfs() throws IOException {
		graph = new char[r][c];
		visit = new boolean[r][c];
		list = new ArrayList[26];
		key = new boolean[26];
		
		result = 0;
		
		q = new LinkedList<>();
		
		for(int i = 0; i < 26; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < r; i++) {
			char[] temp = br.readLine().toCharArray();
			for(int j = 0; j < c; j++) {
				graph[i][j] = temp[j];
				if((i == 0 || i == r-1) || (j == 0 || j == c-1)) {
					if(temp[j] == '.') {
						q.add(new Node(i, j));
						visit[i][j] = true;
					}
					else if(temp[j] >= 97 && temp[j] < 123) {
						check_key(temp[j]);
						q.add(new Node(i, j));
						visit[i][j] = true;
					}
					else if(temp[j] == '$') {
						result++;
						q.add(new Node(i, j));
						visit[i][j] = true;
					}
					else if(temp[j] >= 65 && temp[j] <= 90) {
						check_door(temp[j], i, j);
					}
					else {
						visit[i][j] = true;
					}
				}
			}
		}
		
		char[] input_key = br.readLine().toCharArray();
		if(input_key[0] != '0') {
			for(int i = 0; i < input_key.length; i++) {
				check_key(input_key[i]);
			}
		}
			
		while (!q.isEmpty()) {
			Node temp = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int tempx = temp.x + dx[i];
				int tempy = temp.y + dy[i];
				if (tempx >= 0 && tempx < r && tempy >= 0 && tempy < c && !visit[tempx][tempy]) {
					char temp_c = graph[tempx][tempy];
					if(temp_c == '.') {
						q.add(new Node(tempx, tempy));
						visit[tempx][tempy] = true;
					}
					else if(temp_c >= 97 && temp_c < 123) {
						check_key(temp_c);
						q.add(new Node(tempx, tempy));
						visit[tempx][tempy] = true;
					}
					else if(temp_c == '$') {
						result++;
						q.add(new Node(tempx, tempy));
						visit[tempx][tempy] = true;
					}
					else if(temp_c >= 65 && temp_c <= 90) {
						check_door(temp_c, tempx, tempy);
					}
					else {
						visit[tempx][tempy] = true;
					}
						
				}
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// Answer of BaekJoon no. 9328
		
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		int count = Integer.parseInt(br.readLine());
		
		
		for(int i = 0; i < count; i++) {
			st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			
			bfs();
			
			bw.append(result+"\n");
		}
		
		bw.flush();
		bw.close();
	}

}
