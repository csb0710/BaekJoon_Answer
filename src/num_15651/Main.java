package num_15651;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static int n;
	static int m;
	static int[] arr;
	static boolean[] bit;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void dfs(int n, int m, int depth) throws IOException {
		if(depth == m) {
			for(int temp : arr) {
				bw.write(temp + " ");
			}
			bw.append("\n");
			return;
		}
		
		for(int i = 0; i < n; i++) {
			arr[depth] = i+1;
			dfs(n, m, depth+1);
			
		}
	}
	
	public static void main(String[] args) throws IOException {
		// Answer of BaekJoon no. 15651
		
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String[] inputs = br.readLine().split(" ");
			n = Integer.parseInt(inputs[0]);
			m = Integer.parseInt(inputs[1]);
			
			arr =  new int[m];
			bit = new boolean[n];
				
			dfs(n, m, 0);
				
			bw.flush();
			bw.close();

	}

}
