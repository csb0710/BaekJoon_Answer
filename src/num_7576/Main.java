package num_7576;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int[][] graph;
	static boolean[][] bit;
	static int counts = 0;
	static int max = 0;
	static Queue<Integer> queue = new LinkedList<>();
	static Queue<Integer> queue2 = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		// Answer of BaekJoon no. 7576
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputs = br.readLine().split(" ");
		int r = Integer.parseInt(inputs[0]);
		int c = Integer.parseInt(inputs[1]);
		
		graph = new int[c+2][r+2];
		bit = new boolean[c+2][r+2];
		int result = -1;
		
		for(int i = 0; i < c+2; i++) {
			for(int j = 0; j < r+2; j++) {
				graph[i][j] = -1;
				bit[i][j] = false;
			}
		}
		
		for(int i = 1; i <= c; i++) {
			String[] temp = br.readLine().split(" ");
			for(int j = 1; j <= r; j++) {
				graph[i][j] = Integer.parseInt(temp[j-1]);
			}
		}
		
		for(int i = 1; i <= c; i++) {
			for(int j = 1; j <= r; j++) {
				if(!bit[i][j] && graph[i][j] == 1) {
					queue.add(i);
					queue2.add(j);
				}
			}
		}
		
		while(!queue.isEmpty()) {
			result++;
			int size = queue.size();
			for(int k = 0; k < size; k++) {
				int i = queue.poll();
				int j = queue2.poll();
				
				if(!bit[i+1][j] && graph[i+1][j] == 0) {
					bit[i+1][j] = true;
					graph[i+1][j] = 1;
					queue.add(i+1);
					queue2.add(j);
				}
				if(!bit[i][j+1] && graph[i][j+1] == 0) {
					bit[i][j+1] = true;
					graph[i][j+1] = 1;
					queue.add(i);
					queue2.add(j+1);
				}
				if(!bit[i-1][j] && graph[i-1][j] == 0) {
					bit[i-1][j] = true;
					graph[i-1][j] = 1;
					queue.add(i-1);
					queue2.add(j);
				}
				if(!bit[i][j-1] && graph[i][j-1] == 0) {
					bit[i][j-1] = true;
					graph[i][j-1] = 1;
					queue.add(i);
					queue2.add(j-1);
				}
			}
		}
		
		
		
		boolean check = false;
		for(int i = 1; i <= c; i++) {
			for(int j = 1; j <= r; j++) {
				if(graph[i][j] == 0) {
					check = true;
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
