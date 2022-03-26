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
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int count = Integer.parseInt(scan.readLine());
		int[] towers = new int[count+1];
		Stack<Integer> stack = new Stack<>();
		int top = 0;
		
		String token = scan.readLine();
		StringTokenizer stk = new StringTokenizer(token);
	
		for(int i = 1; i <= count; i++) {
			boolean check = false;
			top++;
			int insert = Integer.parseInt(stk.nextToken());
			towers[top] = insert;
			stack.push(insert);
//			for(int j = top-1; j > 0; j--) {
//				if(towers[top] <= towers[j]) {
//					bw.write(Integer.toString(j) + " ");
//					check = true;
//					break;
//				}
//			}
//			while(!stack.empty()) {
//				int index = stack.size()-1;
//				int top__ = stack.size();
//				int 
//				if(towers[top__]stack.pop())
//			}
			if(!check) 
				bw.write("0 ");
		}
		bw.flush();
		bw.close();
	}
	

}
