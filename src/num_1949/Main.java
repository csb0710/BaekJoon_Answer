package num_1949;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
	static boolean[] visit;
	static int[] dp;
	static int[] dp2;
	static int[] input;
	
	public static void dfs(int root) {
		visit[root] = true;
		
		for(int var : list.get(root)) {
			if(visit[var]) {
				continue;
			}
			
			dfs(var);
			dp[root] += dp2[var];
			dp2[root] += Math.max(dp[var], dp2[var]);
		}
		
		//dp[root] += input[root];
	}

	public static void main(String[] args) throws IOException {
		// Answer of BaekJoon no. 1949
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st; 
		StringBuilder sb = new StringBuilder();
			
		int count = Integer.parseInt(br.readLine());
		dp = new int[count + 1];
		visit = new boolean[count+1];
		dp2 = new int[count + 1];  
		input = new int[count + 1];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 1; i <= count; i++) {
			dp[i] = Integer.parseInt(st.nextToken());
		} 
				
		for(int i = 0; i <= count; i++) {
			list.add(new ArrayList<Integer>());
		}
				
		for(int i = 0; i < count-1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
				
			list.get(a).add(b);
			list.get(b).add(a);
		}
				
		dfs(1);
		
		bw.append(Math.max(dp[1], dp2[1]) + "");
		bw.flush();
		bw.close();

	}

}
