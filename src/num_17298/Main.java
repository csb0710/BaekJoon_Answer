package num_17298;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// Answer of BaekJoon no. 17298
		
		BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int count = Integer.parseInt(scan.readLine());
		Stack<int[]> stack = new Stack<>();
		int[] result = new int[count+1];
		
		String token = scan.readLine();
		StringTokenizer stk = new StringTokenizer(token);
		int[] a = {Integer.parseInt(stk.nextToken()), 1}; 
		stack.add(a);
		
		for(int i = 2; i <= count; i++) {
			int temp = Integer.parseInt(stk.nextToken());
			int[] temp_list = {temp, i};
			while(stack.peek()[0] < temp) {
				result[stack.peek()[1]] = temp;
				stack.pop();
				if(stack.empty())
					break;
			}
			stack.add(temp_list);
		}
		
		for(int i = 1; i < count; i++) {
			if(result[i] == 0)
				result[i] = -1;
			bw.write(Integer.toString(result[i]) + " ");
		}
		if(result[count] == 0)
			result[count] = -1;
		bw.write(Integer.toString(result[count]));
		bw.flush();
		bw.close();
	}

}
