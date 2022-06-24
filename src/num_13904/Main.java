package num_13904;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


class Node {
	int day;
	int point;
	
	public Node(int day, int point) {
		this.day = day;
		this.point = point;
	}
}

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// Answer of BaekJoon no. 13904
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		boolean[] check = new boolean[1001];
		Arrays.fill(check, false);
		PriorityQueue<Node> pq = new PriorityQueue(new Comparator<Node>() {
			public int compare(Node o1, Node o2) {
				if(o2.point == o1.point) {
					return o1.day - o2.day;
				}
				return o2.point - o1.point;
			}
		});
		
		int count = Integer.parseInt(br.readLine());
		int count_day = 1;
		int point = 0;
		
		
		for(int i = 0; i < count; i++) {
			st = new StringTokenizer(br.readLine());
			pq.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			
		}
		
		while(!pq.isEmpty()) {
			Node temp = pq.poll();
			if(!check[temp.day]) {
				check[temp.day] = true;
				point += temp.point;
			}
			else {
				while(check[temp.day]) {
					temp.day--;
					if(temp.day == 1) {
						break;
					}
				}
				if(!check[temp.day] && temp.day >= 1) {
					check[temp.day] = true;
					point += temp.point;
				}
			}
			
		}
		
		
		System.out.println(point);

	}

}
