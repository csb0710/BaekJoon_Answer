package num_1302;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

	public static void main(String[] args){
		// Answer of BackJoon no.1302
		
		HashMap<String, Integer> list = new HashMap<>();
		Scanner scan = new Scanner(System.in);
		int count = scan.nextInt();
		ArrayList<String> sort_list = new ArrayList<>();
		scan.nextLine();
		int max = 0;
		
		for(int i = 0; i < count; i++) {
			String input = scan.nextLine();
			if(list.containsKey(input)) {
				list.put(input, list.get(input)+1);
				int temp = list.get(input);
				if(max < temp) {
					max = temp;
					sort_list.clear();
					sort_list.add(input);
				}
				else if(max == temp) {
					sort_list.add(input);
				}
			}
			else {
				list.put(input, 1);
				int temp = list.get(input);
				if(max < temp) {
					max = list.get(input);
					sort_list.add(input);
				}
				else if(max == temp) {
					sort_list.add(input);
				}
			}
		}
		
		Collections.sort(sort_list);
		
		System.out.println(sort_list.get(0));

	}

}
