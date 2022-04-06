package num_3015;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// Answer of BaekJoon no. 3015
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int count = Integer.parseInt(br.readLine());
		Stack<Long> input = new Stack<>();
		Stack<Integer> index = new Stack<>();
		long[] result = new long[count+1];
		long sum = 0;
		
		input.add(Long.parseLong(br.readLine()));
		index.add(1);
		for(int i = 2; i <= count; i++) {
			long insert = Long.parseLong(br.readLine());
			if(insert > input.peek()) {
				while(input.peek() < insert) {
					sum++;
					input.pop();
					index.pop();
					if(input.empty()) {
						break;
					}
					if(input.peek() > insert) {
						sum++;
						result[i] = 1;
					}
					else if(input.peek() == insert) {
						result[i]+= result[index.peek()]+1;
						sum += result[i];
					}
				}
				input.add(insert);
				index.add(i);
			}
			else if(insert < input.peek()){
				sum ++;
				result[i] = 1;
				input.add(insert);
				index.add(i);
			}
			else {
				result[i]+= result[index.peek()]+1;
				sum += result[i];
				input.add(insert);
				index.add(i);
			}
		}
		
		bw.write(sum + "");
		bw.flush();
		bw.close();
		
		

	}

}
