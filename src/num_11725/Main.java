package num_11725;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int result = 0;
	static Queue<Integer> queue = new LinkedList<>();
	static int[] mother;
	static boolean[] bit;
	static ArrayList<ArrayList<Integer>>list = new ArrayList<>();
	static public void bfs(int n) {
		queue.add(1);
		bit[1] = true;
		
		while(!queue.isEmpty()) {
			int temp = queue.remove();
			
			for(int v: list.get(temp)) {
				if(!bit[v]) {
					mother[v] = temp;
					queue.add(v);
					bit[v] = true;
				}
			}
			
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		int count = Integer.parseInt(br.readLine());
		mother = new int[count+1];
		bit = new boolean[count+1];
		
		for(int i=0; i<=count; i++) {
			list.add(new ArrayList<Integer>());
		}
		for(int i = 1; i < count; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int left = Integer.parseInt(st.nextToken());
			int right = Integer.parseInt(st.nextToken());
			list.get(right).add(left);
			list.get(left).add(right);
			
			
		}
		bfs(count);
		
		for(int i = 2; i < count+1; i++) {
			System.out.println(mother[i]);
		}
	}

}
