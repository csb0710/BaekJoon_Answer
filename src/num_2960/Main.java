package num_2960;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	public static int Eratosthenes(int end, int target) {
		ArrayList<Boolean> list = new ArrayList<>();
		int count = 0;
		list.add(false);
		
		for(int i = 1; i < end+1; i++) {
			list.add(i, true);
		}
		for(int i = 2; i <= end; i++) {
			for(int j = 1; j*i <= end; j++) {
				if(list.get(j*i) == true) {
					list.set(j*i, false);
					count++;
				}
				if(count == target) {
					System.out.println(i*j);
					return 0;
				}
			}
		}
		
		return 0;
		
	}
	
	public static void main(String[] args) throws IOException {
		// Answer of BackJoon no. 2960
		
			BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
			String[] s = scan.readLine().split(" ");
			int max = Integer.parseInt(s[0]);
			int target = Integer.parseInt(s[1]);
				
			Eratosthenes(max, target);

	}

}
