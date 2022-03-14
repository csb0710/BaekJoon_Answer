package num_1929;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	public static void Eratosthenes(int start, int end) {
		ArrayList<Boolean> list = new ArrayList<>();
		if(start == 1)
			start = 2;
		for(int i = 0; i < end+1; i++) {
			list.add(i, true);
		}
		for(int i = 2; i*i <= end; i++) {
			for(int j = i; j*i <= end; j++) {
				if(list.get(j*i) == true) {
					list.set(j*i, false);
				}
			}
		}
		for(int i = start; i < end+1; i++) {
			if(list.get(i) == true)
				System.out.println(i);
		}
		
	}

	public static void main(String[] args) throws IOException {
		// Answer of BackJoon no. 1929
		
		BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
		String[] s = scan.readLine().split(" ");
		int min = Integer.parseInt(s[0]);
		int max = Integer.parseInt(s[1]);
		
		Eratosthenes(min, max);
	}

}
