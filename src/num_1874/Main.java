package num_1874;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// Answer of BaekJoon no. 1874
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int count = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		int input = Integer.parseInt(br.readLine());
		int input_count = 1;
		StringBuilder sb = new StringBuilder();
		
		for(int i = 1; i < count+1; i++) {
			stack.add(i);
			sb.append("+\n");
			if(stack.peek().intValue() == input) {
				while(stack.peek() == input) {
					stack.pop();
					sb.append("-\n");
					if(input_count < count) {
						input = Integer.parseInt(br.readLine());
						input_count++;
					}
					if(stack.empty())
						break;
				}
			}
			else if(stack.peek() > input) {
				break;
			}
			
		}
		if(!stack.empty()) {
			bw.write("NO");
		}
		else {
			bw.write(sb.toString());
			
		}
		bw.flush();
		bw.close();
		
		
	
	}

}
