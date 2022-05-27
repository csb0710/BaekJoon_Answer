package num_1197;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node> {
	int start;
	int end;
	int weight;
	
	public Node(int start, int end, int weight) {
		this.start = start;
		this.end = end;
		this.weight = weight;
	}

	@Override
	public int compareTo(Node o) {
		return this.weight >= o.weight ? 1:-1;
	}
}

public class Main {
	static int[] union;
	
	static int get_union(int index) {
		if(union[index] == 0) {
			union[index] = index;
			return index;
		}
		
		if(union[index] == index) {
			return index;
		}
		
		return union[index] = get_union(union[index]);
	}
	
	public static void main(String[] args) throws IOException {
		// Answer of BaekJoon no. 1197
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		int result = 0;
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		union = new int[v+1];
		
		
		for(int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			pq.add(new Node(a, b, c));
		}
		
		for(int i = 0; i < e; i++) {
			Node temp = pq.poll();
			
			int index1 = get_union(temp.start);
			int index2 = get_union(temp.end);
			
			if(index1 == index2) {
				continue;
			}
			
			union[index1] = index2;
			
			result += temp.weight;
			
		}
		
		
		System.out.println(result);

	}

}
