package num_1302;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException{
		// Answer of BackJoon no.1302
		
		ArrayList<String> list = new ArrayList<>();
		Scanner scan = new Scanner(System.in);
		int count = scan.nextInt();
		ArrayList<String> temp = new ArrayList<>();
		scan.nextLine();
		int max = 0;
		
		
		
		for(int i = 0; i < count; i++) {
			String input = scan.nextLine();
			temp.add(input);
			if(count == 1) {
				list.add(input);
			}
		}
		
		Collections.sort(temp);
		String standard = temp.get(0);
		int counter = 1;
	
		for(int i = 1; i < temp.size(); i++) {
			if(!temp.get(i).equals(standard)) {
				if(max < counter) {
					max = counter;
					counter = 1;
					list.clear();
					list.add(standard);
				}
				else if(max == counter) {
					list.add(standard);
					counter = 1;
				}
				standard = temp.get(i);
			}
			else 
				counter ++;
		}
		if(max < counter) {
			list.clear();
			list.add(standard);
		}
		else if(max == counter) {
			list.add(standard);
		}
			
		Collections.sort(list);
		System.out.println(list.get(0));

	}

}
