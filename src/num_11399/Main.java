package num_11399;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// Answer of BaekJoon no. 11399
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int count = Integer.parseInt(br.readLine());
		int[] input_array = new int[count];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int sum = 0;
		int result = 0;
		
		for(int i = 0; i < count; i++) {
			input_array[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(input_array);
		
		for(int i = 0; i < count; i++) {
			sum += input_array[i];
			result += sum;
		}
		
		bw.write(result+"");
		bw.flush();
		bw.close();

	}

}
