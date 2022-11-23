package num_15681;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
	static boolean[] visit;
	static int[] dp;
	
	public static void dfs(int root) {
		visit[root] = true;
		
		for(int var : list.get(root)) {
			if(visit[var]) {
				continue;
			}
			
			dfs(var);
			dp[root] += dp[var];
		}
		
		dp[root]++;
	}

	public static void main(String[] args) throws IOException {
		// Answer of BaekJoon no. 15681
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		StringBuilder sb = new StringBuilder();
		
		int count = Integer.parseInt(st.nextToken());
		int root = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		dp = new int[count + 1];
		visit = new boolean[count+1];
		
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
		
		dfs(root);
		
		for(int i = 0; i < q; i++) {
			int temp = Integer.parseInt(br.readLine());
			sb.append(dp[temp] + "\n");
		}
		
		bw.append(sb);
		bw.flush();
		bw.close();

	}

}
