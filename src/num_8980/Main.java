package num_8980;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node>{
	int start;
	int next;
	int weight;
	
	public Node(int s, int n, int w) {
		this.start = s;
		this.next = n;
		this.weight = w;
	}
	
	public int compareTo(Node o) {
		return this.next - o.next;
	}
}

public class Main {

	public static void main(String[] args) throws IOException {
		// Answer of BaekJoon no.8980
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int last = Integer.parseInt(st.nextToken());
		int capacity = Integer.parseInt(st.nextToken());
		
		int count = Integer.parseInt(br.readLine());
		Node[] list = new Node[count];
		int[] map = new int[last+1];
		
		for(int i = 0; i < count; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list[i] = new Node(s, n, w);
		}
		
		Arrays.sort(list);
		int result = 0;
		
		for(int i = 0; i < count; i++) {
			Node temp = list[i];
			int max = 0;
			for(int j = temp.start; j <= temp.next; j++) {
				max = Math.max(max, map[j]);
			}
			int temp_weight = temp.weight;
			if(temp.weight + max > capacity) {
				temp_weight = capacity - max;
			}
			if(temp_weight == 0) {
				continue;
			}
			for(int j = temp.start; j < temp.next; j++) {
				map[j] += temp_weight;
			}
			result += temp_weight;
			
		}
		
		System.out.println(result);

	}

}
