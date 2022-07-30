package num_1826;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node {
	int distance;
	int charge;
	
	public Node(int a, int b) {
		this.distance = a;
		this.charge = b;
	}
}

public class Main {

	public static void main(String[] args) throws IOException {
		// Answer of BaekJoon no. 1826
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int count = Integer.parseInt(br.readLine());
		PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
			public int compare(Node o1, Node o2) {
				if(o1.distance == o2.distance) {
					return o2.charge - o1.charge;
				}
				return o1.distance - o2.distance;
			}
		});
		
		PriorityQueue<Node> pq2 = new PriorityQueue<>(new Comparator<Node>() {
			public int compare(Node o1, Node o2) {
				if(o2.charge == o1.charge) {
					return o2.distance - o1.distance;
				}
				return o2.charge - o1.charge;
			}
		});
		
		for(int i = 0; i < count; i++)  {
			st  = new StringTokenizer(br.readLine());
			Node temp = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			pq.add(temp);
		}
		
		st = new StringTokenizer(br.readLine());
		int des = Integer.parseInt(st.nextToken());
		int gas = Integer.parseInt(st.nextToken());
		
		int cur_dis = 0;
		int result = 0;
		
		// 기존 나의 풀이
//		while(gas + cur_dis < des) {
//			while(!pq.isEmpty() && gas + cur_dis>= pq.peek().distance) {
//				pq2.add(pq.poll());
//			}
//				
//			Node temp = pq2.poll();
//			if(temp.distance > cur_dis) {
//				gas = gas - (temp.distance - cur_dis) + temp.charge;
//				cur_dis = temp.distance;
//			}
//			else {
//				gas += temp.charge;
//			}
//			result++;
//			
//			
//			if(!pq.isEmpty() && pq2.isEmpty() && gas + cur_dis < pq.peek().distance)
//				break;
//			
//		}
//		
//		if(gas + cur_dis < des) {
//			System.out.println(-1);
//		}
//		else {
//			System.out.println(result);
//		}
		
//		------------------------------------------------------------------------------------
		
		// 코드 이쁘게 정리
		while(gas < des) {
			while(!pq.isEmpty() && gas + cur_dis>= pq.peek().distance) {
				pq2.add(pq.poll());
			}
			
			if(pq2.isEmpty()) {
				break;
			}
			
			gas += pq2.poll().charge;
			System.out.println(gas);
			result++;			
		}

		if(gas < des) {
			System.out.println(-1);
		}
		else {
			System.out.println(result);
		}
		
		

	}

}
