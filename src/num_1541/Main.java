package num_1541;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// Answer of BaekJoon no. 1541
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String insert = br.readLine();
		int sum = 0;
		char check = '+';
		String result = "";
		
		char[] inst = insert.toCharArray();
		
		for(int i = 0; i < inst.length; i++) {
			 if(inst[i] == '+') {
				 if(check == '+') {
					 sum += Integer.parseInt(result);
					 
				 }
				 else {
					 sum -= Integer.parseInt(result);
				 }
				 result = "";
			 }
			 else if(inst[i] == '-') {
				 if(check == '+') {
					 check = '-';
					 sum += Integer.parseInt(result);
				 }
				 else {
					 sum -= Integer.parseInt(result);
				 }
				 result = "";
				 
			 }
			 else {
				 result += inst[i];
			 }
		}
		if(check == '+') {
			sum += Integer.parseInt(result);
		}
		else {
			sum -= Integer.parseInt(result);
		}
		
		bw.write(sum+"");
		bw.flush();
		bw.close();
	}

}
