package num_6198;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// Answer of BaekJoon no. 6198
		
		BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int count = Integer.parseInt(scan.readLine());
		Stack<Integer> stack_index = new Stack<>();
		Stack<Integer> stack_value = new Stack<>();
		long sum = 0;
		stack_index.add(1);
		stack_value.add(Integer.parseInt(scan.readLine()));
		
		for(int i = 2; i < count; i++) {
			int temp = Integer.parseInt(scan.readLine());
			while(temp >= stack_value.peek()) {
				stack_value.pop();
				sum += i - stack_index.pop() -1;
				if(stack_value.empty())
					break;
			}
			stack_value.add(temp);
			stack_index.add(i);
		}
		int last = Integer.parseInt(scan.readLine());
		while(!stack_value.empty()) {
			if(last < stack_value.peek()) {
				stack_value.pop();
				sum += count - stack_index.pop();
				if(stack_value.empty())
					break;
			}
			else {
				sum+= count - stack_index.pop() -1;
				stack_value.pop();
			}
		}
		
		bw.write(sum+"");
		bw.flush();
		bw.close();
		
	}

}
