package num_2252;

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
	static int[] insert_degree;
	static Queue<Integer> topology = new LinkedList<>();
	static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void Topology_Sort() throws IOException {
		for(int i = 1; i < insert_degree.length; i++) {
			if(insert_degree[i] == 0) {
				topology.add(i);
				insert_degree[i]--;
			}
		}
		
		while(!topology.isEmpty()) {
			int temp = topology.poll();
			bw.append(temp + " ");
			
			for(int j = 0; j < list.get(temp).size(); j++) {
				insert_degree[list.get(temp).get(j)]--;
				if(insert_degree[list.get(temp).get(j)] == 0) {
					topology.add(list.get(temp).get(j));
				}
			}
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		// Answer of BaekJoon no. 2252
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken()); 
		int n = Integer.parseInt(st.nextToken());
		
		insert_degree = new int[m+1];
		
		for(int i = 0; i < m+1; i++) {
			list.add(new ArrayList<Integer>());
		}
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			
			int fst = Integer.parseInt(st.nextToken());
			int sec = Integer.parseInt(st.nextToken());
			
			list.get(fst).add(sec);
			insert_degree[sec]++;
		}
		
		Topology_Sort();
		
		bw.flush();
		bw.close();
	}

}
