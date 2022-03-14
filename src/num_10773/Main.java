package num_10773;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		// Answer of BackJoon no. 10773
		
		BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
		Stack<Integer> stack = new Stack<>();
		int count = Integer.parseInt(scan.readLine());
		int sum = 0;

		while(count > 0) {
			int input = Integer.parseInt(scan.readLine());
			if(input == 0)
				stack.pop();
			else
				stack.push(input);
			
			count--;
		}
		
		for(int i = 0; i < stack.size(); i++) {
			sum += stack.get(i);
		}
		
		wr.write(Integer.toString(sum));
		
		wr.flush();
	}

}
