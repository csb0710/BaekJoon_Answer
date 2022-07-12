package num_1516;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;
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

	public static void main(String[] args) throws NumberFormatException, IOException {
		// Answer of BaekJoon no. 1516
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int count = Integer.parseInt(br.readLine());
		int[] dp = new int[count+1]; 
		int[] counting = new int[count+1];
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		
		Arrays.fill(counting, 0);
		
		counting[0] = 1;
		for(int i = 0; i < count+1; i++) {
			list.add(new ArrayList<>());
		}
		
		for(int i = 1; i < count+1; i++) {
			st = new StringTokenizer(br.readLine());
			dp[i] = Integer.parseInt(st.nextToken());
			int temp = Integer.parseInt(st.nextToken());
			while(temp != -1) {
				list.get(temp).add(i);
				counting[i]++;
				temp = Integer.parseInt(st.nextToken());
			}
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
			int size = pq.size();
			for(int j = 0; j < size; j ++) {
				Node temp = pq.poll();
			
				for(int var : list.get(temp.index)) {
					counting[var]--;
				
					if(counting[var] == 0) {
						dp[var] += dp[temp.index];
						pq.add(new Node(var, dp[var]));
					}
				}
			}
		}
		
		for(int i = 1; i < count+1; i++) { 
			bw.append(dp[i] + "\n");
		}
		
		bw.flush();
		bw.close();

	}

}
