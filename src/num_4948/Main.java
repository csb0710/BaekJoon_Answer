package num_4948;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		ArrayList<Boolean> list = new ArrayList<>();
		int[] inputs = new int[123457];
		
		int count = 0;
		int input = 0;
		int max = 0;
		int index = 0;
		list.add(false);
		
		do {
			input = Integer.parseInt(br.readLine());
			inputs[index] = input;
			index++;
			if(max < input) {
				max = input;
			}
		} while(input != 0);
		
		
		for(int i = 1; i < 2*max+1; i++) {
			list.add(true);
		}
		for(int i = 2; i * i <= 2*max; i++) {
			if(list.get(i)) {
				for(int j = i * i; j <= 2*max; j += i) {
					list.set(j, false);
				}
			}
		}
		
		
		for(int i = 0; i < index-1; i++) {
			count = 0;
			int length = inputs[i];
			for(int j = length+1; j <= 2*length; j++) {
				if(list.get(j)) {
					count++;
				}
			}
			bw.write(count + "\n");
		}
		
		bw.flush();
		bw.close();
	}

}
