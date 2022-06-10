package num_7569;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int[][][] graph;
	static boolean[][][] bit;
	static int counts = 0;
	static int max = 0;
	static Queue<Integer> queue = new LinkedList<>();
	static Queue<Integer> queue2 = new LinkedList<>();
	static Queue<Integer> queue3 = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		// Answer of BaekJoon no. 7569
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputs = br.readLine().split(" ");
		int r = Integer.parseInt(inputs[0]);
		int c = Integer.parseInt(inputs[1]);
		int h = Integer.parseInt(inputs[2]);
		
		graph = new int[h+2][c+2][r+2];
		bit = new boolean[h+2][c+2][r+2];
		int result = -1;
		
		for(int k = 0; k < h+2; k++) { 
			for(int i = 0; i < c+2; i++) {
				for(int j = 0; j < r+2; j++) {
					graph[k][i][j] = -1;
					bit[k][i][j] = false;
				}
			}
		}
		
		for(int k = 1; k <= h; k++) {
			for(int i = 1; i <= c; i++) {
				String[] temp = br.readLine().split(" ");
				for(int j = 1; j <= r; j++) {
					graph[k][i][j] = Integer.parseInt(temp[j-1]);
				}
			}
		}
		
		for(int k = 1; k <= h; k++) {
			for(int i = 1; i <= c; i++) {
				for(int j = 1; j <= r; j++) {
					if(!bit[k][i][j] && graph[k][i][j] == 1) {
						queue3.add(k);
						queue.add(i);
						queue2.add(j);
					}
				}
			}
		}
		
		while(!queue.isEmpty()) {
			result++;
			int size = queue.size();
			for(int k = 0; k < size; k++) {
				int i = queue.poll();
				int j = queue2.poll();
				int z = queue3.poll();
				
				if(i < 1 || j < 1 || z < 1 || i > c || j > r || z > h) {
					continue;
				}
				
				if(!bit[z][i+1][j] && graph[z][i+1][j] == 0) {
					bit[z][i+1][j] = true;
					graph[z][i+1][j] = 1;
					queue.add(i+1);
					queue2.add(j);
					queue3.add(z);
				}
				if(!bit[z][i][j+1] && graph[z][i][j+1] == 0) {
					bit[z][i][j+1] = true;
					graph[z][i][j+1] = 1;
					queue.add(i);
					queue2.add(j+1);
					queue3.add(z);
				}
				if(!bit[z][i-1][j] && graph[z][i-1][j] == 0) {
					bit[z][i-1][j] = true;
					graph[z][i-1][j] = 1;
					queue.add(i-1);
					queue2.add(j);
					queue3.add(z);
				}
				if(!bit[z][i][j-1] && graph[z][i][j-1] == 0) {
					bit[z][i][j-1] = true;
					graph[z][i][j-1] = 1;
					queue.add(i);
					queue2.add(j-1);
					queue3.add(z);
				}
				if(!bit[z+1][i][j] && graph[z+1][i][j] == 0) {
					bit[z+1][i][j] = true;
					graph[z][i][j-1] = 1;
					queue.add(i);
					queue2.add(j-1);
					queue3.add(z+1);
				}
				if(!bit[z-1][i][j] && graph[z-1][i][j] == 0) {
					bit[z-1][i][j] = true;
					graph[z-1][i][j] = 1;
					queue.add(i);
					queue2.add(j-1);
					queue3.add(z-1);
				}
			}
		}
		
		
		
		boolean check = false;
		for(int k = 1; k <= h; k++) {
			for(int i = 1; i <= c; i++) {
				for(int j = 1; j <= r; j++) {
					if(graph[k][i][j] == 0) {
						check = true;
					}
				}
			}
		}
		
		if(check) {
			System.out.println("-1");
		}
		else {
			System.out.println(result);
		}

	}

}
