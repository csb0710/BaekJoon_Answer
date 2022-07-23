package num_3109;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
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
	static int[] dx = {1, 0, -1};

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Stack<Node> stack;
		
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int[][] graph = new int[r][c];
		boolean[][] visit = new boolean[r][c];
		
		for(int i = 0; i < r; i++) {
			char[] temp = br.readLine().toCharArray();
			for(int j = 0; j < c; j++) {
				if(temp[j] == '.') {
					graph[i][j] = 0;
				}
				else {
					graph[i][j] = 1;
				}
			}
		}
		
		int result = 0;
		
		for(int i = 0; i < r; i++) {
			stack = new Stack<>();
			stack.add(new Node(i, 0));
			while(!stack.isEmpty()) {
				Node temp = stack.pop();
				visit[temp.x][temp.y] = true;
				int count = 0;
				
				if(temp.y == c-1) {
					result++;
					break;
				}
				
				for(int j = 0; j < 3; j++) {
					int tempx = temp.x + dx[j];
					int tempy = temp.y+1;
					
					if (tempx >= 0 && tempx < r && tempy >= 0 && tempy < c && !visit[tempx][tempy]) {
						if(graph[tempx][tempy] == 0) {
							stack.add(new Node(tempx, tempy));
							
						}
						else {
							count++;
						}
					}
				}
				if(count == 3) {
					visit[temp.x][temp.y] = false;
				}
			}
		}
		
		System.out.println(result);
	}

}
