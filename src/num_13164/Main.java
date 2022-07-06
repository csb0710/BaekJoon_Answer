package num_13164;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// Answer of BaekJoon no. 13164
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int count = Integer.parseInt(st.nextToken());
		int want = Integer.parseInt(st.nextToken());
		ArrayList<Integer> list = new ArrayList<>();
		ArrayList<Integer> list2 = new ArrayList<>();
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < count; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		
		for(int i = 0; i < count-1; i++) {
			list2.add(list.get(i+1) - list.get(i));
		}
		
		Collections.sort(list2);
		
		int result = 0;
		
		for(int i = 0; i < count-want; i++) {
			result += list2.get(i);
		}
		
		System.out.println(result);

	}

}
