package num_1068;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int result = 0;
	static Queue<Integer> queue = new LinkedList<>();
	static public void bfs(int[][] tree, int root, int n) {
		queue.add(root);
		
		while(!queue.isEmpty()) {
			int temp = queue.remove();
			boolean check = true;
			
			for(int i = 0; i < n; i++) {
				if(tree[temp][i] == 1) {
					queue.add(i);
					check = false;
				}
			}
			
			if(check) {
				result++;
			}	
			
		}
		System.out.println(result);
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// Answer of BaekJoon no. 1068
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		
		int count = Integer.parseInt(br.readLine());
		int[][] tree = new int[count][count];
		int root = 0;
		
		for(int i = 0; i < count; i++) {
			for(int j = 0; j < count; j++) {
				tree[i][j] = 0;
			}
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		
		for(int i = 0; i < count; i++) {
			int temp = Integer.parseInt(st.nextToken());
			
			if(temp == -1) {
				root = i;
				continue;
			}
			tree[temp][i] = 1;
		}
		
		int delete = Integer.parseInt(br.readLine());

		for(int i = 0 ; i < count; i++) {
			tree[delete][i] = 0;
			tree[i][delete] = 0;
		}
		
		if(delete == root) 
			System.out.println(0);
		else 
			bfs(tree, root, count);
	}

}
