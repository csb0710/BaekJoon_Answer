package num_4358;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// Answer of BaekJoon no. 4358
		
		BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
		HashMap<String, Integer> map = new HashMap<>();
		String insert;
		int sum = 0;
		ArrayList<String> memory = new ArrayList<>();
		
		while((insert = scan.readLine()) != null) {
			sum++;
			if(map.containsKey(insert)) {
				map.put(insert, map.get(insert)+1);
			}
			else {
				map.put(insert, 1);
				memory.add(insert);
			}
		}
		
		Collections.sort(memory);
		for(int i = 0; i < memory.size(); i++) {
			double percent = ((double)map.get(memory.get(i)) / sum) *100;
			System.out.printf("%s %.4f\n", memory.get(i), percent);
		}
		
		
	}

}
