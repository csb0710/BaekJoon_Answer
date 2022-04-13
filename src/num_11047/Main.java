package num_11047;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		// Answer of BaekJoon no. 11047
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] input = br.readLine().split(" ");
		
		int count = Integer.parseInt(input[0]);
		int figure = Integer.parseInt(input[1]);
		int[] moneys = new int[count];
		int counting = 0;
		
		for(int i = 0; i < count; i++) {
			moneys[i] = Integer.parseInt(br.readLine());
		} 
		
		for(int i = count-1; i >= 0; i--) {
			counting += (figure/moneys[i]);
			figure = figure%moneys[i];
		}
		
		bw.write(counting + "");
		bw.flush();
		bw.close();
	}

}
