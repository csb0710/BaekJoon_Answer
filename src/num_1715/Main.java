package num_1715;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int count = Integer.parseInt(br.readLine());
		int sum = 0;
		
		for(int i = 0; i < count; i++) {
			pq.add(Integer.parseInt(br.readLine()));
		}
		while(!pq.isEmpty()) {
			if(pq.size() == 1) {
				sum += pq.poll();
			}
			else {
				int temp = pq.poll() + pq.poll();
				sum += temp;
				pq.add(temp);
				if(pq.size() == 1) {
					break;
				}
			}
		}
		if(count==1) {
			sum = 0;
		}
		System.out.println(sum);
	}

}
