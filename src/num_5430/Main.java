package num_5430;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// Answer of BaekJoon no. 5430
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		int count = Integer.parseInt(br.readLine());
		char[] inst;
		String[] nums;
		boolean check = true;
		int front = 0;
		int rear = 0;
		StringTokenizer st;
		boolean check2 = true;
		
		for(int i = 0; i < count; i++) {
			StringBuilder sb = new StringBuilder();
			sb.append("[");
			inst = br.readLine().toCharArray();
			int count2 = Integer.parseInt(br.readLine());
			nums = new String[count2];
			st = new StringTokenizer(br.readLine(), "[|]|,");
			front = 0;
			rear = nums.length-1;
			check = true;
			check2 = true;
			
			for(int k = 0 ; k < count2; k++) {
				nums[k] = st.nextToken();
			}
			
			for(int j = 0; j < inst.length; j++) {
				if(inst[j] == 'R') {
					if(check) {
						check = false;
					}
					else {
						check = true;
					}
				}
				else {
					if(front > rear) {
						bw.write("error\n");
						check2 = false;
						break;
					}
					if(check) {
						front++;
					}
					else {
						rear--;
					}
				}
			}
			while(front <= rear) {
				if(check) {
					sb.append(nums[front] + ",");
					front++;
				}
				else {
					sb.append(nums[rear] + ",");
					rear--;
				}
			}
			if(sb.charAt(sb.length()-1) == ',')
				sb.deleteCharAt(sb.length()-1);
			sb.append("]");
			if(check2)
				bw.write(sb.toString() + "\n");
		}
		
		
		bw.flush();
		bw.close();
	}

}
