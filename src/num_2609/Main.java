package num_2609;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		// Answer of BaekJoon no. 2609
		
		BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
		int gcd = 0;
		int lcd = 0;
		int first, second;
		int temp, left, right;
		String[] input = scan.readLine().split(" ");
		
		first = Integer.parseInt(input[0]);
		second = Integer.parseInt(input[1]);
		left = first;
		right = second;
		
		while(right != 0) {
			temp = left%right;
			left = right;
			right = temp;
		}
		gcd = left;
		lcd = first*second/gcd;
		System.out.println(gcd);
		System.out.println(lcd);
	}

}
