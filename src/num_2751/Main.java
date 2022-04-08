package num_2751;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		boolean[] sort = new boolean[2000001];
		int count = Integer.parseInt(br.readLine());
		int[] input = new int[count];
		int insert;
		
		for(int i = 0; i < count; i++) {
			insert = Integer.parseInt(br.readLine());
			sort[insert + 1000000] = true;
		}
		for(int i = 0; i < sort.length; i++) {
			if(sort[i]) {
				bw.write((i - 1000000) + "\n");
			}
		}
		
		bw.flush();
		bw.close();
		
	}

}
