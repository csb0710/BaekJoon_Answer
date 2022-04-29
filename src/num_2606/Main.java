package num_2606;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// Answer of BaekJoon no. 2606
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.parseInt(br.readLine());
		int input = Integer.parseInt(br.readLine());
		int[][] graph = new int[count+1][count+1];
		String[] insert;
		Queue<Integer> queue = new LinkedList<>();
		int result = 0;
		boolean[] bit = new boolean[count+1];
		
		for(int i = 1; i <= count; i++) {
			bit[i] = false;
		}
		for(int i = 1; i <= input; i++) {
			insert = br.readLine().split(" ");
			graph[Integer.parseInt(insert[0])][Integer.parseInt(insert[1])] = 1;
			graph[Integer.parseInt(insert[1])][Integer.parseInt(insert[0])] = 1;
		}
		
		bit[1] = true;
		queue.add(1);
		
		while(!queue.isEmpty()) {
			int check = queue.remove();
			
			for(int i = 1; i <= count; i++) {
				if(graph[check][i] == 1 && !bit[i]) {
					result++;
					queue.add(i);
					bit[i] = true;
				}
			}
		}
		
		System.out.println(result);
		
		
		

	}

}