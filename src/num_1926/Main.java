package num_1926;
import java.io.*;
import java.util.*;

class Node {
	int x;
	int y;
	
	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {

	public static void main(String[] args) throws IOException {
		// Answer of BaekJoon no. 1926

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Queue<Node> stack = new LinkedList<>();
		int result = 0;
		int result2 = 0;
		
		String[] input = br.readLine().split(" "); 
		int m = Integer.parseInt(input[0]);
		int n = Integer.parseInt(input[1]);
		
		int[][] art = new int[m+2][n+2];
		boolean[][] bit = new boolean[m+2][n+2];
		
		for(int i = 0; i < m+2; i++) {
			for(int j = 0; j < n+2; j++) {
				bit[i][j] = false;
				art[i][j] = 0;
			}
		}
		StringTokenizer st;
		for(int i = 1; i < m+1; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j < n+1; j++) {
				art[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 1; i < m+2; i++) {
			for(int j = 1; j < n+2; j++) {
				if(art[i][j] == 1 && !bit[i][j]) {
					result2++;
					stack.add(new Node(i, j));
					bit[i][j] = true;
					int temp = 1;
					while(!stack.isEmpty()) {
						Node node = stack.remove();
						int x = node.x;
						int y = node.y;
						if(art[x+1][y] == 1 && !bit[x+1][y]) {
							bit[x+1][y] = true;
							stack.add(new Node(x+1, y));
							temp++;
						}
						if(art[x][y+1] == 1 && !bit[x][y+1]) {
							bit[x][y+1] = true;
							stack.add(new Node(x, y+1));
							temp++;
						}
						if(art[x-1][y] == 1 && !bit[x-1][y]) {
							bit[x-1][y] = true;
							stack.add(new Node(x-1, y));
							temp++;
						}
						if(art[x][y-1] == 1 && !bit[x][y-1]) {
							bit[x][y-1] = true;
							stack.add(new Node(x, y-1));
							temp++;
						}
					}
					if(temp > result) {
						result = temp;
					}
				}
			}
		}
		
		System.out.println(result2);
		System.out.println(result);
	}

}
