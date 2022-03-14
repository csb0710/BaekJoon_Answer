package num_1292;

import java.util.Scanner;

public class Answer1292 {

	public static void main(String[] args) {
		int answer1, answer2;
		Scanner scan = new Scanner(System.in);
		answer1 = scan.nextInt();
		answer2 = scan.nextInt();
		int count = 0;
		int i = 0;
		int sum = 0;
		
		
		
		while(true) {
			i++;
			for(int k = 0; k < i; k++) {
				count++;
				if(count >= answer1 && count <= answer2) {
					sum += i;
					if(count == answer2) {
						System.out.println(sum);
						return;
					}
				}
			}
		}
		
		
		
	}

}
