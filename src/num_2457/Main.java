package num_2457;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.Comparator;

class Node {
	int sm;
	int sd;
	int lm;
	int ld;
	
	public Node(int sm, int sd, int lm, int ld) {
		this.sm = sm;
		this.sd = sd;
		this.lm = lm;
		this.ld = ld;
	}
	
}

public class Main {

	public static void main(String[] args) throws IOException {
		// Answer of BaekJoon no. 2457
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int count = Integer.parseInt(br.readLine());
		
		PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
			public int compare(Node o1, Node o2) {
				if(o1.sm == o2.sm) {
					return o1.sd - o2.sd;
				}
				return o1.sm - o2.sm;
			}
		});
		
		
		for(int i = 0; i < count; i++) {
			st = new StringTokenizer(br.readLine());
			pq.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		int last_mon = 3;
		int last_day = 1;
		boolean flag = false;
		int result = 0;
		
		PriorityQueue<Node> pq2 = new PriorityQueue<>(new Comparator<Node>() {
			public int compare(Node o1, Node o2) {
				if(o1.lm == o2.lm) {
					return o2.ld - o1.ld;
				}
				return o2.lm - o1.lm;
			}
		});
		
		while(last_mon != 12) {
			int size = pq2.size();
			int temp_mon = 0;
			int temp_day = 0;
			
			if(pq.isEmpty()) {
				flag = true;
				break;
			}
			
			while(!pq.isEmpty() && ((pq.peek().sm < last_mon) || (pq.peek().sm == last_mon && pq.peek().sd <= last_day))) {
				if(temp_mon == pq.peek().lm) {
					temp_day = Math.max(pq.peek().ld, temp_day);
				}
				else if(pq.peek().lm > temp_mon){
					temp_mon = pq.peek().lm;
					temp_day = pq.peek().ld;
				}
				pq.poll();
			}
			
			if(temp_mon == last_mon && temp_day == last_day) {
				flag = true;
				break;
			}
			
			last_mon = temp_mon;
			last_day = temp_day;
			
			result++;
			
		}
		
		if(flag) {
			System.out.println(0);
		}
		else {
			System.out.println(result);
		}
	}

}
