package num_1406;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Answer1406 {

	public static void main(String[] args) throws IOException {
		// Answer of BackJoon no.1406
		LinkedList<Character> list = new LinkedList<>();
		BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
		char[] charArray = scan.readLine().toCharArray();
		
		for (char data : charArray) {
			list.add(data);
		}
		
		int count = Integer.parseInt(scan.readLine());
		
		ListIterator<Character> cheat = list.listIterator(list.size());

		while(count > 0) {
			char[] input = scan.readLine().toCharArray();
			switch(input[0]) {
				case 'P' :
					cheat.add(input[2]);
					
					break;
					
				case 'L' :
					if(cheat.hasPrevious())
						cheat.previous();
					
					break;
					
				case 'D' :
					if(cheat.hasNext())
						cheat.next();
					
					break;
					
				case 'B' :
					if(cheat.hasPrevious()) {
						cheat.previous();
						cheat.remove();
					}
					
					break;
			}
			count --;
		}
		
		for(char c : list){
            wr.write(c);
        }
        wr.flush();
	}

}
