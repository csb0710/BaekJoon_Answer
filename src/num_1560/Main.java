package num_1560;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// Answer of BaekJoon no. 1560
		
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		BigInteger count = new BigInteger(input);
		BigInteger two = new BigInteger("2");
		BigInteger result = new BigInteger("1");
		
		if(!input.equals("1")) {
			result = count.multiply(two).subtract(two);
		}
		System.out.println(result);

	}

}
