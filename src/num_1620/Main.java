package num_1620;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// Answer of BaekJoon no. 1620
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		HashMap<String, Integer> map2 = new HashMap<>();
		
		String[] insert = br.readLine().split(" ");
		int count = Integer.parseInt(insert[0]);
		int question = Integer.parseInt(insert[1]);
		String[] map = new String[count+1];
		
		String input;
		
		for(int i = 1; i <= count; i++) {
			input = br.readLine();
			map[i] = input;
			map2.put(input, i);
		}
		
		for(int i = 0; i < question; i++) {
			input = br.readLine();
			
			if(input.charAt(0) >= 'A') {
				sb.append(map2.get(input) + "\n");
			}
			else {
				sb.append(map[Integer.parseInt(input)] + "\n");
			}
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
	}

	

}
