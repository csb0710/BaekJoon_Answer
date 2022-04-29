package num_1260;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// Answer of BaekJoon no. 1260
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] input = br.readLine().split(" ");
		int count = Integer.parseInt(input[0]);
		int edge = Integer.parseInt(input[1]);
		int start = Integer.parseInt(input[2]);
		
		int[][] graph = new int[count+1][count+1];
		String[] insert;
		Queue<Integer> queue = new LinkedList<>();
		Stack<Integer> stack = new Stack<>();
		int result = 0;
		boolean[] bit = new boolean[count+1];
		StringBuilder sb = new StringBuilder();
		
		for(int i = 1; i <= count; i++) {
			bit[i] = false;
		}
		for(int i = 1; i <= edge; i++) {
			insert = br.readLine().split(" ");
			graph[Integer.parseInt(insert[0])][Integer.parseInt(insert[1])] = 1;
			graph[Integer.parseInt(insert[1])][Integer.parseInt(insert[0])] = 1;
		}
		
		stack.push(start);
		
		while(!stack.isEmpty()) {
			int check = stack.pop();
			if(bit[check] == true)
				continue;
			sb.append(check + " ");
			bit[check] = true;
			
			for(int i = count; i > 0; i--) {
				if(graph[check][i] == 1) {
					stack.push(i);
				}
			}
		}
		
		bw.append(sb.toString() + "\n");
		
		sb.setLength(0);
		for(int i = 1; i <= count; i++) {
			bit[i] = false;
		}
		bit[start] = true;
		queue.add(start);
		
		while(!queue.isEmpty()) {
			int check = queue.remove();
			sb.append(check + " ");
			
			for(int i = 1; i <= count; i++) {
				if(graph[check][i] == 1 && !bit[i]) {
					queue.add(i);
					bit[i] = true;
				}
			}
		}
		
		bw.append(sb.toString() + "\n");
		bw.flush();
		bw.close();
	}

}
