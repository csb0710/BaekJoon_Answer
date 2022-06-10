package num_15649;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static int[] arr;
	static boolean[] visit;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void dfs(int m, int n, int depth) throws IOException {
		if(depth == n) {
			for(int temp : arr) {
				bw.write(temp + " ");
			}
			bw.append("\n");
			return;
		}
		
		for(int i = 0; i < m; i++) {
			if(!visit[i]) {
				visit[i] = true;
				arr[depth] = i+1;
				dfs(m, n, depth + 1);
				visit[i] = false;
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// Answer of BaekJoon no. 15649
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int m = Integer.parseInt(input[0]);
		int n = Integer.parseInt(input[1]);
		
		visit = new boolean[m];
		arr = new int[n];
		
		dfs(m, n, 0);
		
		bw.flush();
		bw.close();

		
	}

}
