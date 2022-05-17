package num_2667;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	static int[][] graph;
	static boolean[][] bit;
	static int counts = 0;
	
	public static void find(int i, int j) {
		bit[i][j] = true;
		counts++;
		
		if(!bit[i+1][j] && graph[i+1][j] == 1) {
			find(i+1, j);
		}
		if(!bit[i][j+1] && graph[i][j+1] == 1) {
			find(i, j+1);
		}
		if(!bit[i-1][j] && graph[i-1][j] == 1) {
			find(i-1, j);
		}
		if(!bit[i][j-1] && graph[i][j-1] == 1) {
			find(i, j-1);
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// Answer of BaekJoon 2667
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.parseInt(br.readLine());
		
		graph = new int[count+2][count+2];
		bit = new boolean[count+2][count+2];
		ArrayList<Integer> list = new ArrayList<>();
		int result = 0;
		
		for(int i = 0; i < graph.length; i++) {
			for(int j = 0; j < graph.length; j++) {
				graph[i][j] = 0;
				bit[i][j] = false;
			}
		}
		
		for(int i = 1; i <= count; i++) {
			String[] temp = br.readLine().split("");
			for(int j = 1; j <= count; j++) {
				graph[i][j] = Integer.parseInt(temp[j-1]);
			}
		}
		
		for(int i = 1; i <= count; i++) {
			for(int j = 1; j <= count; j++) {
				if(!bit[i][j] && graph[i][j] == 1) {
					counts = 0;
					result++;
					find(i,j);
					list.add(counts);
				}
			}
		}
		
		Collections.sort(list);
		
		System.out.println(result);
		for(int i= 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
	}

}
