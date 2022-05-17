package num_10827;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

public class Main {

	public static void main(String[] args) throws IOException {
		// Answer of BaekJoon no. 10827
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] inputs = br.readLine().split(" ");
		
		double a = Double.parseDouble(inputs[0]);
		int b = Integer.parseInt(inputs[1]);
		
		BigDecimal bd = new BigDecimal(inputs[0]);
		bd = bd.pow(b);
		
		System.out.println(bd.toPlainString());

	}

}
