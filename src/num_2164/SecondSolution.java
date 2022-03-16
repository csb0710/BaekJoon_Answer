package num_2164;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SecondSolution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// Answer of BaekJoon no. 2164
		ArrayList<Integer> list = new ArrayList<>();
		BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
		
		int suffle = 0;
		
		int count = Integer.parseInt(scan.readLine());
			
		for(int i = 1; i <= count; i++) {
			list.add(i);
		}
				
		while(suffle < list.size()-1) {
			suffle++;
			list.add(list.get(suffle));
			suffle++;				
		}
		System.out.println(list.get(suffle));
 
	}

}
