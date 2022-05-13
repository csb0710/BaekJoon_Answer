package num_18917;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// Answer of BaekJoon no. 18917
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int count = Integer.parseInt(br.readLine());
		long sum = 0;
		long temp = 0;
		for(int i = 0; i < count; i++) {
			String[] input = br.readLine().split(" ");
			if(input[0].equals("1")) {
				sum += Integer.parseInt(input[1]);
				temp = temp ^ Integer.parseInt(input[1]);
			}
			else if(input[0].equals("2")) {
				sum -= Integer.parseInt(input[1]);
				temp = temp ^ Integer.parseInt(input[1]);
			}
			else if(input[0].equals("3")) {
				bw.append(sum +"\n");
			}
			else {
				bw.append(temp + "\n");
			}
		}
		bw.flush();
		bw.close();
	}

}
