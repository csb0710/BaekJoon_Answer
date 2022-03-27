package num_2493;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// Answer of BaekJoon no. 2493
		
		BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.parseInt(scan.readLine());
		int[] towers = new int[count+1];
		Stack<Integer> stack_index = new Stack<>();
		Stack<Integer> stack_value = new Stack<>();
		int[] result = new int[count+1];
		
		String token = scan.readLine();
		StringTokenizer stk = new StringTokenizer(token);
		
		for(int i = 1; i <= count; i++) {
			towers[i] = (Integer.parseInt(stk.nextToken()));
		}
		
		stack_value.add(towers[count]);
		stack_index.add(count); 
		
		int index = count-1;
		
		while(index > 0) {
			if(!stack_value.empty()) {
				int temp = towers[index];
				while(stack_value.peek() <= temp) {
					stack_value.pop();
					result[stack_index.pop()] = index;
					if(stack_value.empty())
						break;
				}
				stack_value.add(temp);
				stack_index.add(index);
			}
			index--;
		}
		
		for(int i = 1; i < count; i++) {
			System.out.print(result[i] + " ");
		}
		System.out.println(result[count]);
	}
	

}
