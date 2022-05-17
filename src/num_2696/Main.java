package num_2696;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// Answer of BaekJoon no. 2696
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int count = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < count; i++) {
			int count2 = Integer.parseInt(br.readLine());
			PriorityQueue<Integer> pq = new PriorityQueue<>();
			PriorityQueue<Integer> pqr = new PriorityQueue<>(Collections.reverseOrder());
			
			String temp = "";
			for(int k = 0; k < count2/10; k++) {
				temp += br.readLine() + " ";
			}
			if(count2 % 10 != 0) {
				temp += br.readLine();
			}
			int counts = 0;
			
			StringTokenizer st = new StringTokenizer(temp);
			int result = Integer.parseInt(st.nextToken());
			sb.append((count2+1)/2 + "\n");
			sb.append(result + " ");
			
			for(int j = 1; j < count2; j++) {
				int next = Integer.parseInt(st.nextToken());
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
				if(j%2 == 0) {
					counts++;
					sb.append(result + " ");
					if(counts == 9) {
						counts = 0;
						sb.deleteCharAt(sb.length()-1);
						sb.append("\n");
					}
				}
			}
			if(sb.charAt(sb.length()-1) == '\n') {
				sb.deleteCharAt(sb.length()-1);
			}
			sb.deleteCharAt(sb.length()-1);
			sb.append("\n");
		}
		
		sb.deleteCharAt(sb.length()-1);
		bw.append(sb.toString());
		bw.flush();
		bw.close();
		

	}

}
