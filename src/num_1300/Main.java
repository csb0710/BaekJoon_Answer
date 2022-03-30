package num_1300;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int[][] d= new int[4][4];
		
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				System.out.println(i*j);
			}
		}
		
	}

}
