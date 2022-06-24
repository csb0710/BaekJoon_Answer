package num_2212;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// Answer of BaekJoon no. 2212
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());
		ArrayList<Integer> list = new ArrayList<>();
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int result = 0;
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < n; i++) {
			int temp = Integer.parseInt(st.nextToken());
			if(list.contains(temp)) {
				continue;
			}
			list.add(temp);
		}
		
		Collections.sort(list);
		
		for(int i = 0; i < list.size()-1; i++) {
			pq.add(list.get(i+1)-list.get(i));
			System.out.println(list.get(i+1)-list.get(i));
		}
		
		System.out.println(list.size());
		for(int i = 0; i < list.size()-k; i++) {
			int temp = pq.poll();
			System.out.println(temp);
			result += temp;
		}

		System.out.println(result);
	}

}
