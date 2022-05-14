package num_1655;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stu
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int count = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		PriorityQueue<Integer> pqr = new PriorityQueue<>(Collections.reverseOrder());
		int result = Integer.parseInt(br.readLine());
		bw.append(result + "\n");
		for(int i = 1; i < count; i++) {
			int next = Integer.parseInt(br.readLine());
			if(result > next) {
				pqr.add(next);
			}
			else {
				pq.add(next);
			}
			
			if(pqr.size() == pq.size()+1) {
				pq.add(result);
				result = pqr.poll();
			}
			if(pqr.size()+2 == pq.size()) {
				pqr.add(result);
				result = pq.poll();
			}
			bw.append(result + "\n");
			
		}
		bw.flush();
		bw.close();
	}

}
