package num_1135;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer>[] list;
	static boolean[] visit;
	
	public static int dfs(int x) {
		if(list[x].size() == 0) {
			return 0;
		}
		
		int index = 1;
		int max = -1;
		ArrayList<Integer> temp_list = new ArrayList<>();
		
		for(int var : list[x]) {
			int temp = dfs(var);
			
			temp_list.add(temp);
		}

		Collections.sort(temp_list, Collections.reverseOrder());
		
		for(int i = 1; i < temp_list.size()+1; i++) {
			int temp = temp_list.get(i-1) + i;
			
			max = Math.max(max, temp);
		}
		
		return max;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int count = Integer.parseInt(br.readLine());
		
		visit = new boolean[count];
		list = new ArrayList[count];
		
		for(int i = 0; i < count; i++) {
			list[i] = new ArrayList<>();
		}
		
		st = new StringTokenizer(br.readLine());
		st.nextToken();
		
		for(int i = 1; i < count; i++) {
			int temp = Integer.parseInt(st.nextToken());
			
			list[temp].add(i);
		}
		
		System.out.println(dfs(0));
		
	}

}
