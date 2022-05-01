package num_2178;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

class Node {
	int x;
	int y;
	int result;
	
	public Node(int x, int y, int result) {
		this.x = x;
		this.y = y;
		this.result = result;
	}
}
public class Main {

	public static void main(String[] args) throws IOException {
		// Answer of BaekJoon no. 2178
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Queue<Node> stack = new LinkedList<>();
		int result = 0;
		
		String[] input = br.readLine().split(" "); 
		int m = Integer.parseInt(input[0]);
		int n = Integer.parseInt(input[1]);
		
		int[][] maze = new int[m+2][n+2];
		boolean[][] bit = new boolean[m+2][n+2];
		
		for(int i = 0; i < m+2; i++) {
			for(int j = 0; j < n+2; j++) {
				bit[i][j] = false;
				maze[i][j] = 0;
			}
		}
		
		for(int i = 1; i < m+1; i++) {
			String[] insert = br.readLine().split("");
			for(int j = 1; j < n+1; j++) {
				maze[i][j] = Integer.parseInt(insert[j-1]);
			}
		}

		stack.add(new Node(1,1,0));
		bit[1][1] = true;
		while(!stack.isEmpty()) {
			Node node = stack.remove();
			int x = node.x;
			int y = node.y;
			int r = node.result+1;
			if(x == m && y == n) {
				result = r;
				break;
			}
			if(maze[x+1][y] == 1 && !bit[x+1][y]) {
				bit[x+1][y] = true;
				stack.add(new Node(x+1, y, r));
			}
			if(maze[x][y+1] == 1 && !bit[x][y+1]) {
				bit[x][y+1] = true;
				stack.add(new Node(x, y+1, r));
			}
			if(maze[x-1][y] == 1 && !bit[x-1][y]) {
				bit[x-1][y] = true;
				stack.add(new Node(x-1, y, r));
			}
			if(maze[x][y-1] == 1 && !bit[x][y-1]) {
				bit[x][y-1] = true;
				stack.add(new Node(x, y-1, r));
			}
		}
		
		System.out.println(result);
		
	}

}
