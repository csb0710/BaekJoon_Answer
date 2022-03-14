package num_1037;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Answer1037 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int all = scan.nextInt();
		ArrayList<Integer> ar = new ArrayList<>();
		
		for (int i = 0; i < all; i++)   {  
			ar.add(scan.nextInt());
		}
		
		Collections.sort(ar);
		
		int result = (ar.get(0) * ar.get(ar.size()-1));
		System.out.println(result);
	}

}
