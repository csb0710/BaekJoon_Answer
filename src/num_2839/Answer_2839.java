package num_2839;

import java.util.Scanner;

public class Answer_2839 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int input = scan.nextInt();
		int max_5 = 0;
		
		for(int i = 0; i*5 <= input; i++) {
			if((input - 5*i)%3 == 0) {
				max_5 = i;
			}
		}
		
		int temporary = (input-5*max_5)%3;
		int max_3 = (input-5*max_5)/3;
		if(temporary != 0) 
			System.out.println("-1");
		else 
			System.out.println(max_5+max_3);
		
		
	}

}
