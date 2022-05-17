package num_1759;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	static char[] arr;
	static boolean[] visit;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static char[] inputs;
	static ArrayList<String> list = new ArrayList<>();
	
	public static void dfs(int m, int n, int depth, char check, int check2, int check3) throws IOException {
		if(depth == m) {
			if(check2 < 1 || check3 < 2)
				return;
			list.add(new String(arr));
			return;
		}
		for(int i = 0; i < n; i++) {
			if(!visit[i]) {
				if(check > inputs[i]) {
					continue;
				}
				visit[i] = true;
				arr[depth] = inputs[i];
				if(inputs[i] == 'a' || inputs[i] == 'e' || inputs[i] == 'i' || inputs[i] == 'o' || inputs[i] == 'u') {
					dfs(m, n, depth + 1, inputs[i], check2+1, check3);
				}
				else {
					dfs(m, n, depth + 1, inputs[i], check2, check3+1);
				}
				
				visit[i] = false;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		// Answer of BaekJoon no. 1759
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int m = Integer.parseInt(input[0]);
		int n = Integer.parseInt(input[1]);
		
		String[] temp = br.readLine().split(" ");
		inputs = new char[n];
		for(int i = 0; i < n; i++) {
			inputs[i] = temp[i].charAt(0);
		}
		
		visit = new boolean[n];
		arr = new char[m];
		
		dfs(m, n, 0, (char)96, 0, 0);
		
		Collections.sort(list);
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

	}

}
