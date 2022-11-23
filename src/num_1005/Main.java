package num_1005;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node {
	int index;
	int value;
	
	public Node(int index, int value) {
		this.index = index;
		this.value = value;
	}
}

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	public static void playGame() throws IOException {
		st = new StringTokenizer(br.readLine());
		int count = Integer.parseInt(st.nextToken());
		int times = Integer.parseInt(st.nextToken());
		
		int[] dp = new int[count+1]; 
		int[] counting = new int[count+1];
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		
		Arrays.fill(counting, 0);
		
		counting[0] = 1;
		for(int i = 0; i < count+1; i++) {
			list.add(new ArrayList<>());
		}
		
		st = new StringTokenizer(br.readLine());

		for(int i = 1; i < count+1; i++) {
			dp[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < times; i++) {
			st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());
			list.get(first).add(second);
			counting[second]++;
		}
		
		PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
			public int compare(Node o1, Node o2) {
				return o1.value - o2.value;
			}
		});
		
		for(int i = 1; i < count+1; i++) { 
			if(counting[i] == 0) {
				pq.add(new Node(i, dp[i]));
			}
		}
		
		while(!pq.isEmpty()) {
			Node temp = pq.poll();
			
			for(int var : list.get(temp.index)) {
				counting[var]--;
			
				if(counting[var] == 0) {
					dp[var] += dp[temp.index];
					pq.add(new Node(var, dp[var]));
				}
			}
		}
		
		int target = Integer.parseInt(br.readLine());
		
		bw.append(dp[target] + "\n");
		
	}

	public static void main(String[] args) throws IOException {
		// Answer of BaekJoon no. 1005
		
		int cases = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < cases; i++) {
			playGame();
		}

		bw.flush();
		bw.close();
	}

}
