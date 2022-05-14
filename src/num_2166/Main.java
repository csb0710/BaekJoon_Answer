package num_2166;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// Answer of BaekJoon no. 2166
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int count = Integer.parseInt(br.readLine());
		double[] x = new double[count];
		double[] y = new double[count];
		double sum = 0;
		double sum2 = 0;
		
		for(int i = 0; i < count; i++) {
			String[] input = br.readLine().split(" ");
			double first = Integer.parseInt(input[0]);
			double second = Integer.parseInt(input[1]);
			
			x[i] = first;
			y[i] = second;
		}
		
		for(int i = 0; i < count-1; i++) {
			sum += x[i] * y[i+1];
			sum2 += y[i] * x[i+1];
		}
		sum += x[count-1]*y[0];
		sum2 += y[count-1]*x[0];

		String area = String.format("%.1f", (Math.abs(sum - sum2) / 2.0));
		System.out.println(area);

	}

}
