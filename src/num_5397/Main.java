package num_5397;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// Answer of BaekJoon no. 5397
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		//StringTokenizer st;
		int count = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < count; i++) {
			LinkedList<Character> list = new LinkedList<>();
			ListIterator<Character> iter = list.listIterator();
			char[] input = br.readLine().toCharArray();
			StringBuilder sb = new StringBuilder();
			//st = new StringTokenizer(br.readLine(), "");
			for(int j = 0; j < input.length; j++) {
				if(input[j] == '<') {
					if(iter.hasPrevious())
						iter.previous();
				}
				else if(input[j] == '>') {
					if(iter.hasNext())
						iter.next();
				}
				else if(input[j] == '-') {
					if(iter.hasPrevious()) {
						iter.previous();
						iter.remove();
					}
				}
				else {
					iter.add(input[j]);
				}
				
			}
			iter = list.listIterator();
			while(iter.hasNext()) {
				sb.append(iter.next());
			}
			bw.append(sb+"\n");
		}
		
		bw.flush();
		bw.close();
	}

}
