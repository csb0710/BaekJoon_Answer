package num_1922;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main2 {
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

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int result = 0;
		int v = Integer.parseInt(br.readLine());
		int e = Integer.parseInt(br.readLine());
		
		
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
