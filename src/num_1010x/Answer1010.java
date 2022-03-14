package num_1010x;

import java.util.Scanner;

public class Answer1010 {
	static public long combination(int input) {
		long result = 1;
		int x = input;
		
		for(int i = 0; i < x-1; i++) {
			result *= input;
			input--;
		}
		System.out.println(result);
		return result;
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int count = input.nextInt();
		long[] results = new long[count];
		int i = 0;
		int j = 0;
		
		while(i < count) {
			int left = input.nextInt();
			int right = input.nextInt();
			
			long result_1 = combination(right);
			long result_2 = combination(left);
			long result_3 = combination(right-left);
			long result = result_1 / (result_2 * result_3);
			System.out.println(result);
			i++;
		}
	}

}
