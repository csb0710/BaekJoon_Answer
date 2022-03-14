package num_1094;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Answer1094 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ArrayList<Integer> sticks = new ArrayList<>();
		int sum = 64;
		sticks.add(64);
		
		int target = scan.nextInt();
		
		while(sum > target) {
			sum = 0;
			Collections.sort(sticks, Collections.reverseOrder());
			
			int current_stick = sticks.get(sticks.size()-1);
			sticks.remove(sticks.size()-1);
			
			int div_stick = current_stick/2;
			sticks.add(div_stick);
			
			for(int i = 0; i < sticks.size(); i++) {
				sum += sticks.get(i);
			}
			
			if(sum < target && div_stick < target) {
				sticks.add(div_stick);
				sum += div_stick;
			}
		}
		
		System.out.println(sticks.size());

	}

}
