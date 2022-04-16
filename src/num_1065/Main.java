package num_1065;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	
	public static boolean check(int input) {
		String[] temp = Integer.toString(input).split("");
		int gap = Integer.parseInt(temp[0]) - Integer.parseInt(temp[1]);
		
		for(int i = 2; i < temp.length; i++) {
			if(Integer.parseInt(temp[i-1]) - Integer.parseInt(temp[i]) != gap) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		//	Answer of BaekJoon no. 1065
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int input = Integer.parseInt(br.readLine());
		int result = 0;
		
		if(input <= 99) {
			result = input;
		}
		else {
			result = 99;
			for(int i = 100; i <= input; i++) {
				if(check(i)) {
					result++;
				}
			}
		}
		
		bw.write(result+"");
		bw.flush();
		bw.close();
	}

}
