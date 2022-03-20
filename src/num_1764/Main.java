package num_1764;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Main {

	public static void main(String[] args) throws IOException {
		// Answer of BaekJoon no. 1764
		
		BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
		HashSet<String> set = new HashSet<>();
		ArrayList<String> list = new ArrayList<>();
		int c = 0;
		
		String[] in_put= scan.readLine().split(" ");
		int count = Integer.parseInt(in_put[0]) + Integer.parseInt(in_put[1]);
		
		while(count > 0) {
			String input = scan.readLine();
			set.add(input);
			c++;
			if(set.size() != c) {
				c--;
				list.add(input);
			}
			
			count--;
		}
		
		Collections.sort(list);
		
		bw.write(Integer.toString(list.size()) + "\n");
		for(String output : list) {
			bw.write(output+"\n");
		}
		
		bw.flush();
		bw.close();
	}

}
