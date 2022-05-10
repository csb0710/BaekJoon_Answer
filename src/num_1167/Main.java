package num_1167;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int result = 0;
	static int max = 0;
	static Stack<Integer> stack = new Stack<>();
	static ArrayList<ArrayList<Integer>>list = new ArrayList<>();
	static ArrayList<ArrayList<Integer>>list2 = new ArrayList<>();
	static boolean[] bit;
	
	static public int dfs(int n) {
		bit[n] = true;
		int[] temp = new int[list.get(n).size()];
		for(int i = 0; i < list.get(n).size(); i++) {
			int temporary = list.get(n).get(i);
			if(bit[temporary] == true)
				continue;
			int temp2 = dfs(temporary);
			temp[i] = temp2 + list2.get(n).get(i);
		}
		
		Arrays.sort(temp);
		
		int temp_max = 0;
		int temp_max2 = 0;
		
		if(temp.length > 0) {
			temp_max = temp[temp.length-1];
			temp_max2 = temp[temp.length-1];
			if(temp.length > 1) {
				temp_max += temp[temp.length-2];
			}
		}
		
		if(temp_max > max) {
			max = temp_max;
		}
		
		return temp_max2;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// Answer of BaekJoon no. 1167
		
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				
				StringTokenizer st;
				int count = Integer.parseInt(br.readLine());
				bit = new boolean[count+1];
				
				for(int i=0; i<=count; i++) {
					list.add(new ArrayList<Integer>());
					list2.add(new ArrayList<Integer>());
					bit[i] = false;
				}
				
				
				for(int i = 1; i <= count; i++) {
					st = new StringTokenizer(br.readLine(), " ");
					int temp = Integer.parseInt(st.nextToken());;
					int left = temp;
					while(true) {
						temp =  Integer.parseInt(st.nextToken());
						if(temp == -1)
							break;
						list.get(left).add(temp);
						temp =  Integer.parseInt(st.nextToken());
						list2.get(left).add(temp);
						
					}
				}
				
				dfs(1);
				
				System.out.println(max);

	}

}
