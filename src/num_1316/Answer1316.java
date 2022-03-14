package num_1316;

import java.util.ArrayList;
import java.util.Scanner;

public class Answer1316 {

	public static void main(String[] args) {
		ArrayList<Character> ar = new ArrayList<>();
		Scanner scan = new Scanner(System.in);
		int count = scan.nextInt();
		scan.nextLine();
		int i;
		int result = 0;
		
		while(count > 0) {
			String str = scan.nextLine();
			char[] chs = str.toCharArray();
	
			for(i = 0; i < chs.length; i++) {
				if(ar.contains(chs[i]) && ar.get(ar.size()-1) != chs[i]) {
					break;
				}
				ar.add(chs[i]);
			}
			if(i == chs.length)
				result++;
			
			ar.clear();
			count--;
		}
		System.out.println(result);

	}

}
