package num_1193;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int input = scan.nextInt();
		int count=1;
		boolean check = true;
		for(int i = 1; i < input; i++) {
			input -= i;
			if(check) 
				check = false;
			else if(!check)
				check = true;
			count++;
		}
		if(!check)
			System.out.println(input + "/" + (count - input + 1));
		else
			System.out.println((count - input + 1) + "/" + input);

	}

}
