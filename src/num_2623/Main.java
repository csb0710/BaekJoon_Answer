package num_2623;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// Answer of BaekJoon no. 2623
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		
		int count = Integer.parseInt(st.nextToken());
		int pd = Integer.parseInt(st.nextToken());
		ArrayList<Integer>[] list = new ArrayList[count+1];
		int[] count_prev = new int[count+1];
		
		for(int i = 1; i < count+1; i++) {
			list[i] = new ArrayList<>();
			count_prev[i] = 0;
		}
		
		for(int i = 1; i < pd+1; i++) {
			st = new StringTokenizer(br.readLine());
			int temp_count = Integer.parseInt(st.nextToken());
			int prev = Integer.parseInt(st.nextToken());
			for(int j = 0; j < temp_count-1; j++) {
				int temp = Integer.parseInt(st.nextToken());
				if(!list[prev].contains(temp)) {
					list[prev].add(temp);
					count_prev[temp]++;
				}
				prev = temp;
			}
		}
		
		int result_count = 0;
		
		Queue<Integer> q = new LinkedList<>();
		
		for(int i = 1; i < count+1; i++) {
			if(count_prev[i] == 0) {
				q.add(i);
			}
		}
		
		while(!q.isEmpty()) {
			result_count++;
			int temp = q.poll();
			bw.append(temp+"\n");
			
			for(int var : list[temp]) {
				count_prev[var]--;
				if(count_prev[var] == 0) {
					q.add(var);
				}
			}
		}
		
		if(result_count != count) {
			System.out.println(0);
		}
		else {
			bw.flush();
			bw.close();
		}

	}

}
