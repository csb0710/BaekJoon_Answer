package Answer1;

import java.util.Scanner;

public class Sort1 {
	static private int Max_Size = 1000;
	static int[] input = new int[Max_Size];
	public static int[] select_array(int n, int[] input) {
		for(int i = 0; i < n; i++) {
			int min = i;
			for(int j = i + 1; j < n; j++) {
				if(input[j] < input[min])
					min = j;
			}
			int current = input[i];
			input[i] = input[min];
			input[min] = current;
		}
		
		return input;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		for(int i = 0; i < n; i++) {
			int element = scan.nextInt();
			input[i] = element;
		}
		select_array(n, input);
		for(int i = 0; i < n; i++)
			System.out.println(input[i]);
	}

}
