package num_13975;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// Answer of BaekJoon no. 13975
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int case_count = Integer.parseInt(br.readLine());
		for(int i = 0; i < case_count; i++) {
			int count = Integer.parseInt(br.readLine());
			long sum = 0;
			st = new StringTokenizer(br.readLine());
			PriorityQueue<Long> pq = new PriorityQueue<>();
			
			for(int j = 0; j < count; j++) {
				pq.add(Long.parseLong(st.nextToken()));
			}
			
			while(pq.size() >= 2) {
				long temp = pq.poll()+pq.poll();
				sum += temp;
				pq.add(temp);
			}
			
			bw.append(sum + "\n");
		}
		
		bw.flush();
		bw.close();		
		
	}

}
